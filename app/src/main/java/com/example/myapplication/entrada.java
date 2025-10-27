package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

public class entrada extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrada);
        if (Build.VERSION.SDK_INT >= 21){
            //Cambio el color de la barra de estadoss
            //getWindow().setNavigationBarColor(getResources().getColor(R.color.azul));
            //Cambio el color de la barra de estado arriba
            getWindow().setStatusBarColor(getResources().getColor(R.color.black));
        }
        //Cambio de pantalla a inicio - Presentacion -
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(entrada.this, Inicio.class);
                startActivity(intent);
                finish();
            }
        }, 4000);
    }
}