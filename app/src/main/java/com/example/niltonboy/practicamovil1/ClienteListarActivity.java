package com.example.niltonboy.practicamovil1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.niltonboy.beans.ClienteBean;
import com.example.niltonboy.dao.ClienteDAO;

import java.util.ArrayList;

public class ClienteListarActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener{
    Button btnnuevo;
    ListView lsvcliente;

    // Iniciamos los componentes
    private void iniciaComponentes(){
        btnnuevo = (Button)findViewById(R.id.btnNuevoCliente);
        lsvcliente = (ListView)findViewById(R.id.lsvCliente);

        btnnuevo.setOnClickListener(this);
        lsvcliente.setOnItemClickListener(this);
    }
    // metodo para cargar los clientes
    private void cargarCliente(){
        ClienteDAO dao = new ClienteDAO(this);
        ArrayList<ClienteBean> clientes = dao.listado();
        ArrayAdapter<ClienteBean> adapter = new ArrayAdapter<ClienteBean>(this, android.R.layout.simple_list_item_1,clientes);
        lsvcliente.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_listar);
        iniciaComponentes();
        cargarCliente();
    }

    @Override
    public void onClick(View v) {
        if(v== btnnuevo){
            Intent ir = new Intent(this, ClienteRegistrarActivity.class);
            startActivity(ir);
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Este metodo sirve para seleccionar un registro del ListView
        ClienteBean obj = (ClienteBean)lsvcliente.getItemAtPosition(position);
        Intent ir = new Intent(this,ClienteRegistrarActivity.class);
        ir.putExtra("cli",obj);
        startActivity(ir);
    }
}
