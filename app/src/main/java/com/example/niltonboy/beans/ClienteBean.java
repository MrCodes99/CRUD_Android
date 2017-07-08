package com.example.niltonboy.beans;

import java.io.Serializable;

/**
 * Created by NILTON BOY on 13/06/2017.
 */

public class ClienteBean implements Serializable{
    // Declaramos los atributos para el cliente
    private String codigo;
    private String nombre;
    private String apellido;
    private String correo;
    private String edad;
    private String sexo;

    //
    public String toString(){return codigo+" " +nombre+" "+apellido+ " "+edad;}

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
