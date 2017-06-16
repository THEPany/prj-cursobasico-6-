package com.example.cristian.tu_peso_ideal;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton botonIMC;
    ImageButton botonAyuda;
    ImageButton botonAcercaDe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonIMC = (ImageButton) findViewById(R.id.btnIMC);
        botonAyuda = (ImageButton) findViewById(R.id.btnAyuda);
        botonAcercaDe = (ImageButton) findViewById(R.id.AcercaDe);

        botonIMC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myintent = new Intent(MainActivity.this,WebCalcularIMC.class);
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

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("¿Desea salir?")
                .setMessage("¿Estas seguro de que realmente deseas salir?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        MainActivity.super.onBackPressed();
                    }
                }).create().show();
    }

}
