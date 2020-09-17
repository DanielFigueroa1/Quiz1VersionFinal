package com.example.danielfigueroa_quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;

public class NexoActivity extends AppCompatActivity {

    private CheckBox NexoOpcion1;
    private CheckBox NexoOpcion2;
    private CheckBox NexoOpcion3;
    private CheckBox NexoOpcion4;
    private CheckBox NexoOpcion5;
    private Button ContinuarNexo;
    private String registros;
    private String identificacion;
    private int puntajeNexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nexo);

        NexoOpcion1=findViewById(R.id.NexoOpcion1);
        NexoOpcion2=findViewById(R.id.NexoOpcion2);
        NexoOpcion3=findViewById(R.id.NexoOpcion3);
        NexoOpcion4=findViewById(R.id.NexoOpcion4);
        NexoOpcion5=findViewById(R.id.NexoOpcion5);
        ContinuarNexo=findViewById(R.id.ContinuarNexo);

        registros = getIntent().getExtras().getString("usuario");
        identificacion = getIntent().getExtras().getString("contrasena");
        puntajeNexo = 0;


         //para chechear

        ContinuarNexo.setOnClickListener(
                (v)->{

                    if (NexoOpcion1.isChecked()==true){
                        puntajeNexo += 3;
                    }
                    if (NexoOpcion2.isChecked()==true){
                        puntajeNexo += 3;
                    }
                    if (NexoOpcion3.isChecked()==true){
                        puntajeNexo += 3; //mas igual tres
                    }
                    if (NexoOpcion4.isChecked()==true){
                        puntajeNexo += 3;
                    }
                    if (NexoOpcion5.isChecked()==true){
                        puntajeNexo += 0;
                    }


                    Intent i = new Intent(this, SintomasActivity.class);
                    i.putExtra("puntajesNexo", puntajeNexo);
                    i.putExtra("usuario", registros);
                    i.putExtra("contrasena", identificacion);
                    //Log.e("usuario","wassup"+ registros);
                    //Log.e("contrasena","wassup"+ identificacion);
                    startActivity(i);
                }
        );
    }
}