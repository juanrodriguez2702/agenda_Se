    package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.agenda.db.DbContactos;

    public class NuevoActivity extends AppCompatActivity {

    EditText textNombre, textTelefono, textCorreo;
    Button btn_guardar;
    //MenuItem menu_new;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        textNombre = findViewById(R.id.txtNombre);
        textTelefono = findViewById(R.id.txtTelefono);
        textCorreo = findViewById(R.id.txtCorreo);
        btn_guardar = findViewById(R.id.btnGuardarR);
        //menu_new = findViewById(R.id.menu);

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbContactos dbContactos = new DbContactos(NuevoActivity.this);
                long id = dbContactos.insertarContacto(textNombre.getText().toString(),textTelefono.getText().toString(),textCorreo.getText().toString());
                if(id > 0){
                    Toast.makeText(NuevoActivity.this, "REGISTRO AGREGADO", Toast.LENGTH_LONG).show();
                    limpiar();
                }else{
                    Toast.makeText(NuevoActivity.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_LONG).show();

                }
            }
        });

    }

    private void limpiar(){
        textNombre.setText("");
        textTelefono.setText("");
        textCorreo.setText("");
    }

        public void regresar (View view){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
}