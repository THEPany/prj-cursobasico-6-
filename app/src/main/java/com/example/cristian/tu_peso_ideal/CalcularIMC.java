package com.example.cristian.tu_peso_ideal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class CalcularIMC extends AppCompatActivity implements View.OnClickListener  {
    private Spinner mSpinner;
    private String[] data = {"Dog", "Cat", "Mouse"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_imc);
        getSupportActionBar().setTitle(getIntent().getStringExtra("PRUEBA"));
        mSpinner = (Spinner) findViewById(R.id.my_complexión);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);
        findViewById(R.id.my_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this,  mSpinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
    }
}
