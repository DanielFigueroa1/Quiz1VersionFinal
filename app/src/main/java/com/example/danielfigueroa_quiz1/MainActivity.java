package com.example.danielfigueroa_quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button Registrar;
    private TextView TextoRegistros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Registrar=findViewById(R.id.Registrar);
        TextoRegistros=findViewById(R.id.TextoRegistros);

        Registrar.setOnClickListener(
                (v)->{

                    Intent i = new Intent(this, RegistroActivity.class);
                    startActivity(i); //pasar a la sig.pantalla.
                }
        );
    }
    protected void onResume(){
        super.onResume();
        SharedPreferences preferences = getSharedPreferences("preferencias",MODE_PRIVATE);
        String record = preferences.getString("registro","");
        String[]datosprevios=record.split(":");
        for (int i=0 ; i<datosprevios.length ; i++){
            TextoRegistros.append(datosprevios[i] + "\n"); //textview donde cambia
            //Log.e("test","funciono"+datosprevios[i]);
        }

    }
}