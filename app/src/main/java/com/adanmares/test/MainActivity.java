package com.adanmares.test;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnTarifas,btnCombinaciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTarifas = (Button) findViewById(R.id.btn_Tarifas);
        btnCombinaciones = (Button) findViewById(R.id.btn_Combinaciones);
        //Boton de redireccion a la Actividad de Tarifas
        btnTarifas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Tarifas.class);
                startActivity(intent);
            }
        });
        //Boton de redireccion a la actividad de Combinaciones
        btnCombinaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Combinaciones.class);
                startActivity(intent);
            }
        });
    }

}