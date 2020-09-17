package com.example.danielfigueroa_quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;

public class SintomasActivity extends AppCompatActivity {

    private CheckBox SintomasOpcion1;
    private CheckBox SintomasOpcion2;
    private CheckBox SintomasOpcion3;
    private CheckBox SintomasOpcion4;
    private CheckBox SintomasOpcion5;
    private CheckBox SintomasOpcion6;
    private CheckBox SintomasOpcion7;
    private Button FinalizarSintomas;
    private String registros;
    private String identificacion;
    private int puntajeNexo;
    private int puntajeSintoma;
    private int puntajeTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sintomas);
        SintomasOpcion1=findViewById(R.id.SintomasOpcion1);
        SintomasOpcion2=findViewById(R.id.SintomasOpcion2);
        SintomasOpcion3=findViewById(R.id.SintomasOpcion3);
        SintomasOpcion4=findViewById(R.id.SintomasOpcion4);
        SintomasOpcion5=findViewById(R.id.SintomasOpcion5);
        SintomasOpcion6=findViewById(R.id.SintomasOpcion6);
        SintomasOpcion7=findViewById(R.id.SintomasOpcion7);
        FinalizarSintomas=findViewById(R.id.FinalizarSintomas);

        registros = getIntent().getExtras().getString("usuario");
        identificacion = getIntent().getExtras().getString("contrasena");
        puntajeNexo=getIntent().getExtras().getInt("puntajesNexo");
        puntajeSintoma = 0;


        FinalizarSintomas.setOnClickListener(
                (v)->{

                    if (SintomasOpcion1.isChecked()==true){
                        puntajeSintoma += 4;
                    }
                    if (SintomasOpcion2.isChecked()==true){
                        puntajeSintoma += 4;
                    }
                    if (SintomasOpcion3.isChecked()==true){
                        puntajeSintoma += 4;
                    }
                    if (SintomasOpcion4.isChecked()==true){
                        puntajeSintoma += 4;
                    }
                    if (SintomasOpcion5.isChecked()==true){
                        puntajeSintoma += 4;
                    }
                    if (SintomasOpcion6.isChecked()==true){
                        puntajeSintoma += 4;
                    }
                    if (SintomasOpcion7.isChecked()==true){
                        puntajeSintoma += 0;
                    }



                    puntajeTotal = (puntajeNexo+puntajeSintoma);
                    String puntaje=String.valueOf(puntajeTotal);
                    SharedPreferences preferences = getSharedPreferences("preferencias",MODE_PRIVATE);
                    String record = preferences.getString("registro","");
                    String registro = record+":"+registros+" "+identificacion+" "+puntaje;
                    preferences.edit().putString("registro",registro).apply();

                    Intent i = new Intent(this, MainActivity.class); //intent es una variable
                    startActivity(i);//start activity es un metodo
                }
        );
    }

}