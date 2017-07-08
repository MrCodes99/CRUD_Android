package com.example.niltonboy.practicamovil1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.niltonboy.beans.ClienteBean;
import com.example.niltonboy.dao.ClienteDAO;

public class ClienteRegistrarActivity extends AppCompatActivity implements View.OnClickListener{
    EditText edtcodigo, edtnombre, edtapellido, edtcorreo, edtedad;
    Spinner spnsexo;
    Button btnagregar, btneliminar;

    // Definimos los componentes
    private void iniciaComponente(){
        edtcodigo = (EditText)findViewById(R.id.edtCodigo);
        edtnombre = (EditText)findViewById(R.id.edtNombre);
        edtapellido = (EditText)findViewById(R.id.edtApellido);
        edtcorreo = (EditText)findViewById(R.id.edtCorreo);
        edtedad = (EditText)findViewById(R.id.edtEdad);
        spnsexo = (Spinner)findViewById(R.id.spnSexo);
        btnagregar = (Button)findViewById(R.id.btnAgregar);
        btneliminar = (Button)findViewById(R.id.btnEliminar);

        btnagregar.setOnClickListener(this);
        btneliminar.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_registrar);
        iniciaComponente();

        // Meotodo para recibir los datos
        Intent recibir = getIntent();
        if(recibir.getSerializableExtra("cli")!=null){
            ClienteBean obj=(ClienteBean)recibir.getSerializableExtra("cli");
            edtcodigo.setText(obj.getCodigo());
            edtnombre.setText(obj.getNombre());
            edtapellido.setText(obj.getApellido());
            edtcorreo.setText(obj.getCorreo());
            edtedad.setText(obj.getEdad());
            spnsexo.setSelected(Boolean.parseBoolean(obj.getSexo().toString()));
            btnagregar.setText("EDITAR CLIENTE");
            edtcodigo.setEnabled(false);
        }else{
            btnagregar.setText("GRABAR CLIENTE");
            btneliminar.setEnabled(false);
        }
    }

    @Override
    public void onClick(View v) {
        // Programar boton grabar
        if(v== btnagregar){
            ClienteDAO dao = new ClienteDAO(this);
            ClienteBean cli = new ClienteBean();
            //
           //cli.setCodigo(Integer.getInteger(edtcodigo.getText().toString()));
           // cli.setCodigo(Integer.parseInt(edtcodigo.getText().toString()));
            cli.setCodigo(edtcodigo.getText().toString());
            cli.setNombre(edtnombre.getText().toString());
            cli.setApellido(edtapellido.getText().toString());
            cli.setCorreo(edtcorreo.getText().toString());
            cli.setEdad(edtedad.getText().toString());
            cli.setSexo(spnsexo.getSelectedItem().toString());
            //cli.setEdad(Integer.parseInt(edtedad.getText().toString()));

            int result;
            if(edtcodigo.isEnabled()){
                result = dao.Agregar(cli);
            }else{
                result = dao.Editar(cli);
            }
            Toast.makeText(this, ""+result, Toast.LENGTH_SHORT).show();
            Intent ir = new Intent(this, ClienteListarActivity.class);
            startActivity(ir);
        }
        if(v == btneliminar){
            ClienteDAO dao = new ClienteDAO(this);
            dao.Eliminar(edtcodigo.getText().toString());
            //dao.Eliminar(Integer.parseInt(edtcodigo.getText().toString()));

            Intent ir = new Intent(this, ClienteListarActivity.class);
            startActivity(ir);
        }
    }
}
