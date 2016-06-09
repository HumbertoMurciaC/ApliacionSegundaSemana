package com.example.humbertomariom.proyecto1;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    int Year;
    int month;
    int day;
    static final int DIALOG_ID=0;
    final Calendar fecha_actual = Calendar.getInstance();
    TextView Tv_Fecha;
    EditText Et_Nombre;
    EditText Et_Telefono;
    EditText Et_Mail;
    EditText Et_Descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b_siguiente = (Button) findViewById(R.id.bSiguiente);

        Et_Nombre = (EditText) findViewById(R.id.etNombre);
        Et_Telefono = (EditText) findViewById(R.id.etTelefono);
        Et_Mail = (EditText) findViewById(R.id.etEmail);
        Et_Descripcion = (EditText) findViewById(R.id.EtDescripcion);
        Tv_Fecha= (TextView) findViewById(R.id.TvFecha);

        Bundle datos = getIntent().getExtras();

        if(datos != null){

            Tv_Fecha.setText(datos.getString("Fecha1"));
            Et_Nombre.setText(datos.getString("Nombre1"));
            Et_Mail.setText(datos.getString("Mail1"));
            Et_Descripcion.setText(datos.getString("Descripcion1"));
            Et_Telefono.setText(datos.getString("Telefono1"));

        }
        else {
            Year = fecha_actual.get(Calendar.YEAR);
            month = fecha_actual.get(Calendar.MONTH) + 1;
            day = fecha_actual.get(Calendar.DAY_OF_MONTH);

            final String fecha = day + "/" + month + "/" + Year;

            Tv_Fecha.setText(fecha);

        }

        mostrarDatePicker();

        b_siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Activity2.class);

                intent.putExtra("Nombre",Et_Nombre.getText().toString());
                intent.putExtra("Telefono",Et_Telefono.getText().toString());
                intent.putExtra("Mail",Et_Mail.getText().toString());
                intent.putExtra("Descripcion",Et_Descripcion.getText().toString());
                intent.putExtra("Fecha",Tv_Fecha.getText().toString());

                startActivity(intent);

                finish();
            }
        });

    }

    public void mostrarDatePicker(){

        Button b_sfecha = (Button) findViewById(R.id.B_Fecha);

        b_sfecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DIALOG_ID);
            }
        });

    }

    @Override
    protected Dialog onCreateDialog(int id) {

        if(id == DIALOG_ID){

            return new DatePickerDialog(this,R.style.DatePickerDialog,datepickerListener, Year,month,day);
        }

        return null;
    }

    private DatePickerDialog.OnDateSetListener datepickerListener = new DatePickerDialog.OnDateSetListener(){
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth){

            Year = year;
            month = monthOfYear+1;
            day = dayOfMonth;

            String fecha1 = day+"/"+month+"/"+Year;

            Tv_Fecha.setText(fecha1);

        }
    };


}
