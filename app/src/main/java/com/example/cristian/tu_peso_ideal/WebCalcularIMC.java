package com.example.cristian.tu_peso_ideal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.text.DecimalFormat;
import java.util.Random;

public class WebCalcularIMC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intermediary intermediary = new Intermediary();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_calcular_imc);

        WebView view = new WebView(this);
        view.getSettings().setJavaScriptEnabled(true);
        view.setWebViewClient(new WebViewClient());
        view.setWebChromeClient(new WebChromeClient());
        view.loadUrl("file:///android_asset/index.html");
        view.addJavascriptInterface(intermediary,"android");
        setContentView(view);
    }

    class Intermediary {
        DecimalFormat d2f = new DecimalFormat("#.#");

        @JavascriptInterface
        public  String GenerarPeso (double min, double max){
            StringBuilder sb = new StringBuilder("<option value=\"0\" selected>Seleciona un valor</option>");
            String option;
            if(min < max){
                max += 0.1;
                for (double i =  min; i <= max; i +=0.1f) {
                    sb.append("<option value=\""+d2f.format(i)+"\">"+d2f.format(i)+"</option>");
                }
            }

            return option = sb.toString();
        }

    }
}
