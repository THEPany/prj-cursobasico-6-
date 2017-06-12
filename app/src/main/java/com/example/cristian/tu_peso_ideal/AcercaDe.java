package com.example.cristian.tu_peso_ideal;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.net.http.*;

public class AcercaDe extends AppCompatActivity {
    Button btnAcercaDe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Context context = this;
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);



        btnAcercaDe= (Button) findViewById(R.id.btn_acerca_imc);
        btnAcercaDe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                WebView view = new WebView(context);
                WebSettings settings = view.getSettings();
                settings.setJavaScriptEnabled(true);
                settings.setAppCacheEnabled(true);
                settings.setDatabaseEnabled(true);
                settings.setSupportZoom(true);
                settings.setBuiltInZoomControls(true);
                settings.setJavaScriptCanOpenWindowsAutomatically(true);
                settings.setDomStorageEnabled(true);
                view.setScrollBarStyle(view.SCROLLBARS_INSIDE_OVERLAY);
                view.loadUrl("https://es.wikipedia.org/wiki/%C3%8Dndice_de_masa_corporal");
                view.setWebViewClient(new WebViewClient());
                setContentView(view);




            }
        });


        TextView creditos = (TextView) findViewById(R.id.btn_creditos);
        creditos.setMovementMethod(LinkMovementMethod.getInstance());


        creditos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vista) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setTitle("Créditos");
                alertDialogBuilder
                        .setMessage("Cristian Gómez,  Julio Delgado");
                alertDialogBuilder.setIcon(R.drawable.tick);
                alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                alertDialogBuilder.create();
                alertDialogBuilder.show();

            }

        });





    }

}

