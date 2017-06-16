package com.example.cristian.tu_peso_ideal;

import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;


public class Ayuda extends AppCompatActivity {
        WebView view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Context context = this;
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // para que la pantalla no se voltee
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);
        /*Inicio WebView*/
        view = (WebView) findViewById(R.id.wview);
        WebView view = new WebView(context);
        WebSettings settings = view.getSettings();
        settings.setJavaScriptEnabled(true); // Habilitar JavaScript
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        view.setScrollBarStyle(view.SCROLLBARS_INSIDE_OVERLAY); // Habilitar Scrollbar
        view.loadUrl("file:///android_asset/acerca_del_imc.html"); // Ruta
        view.setWebViewClient(new WebViewClient()); //Instanciar cliente web
        setContentView(view);

    }
}
