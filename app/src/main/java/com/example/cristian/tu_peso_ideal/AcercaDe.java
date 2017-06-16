package com.example.cristian.tu_peso_ideal;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); //Para que la pantalla no se volte
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);



        btnAcercaDe= (Button) findViewById(R.id.btn_acerca_imc);
        btnAcercaDe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                /*
                * Inicio WebView
                * */
                WebView view = new WebView(context);
                WebSettings settings = view.getSettings();
                settings.setAppCacheMaxSize(5*1024*1024); // 5MB (metodo viejo pero funcional xD)
                settings.setAppCachePath(getApplicationContext().getCacheDir().getAbsolutePath());
                settings.setAllowFileAccess(true);
                settings.setAppCacheEnabled(true); // Habilitar cache
                settings.setJavaScriptEnabled(true);
                settings.setCacheMode(WebSettings.LOAD_DEFAULT); // load online by default
                view.setScrollBarStyle(view.SCROLLBARS_INSIDE_OVERLAY);
                if ( !isNetworkAvailable() ) { // cargar en cache
                    view.getSettings().setCacheMode( WebSettings.LOAD_CACHE_ELSE_NETWORK );
                }
                view.loadUrl("https://es.wikipedia.org/wiki/%C3%8Dndice_de_masa_corporal"); // Ruta de la pagina
                view.setWebViewClient(new WebViewClient()); // Instanciar WebviewCliente
                setContentView(view); // Pintar contenido




            }
        });


        TextView creditos = (TextView) findViewById(R.id.btn_creditos);
        creditos.setMovementMethod(LinkMovementMethod.getInstance());

        /*Autores*/
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
    /*
    * Verifica si hay conexion a internet
    */
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService( CONNECTIVITY_SERVICE );
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}

