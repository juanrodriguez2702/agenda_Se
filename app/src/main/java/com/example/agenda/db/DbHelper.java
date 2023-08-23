package com.example.agenda.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "agenda.db";
    public static final String Table_contacto = "t_contactos";
    @Override
    public void onCreate(SQLiteDatabase SQLiteDatabase) {
        SQLiteDatabase.execSQL("CREATE TABLE " + Table_contacto + "(" +
        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
        "nombre TEXT NOT NULL," +
        "telefono TEXT NOT NULL," +
        "correo_electronico TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase SQLiteDatabase, int oldVersion, int newVersion) {
        SQLiteDatabase.execSQL("DROP TABLE " + Table_contacto);
        onCreate(SQLiteDatabase);

    }
}
