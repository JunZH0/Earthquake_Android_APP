package com.example.proyectot2ad_junzhou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,OnDatosListener {

    Button btnFiltro;
    Button btnConsulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFiltro = findViewById(R.id.btnFilter);
        btnConsulta = findViewById(R.id.btnQuery);

        btnFiltro.setOnClickListener((View.OnClickListener) this);
        btnConsulta.setOnClickListener((View.OnClickListener) this);


    }
    public void onClick(View view) {
        if (view.getId() == R.id.btnFilter) {
            FilterDialog filterDialog = new FilterDialog();
            filterDialog.show(getSupportFragmentManager(), "FilterDialog");
        } else if (view.getId() == R.id.btnQuery) {
            //TODO
        }
    }

    @Override
    public void onDatosListener(String fecha_Hora, String pais) {

    }
}