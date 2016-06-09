package com.example.humbertomariom.proyecto1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Bundle datos = getIntent().getExtras();

        Button b_editar = (Button) findViewById(R.id.bEditar);

        final TextView Nombre = (TextView) findViewById(R.id.TvNombre);
        final TextView Fecha = (TextView) findViewById(R.id.TvFECHA);
        final TextView Telefono = (TextView) findViewById(R.id.TvTelefono);
        final TextView Email = (TextView) findViewById(R.id.TvMail);
        final TextView Descripcion = (TextView) findViewById(R.id.TvDescripcion);

        Nombre.setText(datos.getString("Nombre"));
        Fecha.setText(datos.getString("Fecha"));
        Telefono.setText(datos.getString("Telefono"));
        Email.setText(datos.getString("Mail"));
        Descripcion.setText(datos.getString("Descripcion"));


        b_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity2.this,MainActivity.class);

                intent.putExtra("Nombre1",Nombre.getText().toString());
                intent.putExtra("Telefono1",Telefono.getText().toString());
                intent.putExtra("Mail1",Email.getText().toString());
                intent.putExtra("Descripcion1",Descripcion.getText().toString());
                intent.putExtra("Fecha1",Fecha.getText().toString());


                startActivity(intent);

                finish();
            }
        });

    }
}
