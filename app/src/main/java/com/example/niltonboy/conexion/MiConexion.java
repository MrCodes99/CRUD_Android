package com.example.niltonboy.conexion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by NILTON BOY on 13/06/2017.
 */

public class MiConexion extends SQLiteOpenHelper {
    public MiConexion(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "bdclie", factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String TABLA_CLIENTE="CREATE TABLE tb_cliente (codigo number, nombre text, apellido text, correo text, edad number, sexo text);";

        db.execSQL(TABLA_CLIENTE);
        db.execSQL("INSERT INTO tb_cliente VALUES(123,'Nilton','Ramos Inocente','nilton20@hotmail.com',25,'Masculino');");
        db.execSQL("INSERT INTO tb_cliente VALUES(124,'Jose Luis','Quispe Chavez','joselito25@hotmail.com',20,'Femenino');");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
