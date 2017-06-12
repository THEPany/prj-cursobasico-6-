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
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        view = (WebView) findViewById(R.id.wview);

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
        view.loadUrl("https://www.vitonica.com/anatomia/todo-sobre-el-indice-de-masa-corporal-y-el-de-grasa");
        view.setWebViewClient(new WebViewClient());
        setContentView(view);

    }
}
