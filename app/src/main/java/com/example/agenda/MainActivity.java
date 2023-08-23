package com.example.agenda;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SearchEvent;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Switch;
import android.widget.Toast;

import com.example.agenda.adaptadores.ListaContactosAdapter;
import com.example.agenda.db.DbContactos;
import com.example.agenda.db.DbHelper;
import com.example.agenda.entidades.Contactos;

import java.util.ArrayList;

//toolbar:
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    //Button btnCrear;
    SearchView txtbuscar;
    RecyclerView listaContactos;
    ArrayList<Contactos>ListadeContactosArray;
    Toolbar toolbar;
    ListaContactosAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtbuscar = findViewById(R.id.Search_buscar);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        listaContactos = findViewById(R.id.listaContactos);
        listaContactos.setLayoutManager(new LinearLayoutManager(this));
        DbContactos dbContactos = new DbContactos(MainActivity.this);

        ListadeContactosArray = new ArrayList<>();


        adapter = new ListaContactosAdapter(dbContactos.mostrarContactos());
        listaContactos.setAdapter(adapter);
        //btnCrear = findViewById(R.id.btnCrear);
        /*
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHelper dbHelper =new DbHelper(MainActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if(db != null) {
                    Toast.makeText(MainActivity.this, "BASE DE DATOS CREADA", Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(MainActivity.this, "ERROR AL CREAR LA BASE DE DATOS", Toast.LENGTH_LONG).show();
                }


            }
        });


*/
        //modificaciones
        txtbuscar.setOnQueryTextListener(this);
        //fin
    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal,menu);
        return true;
    }

    public  boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu){
                nuevoRegistro();
                return true;
        } else {
                return super.onOptionsItemSelected(item);
        }
    }




        private void nuevoRegistro(){
            Intent intent = new Intent(this, NuevoActivity.class);
            startActivity(intent);
        }


    @Override
    public boolean onQueryTextSubmit(String s) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        adapter.filtrado(s);
        return false;
    }
}
