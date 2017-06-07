package com.example.cristian.tu_peso_ideal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;




public class CalcularIMC extends AppCompatActivity  {

    private Spinner selectGenero, selectComplexion, selectAltura, selectPeso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_imc);

        // Referenciar los SELECT(Spinner) con sus id correspondiente
        selectGenero = (Spinner) findViewById(R.id.my_sex);
        selectComplexion = (Spinner) findViewById(R.id.my_complexión);
        selectAltura = (Spinner) findViewById(R.id.my_altura);
        selectPeso = (Spinner) findViewById(R.id.my_peso);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.genero, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectGenero.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.complexion, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectComplexion.setAdapter(adapter2);


    }



}

/*       @Override
public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.complexion,android.R.layout.simple_spinner_item);
adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
selectComplexion.setAdapter(adapter);

}

@Override
public void onNothingSelected(AdapterView<?> parent) {

}*/