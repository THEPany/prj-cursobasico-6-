package com.example.cristian.tu_peso_ideal;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import java.text.DecimalFormat;

public class WebCalcularIMC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intermediary intermediary = new Intermediary();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_calcular_imc);
        /*Inicio WebView*/
        WebView view = new WebView(this);
        view.getSettings().setJavaScriptEnabled(true); //Habilitar JavaScript
        view.setWebViewClient(new WebViewClient()); //Instanciar WebCliente
        view.loadUrl("file:///android_asset/index.html"); //Ruta de los recursos
        view.addJavascriptInterface(intermediary,"android"); // Clase Java que se añade a la interfaceJavaScript
        setContentView(view); // Pintar el contenido

    }
    /*
    Clase que se usa para comunicarse con javascript
     */
    class Intermediary {
        DecimalFormat d2f = new DecimalFormat("#.#");
        //Retorna los calculos del IMC
        @JavascriptInterface
        public  String CalcularIMC (double peso, double estatura){
            Double imc = peso/(estatura*estatura);
            if(imc < 18.5){
                return "<img src=\"img/PesoInsuficiente.png\" class=\"img-responsive\" ><br><strong style='color:#2196F3;'>Peso insuficiente " + d2f.format(imc) + " imc</strong>";
            }else if (imc >= 18.5 && imc < 25){
                return "<img src=\"img/PesoNormal.png\" class=\"img-responsive\" ><br><strong style='color:#4CAF50;'>Peso normal " + d2f.format(imc) + " imc</strong>";
            }else if (imc >= 25 && imc < 27){
                return "<img src=\"img/PesoSP1.png\" class=\"img-responsive\" ><br><strong style='color:#4CAF50;'>Puede haber sobrepeso grado I " + d2f.format(imc) + " imc</strong>";
            }else if (imc >= 27 && imc < 30){
                return "<img src=\"img/PesoSP1.png\" class=\"img-responsive\" ><br><strong style='color:#FF9800;'>Sobrepeso tipo I " + d2f.format(imc) + " imc</strong>";
            }else if (imc >= 30 && imc < 35){
                return "<img src=\"img/PesoSP2.png\" class=\"img-responsive\" ><br><strong style='color:#FF5722;'>Obesidad tipo I " + d2f.format(imc) + " imc</strong>";
            }else if (imc >= 35 && imc < 40){
                return "<img src=\"img/PesoSP2.png\" class=\"img-responsive\" ><br><strong style='color:#C62828;'>Obesidad tipo II " + d2f.format(imc) + " imc</strong>";
            }else if (imc >= 40 && imc < 50){
                return "<img src=\"img/PesoSP2.png\" class=\"img-responsive\" ><br><strong style='color:#B71C1C;'>Obesidad tipo III " + d2f.format(imc) + " imc</strong>";
            }else if(imc >= 50) {
                return "<img src=\"img/ObesidadExtrema.png\" class=\"img-responsive\" ><br><strong style='color:#D50000;'>Obesidad extrema " + d2f.format(imc) + " imc</strong>";
            }else{
                return "Error IMC No definido" + d2f.format(imc);
            }
        }
        //Retorna la informacion del campo que debe ser completado
        @JavascriptInterface
        public void getAlerta(String valor){
            Toast.makeText(WebCalcularIMC.this,"Debes llenar el campo " + valor, Toast.LENGTH_LONG).show();
        }
        //Retorna los valores de la altura
        @JavascriptInterface
        public String getAltura(){
            StringBuilder sb = new StringBuilder("<option value=\"0\" selected></option>");
            String option;
            sb.append("<option value=\"1.50\">1.50</option>\n" +
                    "<option value=\"1.52\">1.52</option>\n" +
                    "<option value=\"1.54\">1.54</option>\n" +
                    "<option value=\"1.56\">1.56</option>\n" +
                    "<option value=\"1.58\">1.58</option>\n" +
                    "<option value=\"1.60\">1.60</option>\n" +
                    "<option value=\"1.62\">1.62</option>\n" +
                    "<option value=\"1.64\">1.64</option>\n" +
                    "<option value=\"1.66\">1.66</option>\n" +
                    "<option value=\"1.68\">1.68</option>\n" +
                    "<option value=\"1.70\">1.70</option>\n" +
                    "<option value=\"1.72\">1.72</option>\n" +
                    "<option value=\"1.74\">1.74</option>\n" +
                    "<option value=\"1.76\">1.76</option>\n" +
                    "<option value=\"1.78\">1.78</option>\n" +
                    "<option value=\"1.80\">1.80</option>\n" +
                    "<option value=\"1.82\">1.82</option>\n" +
                    "<option value=\"1.84\">1.84</option>\n" +
                    "<option value=\"1.86\">1.86</option>\n" +
                    "<option value=\"1.88\">1.88</option>\n" +
                    "<option value=\"1.90\">1.90</option>\n" +
                    "<option value=\"1.92\">1.92</option>\n" +
                    "<option value=\"1.94\">1.94</option>");
            return option = sb.toString();

        }
        //Retorna los valores de la complexion
        @JavascriptInterface
        public String getComplexion(){
            StringBuilder sb = new StringBuilder("<label>Complexion</label><br>");
            String option;
            sb.append("<label class=\"radio-inline\"><input type=\"radio\" name=\"complexion\" value=\"peq\">Pequeña</label>" +
                    "<label class=\"radio-inline\"><input type=\"radio\" name=\"complexion\" value=\"med\">Mediana</label>" +
                    "<label class=\"radio-inline\"><input type=\"radio\" name=\"complexion\" value=\"grand\">Grande</label>");
            return option = sb.toString();

        }
        //Retorna los valores del genero
        @JavascriptInterface
        public String getGenero(){
            StringBuilder sb = new StringBuilder("<label>Genero</label><br>");
            String option;
            sb.append("<label class=\"radio-inline\"><input type=\"radio\" name=\"genero\" value=\"hombres\"><img src=\"img/Man.png\"  class=\"img-rounded\"  width=\"100\" height=\"100\"></label>\n" +
                      "<label class=\"radio-inline\"><input type=\"radio\" name=\"genero\" value=\"mujeres\"><img src=\"img/Woman.png\"  class=\"img-rounded\"  width=\"100\" height=\"100\"></label>");
            return option = sb.toString();

        }

    }
}
