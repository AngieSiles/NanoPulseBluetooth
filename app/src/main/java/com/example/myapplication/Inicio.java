package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.hp.bluetoothjhr.BluetoothJhr;

public class Inicio extends AppCompatActivity {
    //Variables declara mostrar y ver
    ListView Listadis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        if (Build.VERSION.SDK_INT >= 21){
            //Cambio el color de la barra de estados
            //getWindow().setNavigationBarColor(getResources().getColor(R.color.purple_500));
            //Cambio el color de la barra de estado arriba
            getWindow().setStatusBarColor(getResources().getColor(R.color.black));
            // getWindow().setColorMode(getResources().getColor(R.color.purple_200));
        }
        //ENLAZO DISPOSITIVO CON EL
        Listadis = (ListView)findViewById(R.id.Listadis);
        //MUESTRO LOS DISPOSITIVOS VINCULADOS
        final BluetoothJhr bluetoothJhr = new BluetoothJhr(this, Listadis);
        //ENCENDEMOS EL BLUETOOTH
        bluetoothJhr.EncenderBluetooth();
        //UNA VEZ SELECCIONADO VINCULARLO 
        Listadis.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                bluetoothJhr.Disp_Seleccionado(view,position,conexion.class);
            }
        });
    }

}