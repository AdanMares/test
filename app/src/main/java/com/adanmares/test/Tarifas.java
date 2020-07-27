package com.adanmares.test;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Tarifas extends AppCompatActivity {

    int[][] fares = {{0,15,60,1,1},{1,7,30,5,2},{2,4,15,1,3},{3,2,60,1,3}};
    Button btnCalcular,btnMenu;
    EditText tnHoras;
    double horas=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarifas);
        tnHoras = (EditText) findViewById(R.id.tn_horas);
        btnCalcular = (Button) findViewById(R.id.btn_calcular);
        btnMenu = (Button) findViewById(R.id.btn_MenuTarifas);
        //Boton que activa el calculo de la tarifa
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //recopilacion de la hora en formato double
                horas = Double.parseDouble(tnHoras.getText().toString());
                calcular(horas);
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
    //funcion calculadora de tarifa segun horas
    private void calcular(double horas){
        double minutos = horas * 60;
        int bloque = 0;
        double tarifa = 0;
        int repeticiones=0;
        while (minutos>0){
            repeticiones++;
            tarifa += fares[bloque][1];
            minutos -= fares[bloque][2];
            if(repeticiones == fares[bloque][3]){
                bloque = fares[bloque][4];
                repeticiones = 0;
            }
        }
        verTarifa(tarifa);
    }
    //funcion de despliegue de tarifa mediante un AlertDialog
    private void verTarifa(double tarifa){
        new AlertDialog.Builder(this).setTitle("Tarifa").setMessage("$"+tarifa).show();

    }
}