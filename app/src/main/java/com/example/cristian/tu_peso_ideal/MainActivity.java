package com.example.cristian.tu_peso_ideal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button botonIMC;
    Button botonAyuda;
    Button botonAcercaDe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonIMC = (Button) findViewById(R.id.btnIMC);
        botonAyuda = (Button) findViewById(R.id.btnAyuda);
        botonAcercaDe = (Button) findViewById(R.id.AcercaDe);

        botonIMC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myintent = new Intent(MainActivity.this,CalcularIMC.class);
                startActivity(myintent);
            }
        });


        botonAyuda.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myintent = new Intent(MainActivity.this,Ayuda.class);
                startActivity(myintent);
            }
        });

        botonAcercaDe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myintent = new Intent(MainActivity.this,AcercaDe.class);
                startActivity(myintent);
            }
        });


    }

}
