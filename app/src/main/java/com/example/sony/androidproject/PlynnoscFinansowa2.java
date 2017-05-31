package com.example.sony.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class PlynnoscFinansowa2 extends AppCompatActivity {

    private String mEmail;
    private TextView biezaca, szybka, zaostrzona;
    private String wynikB, wynikS, wynikZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        mEmail = intent.getStringExtra("the email");
        wynikB = intent.getStringExtra("biezaca");
        wynikS = intent.getStringExtra("szybka");
        wynikZ = intent.getStringExtra("zaostrzona");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plynnosc_finansowa2);


        biezaca = (TextView)findViewById(R.id.biezaca);
        biezaca.setText(wynikB);
        szybka = (TextView)findViewById(R.id.szybka);
        szybka.setText(wynikS);
        zaostrzona = (TextView)findViewById(R.id.zaostrzona);
        zaostrzona.setText(wynikZ);
    }
}
