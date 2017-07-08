package com.example.niltonboy.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.niltonboy.beans.ClienteBean;
import com.example.niltonboy.conexion.MiConexion;

import java.util.ArrayList;

/**
 * Created by NILTON BOY on 13/06/2017.
 */

public class ClienteDAO {
    Context contexto;

    public  ClienteDAO(Context ctx) {
        contexto = ctx;
    }

    // Metodo para listar cliente
    public ArrayList<ClienteBean> listado(){
        ArrayList<ClienteBean> cliente = new ArrayList<ClienteBean>();
        ClienteBean bean = null;
        MiConexion con = new MiConexion(contexto, null, null, 1);
        SQLiteDatabase sql = con.getReadableDatabase();
        Cursor cur = sql.rawQuery("Select * from tb_cliente",
                new String[]{});

        while(cur.moveToNext()){
            bean = new ClienteBean();
            bean.setCodigo(cur.getString(0));
           // bean.setCodigo(cur.getInt(0));
            bean.setNombre(cur.getString(1));
            bean.setApellido(cur.getString(2));
            bean.setCorreo(cur.getString(3));
            bean.setEdad(cur.getString(4));
            bean.setSexo(cur.getString(5));
           // bean.setEdad(cur.getInt(4));
            cliente.add(bean);
        }
        return cliente;
    }

    // Metodo para adicionar cliente
    public int Agregar(ClienteBean reg){
        int result;
        try{
            MiConexion con = new MiConexion(contexto, null, null, 1);
            SQLiteDatabase sql = con.getWritableDatabase();
            sql.execSQL("INSERT INTO tb_cliente VALUES(?,?,?,?,?,?)",
                    new Object[]{reg.getCodigo(), reg.getNombre(), reg.getApellido(), reg.getCorreo(), reg.getEdad(), reg.getSexo()});
            result =1;
        }catch(Exception e){
            result =-1;
        }
        return result;
    }
    // Metodo para actualizar el ccliente
    public int Editar(ClienteBean reg){
        int result;
        try{
            MiConexion con = new MiConexion(contexto, null, null, 1);
            SQLiteDatabase sql = con.getWritableDatabase();
            sql.execSQL("UPDATE tb_cliente SET nombre=?, apellido=?, correo=?, edad=?, sexo=? where codigo=?",
                    new Object[]{reg.getNombre(), reg.getApellido(), reg.getCorreo(), reg.getEdad(),reg.getSexo(), reg.getCodigo()});
            result =1;
        }catch(Exception e){
            result=-1;
        }
        return result;
    }

    // Metodo pra eliminar cliente por su codigo
    public int Eliminar(String codigo){
        int result;
        try{
            MiConexion con = new MiConexion(contexto, null, null, 1);
            SQLiteDatabase sql = con.getWritableDatabase();
            sql.execSQL("DELETE FROM tb_cliente WHERE codigo=?",
                    new Object[]{codigo});

            result =1;
        }catch(Exception e){
            result =-1;
        }
        return result;
    }

}
