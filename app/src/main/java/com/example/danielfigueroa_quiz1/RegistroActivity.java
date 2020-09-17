package com.example.danielfigueroa_quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    private  EditText NombreRegistro;
    private EditText IdentificacionRegistro;
    private Button ContinuarNexo;
    //private registros;
    //private int Puntaje;
    //private String puntajes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        NombreRegistro=findViewById(R.id.NombreRegistro);
        IdentificacionRegistro=findViewById(R.id.IdentificacionRegistro);
        ContinuarNexo=findViewById(R.id.ContinuarNexo);
        //Puntaje = 0;
        //puntajes = String.valueOf(Puntaje);



        ContinuarNexo.setOnClickListener(
                (v)->{
                    SharedPreferences preferences = getSharedPreferences("preferencias",MODE_PRIVATE);
                    String record = preferences.getString("registro","");
                    String registros = NombreRegistro.getText().toString();
                    String identificacion = IdentificacionRegistro.getText().toString();

                    if(record.contains(identificacion)){
                        Toast.makeText(this, "Este usuario ya esta registrado", Toast.LENGTH_SHORT).show();
                    }else {
                        Intent i = new Intent(this, NexoActivity.class);
                        i.putExtra("usuario", registros);
                        i.putExtra("contrasena", identificacion);


                        startActivity(i);
                    }
                }
        );
    }
}