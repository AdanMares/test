package com.adanmares.test;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class Combinaciones extends AppCompatActivity {
    Button btnCalCombinaciones,btnMenu;
    EditText etPalabra;
    String palabra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combinaciones);
        btnCalCombinaciones = (Button) findViewById(R.id.btn_CalCombinaciones);
        btnMenu =(Button) findViewById(R.id.btn_MenuCombinaciones);
        etPalabra = (EditText) findViewById(R.id.et_palabra);
        //Boton que activa el calculo de ocnbinaciones de palabras
        btnCalCombinaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                palabra = etPalabra.getText().toString();
                combinacionesPalabras(palabra);
            }
        });
        //Boton de redirrecion al Menu principal
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private void combinacionesPalabras(String palabra){
        char[] charPalabra = palabra.toCharArray();
        List<String> comPal = new ArrayList<String>();
        String pal,arreglo = "";
        for (int i = 0; i<palabra.length();i++){
            pal = ""+charPalabra[i];
            comPal.add(pal);
            for (int j = i+1; j<palabra.length(); j++){
                for (int k = j; k<palabra.length(); k++){
                    comPal.add(pal+charPalabra[k]);
                }
                pal += charPalabra[j];
            }
        }
        for (int i =0; i<comPal.size();i++){
            arreglo +=comPal.get(i)+", ";
        }
        verArreglo(arreglo);
    }
    private void verArreglo(String arreglo){
        new AlertDialog.Builder(this).setTitle("Combinaciones").setMessage(arreglo).show();

    }
}