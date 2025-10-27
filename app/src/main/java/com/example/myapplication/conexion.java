package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hp.bluetoothjhr.BluetoothJhr;

public class conexion extends AppCompatActivity {
    Button btnGenerar;
    Button btngenrar2;

    EditText ton;
    EditText toff;
    EditText cant;
    //////////////////////////////////////////////////////////////7
    int i = 0;
    BluetoothJhr bluetoothJhr2;
    private ListView consola;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conexion);
        if (Build.VERSION.SDK_INT >= 21){
            //Cambio el color de la barra de estados
            //getWindow().setNavigationBarColor(getResources().getColor(R.color.purple_500));
            //Cambio el color de la barra de estado arriba
            getWindow().setStatusBarColor(getResources().getColor(R.color.black));
        }
        //Mandamos anterior activity por error de conexioin
        bluetoothJhr2 = new BluetoothJhr(Inicio.class, this);
        btnGenerar = findViewById(R.id.button);
        btngenrar2=findViewById(R.id.button2);
        ton=findViewById(R.id.ton);
        toff=findViewById(R.id.toff);
        cant= findViewById(R.id.cantidad);
        btnGenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tonn=ton.getText().toString();
                String tofff= toff.getText().toString();
                String cantidad= cant.getText().toString();
                if(tonn.length() == 0){
                    Toast.makeText(conexion.this, "Ingrese Ton", Toast.LENGTH_LONG).show();
                }
                if(tofff.length() == 0){
                    Toast.makeText(conexion.this, "Ingrese Toff", Toast.LENGTH_LONG).show();
                }
                if(cantidad.length() == 0){
                    Toast.makeText(conexion.this, "Ingrese cantidad", Toast.LENGTH_LONG).show();
                }
                if(tonn.length() != 0 && tofff.length() !=0 && cantidad.length()!=0){
                    bluetoothJhr2.Tx("C" + tonn + "s" + tofff + "s" + cantidad + "s");
                    Toast.makeText(conexion.this, "Enviado!!", Toast.LENGTH_LONG).show();}
            }
        });
        btngenrar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bluetoothJhr2.Tx("P");
                Toast.makeText(conexion.this, "Stop!", Toast.LENGTH_LONG).show();
            }

        });






    }
    @Override
    public void onResume(){
        super.onResume();
        //inicio el programa me conecta al blueetho
        bluetoothJhr2.ConectaBluetooth();
    }
    @Override
    public  void  onPause(){
        super.onPause();
        //Si cierro en segundo plano cierra
        bluetoothJhr2.CierraConexion();
    }
    private void Delay(){
        //asigno el tiempo para que pase 100mseg y esamine los datos que llega
        try {
            Thread.sleep(200);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }


}