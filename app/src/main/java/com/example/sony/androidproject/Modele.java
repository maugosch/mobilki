package com.example.sony.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Modele extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modele);
    }

    public void modelAltman(View view) {
        Intent but6 = new Intent(Modele.this, ModelAltman.class);
        startActivity(but6);
    }

    public void modelHolda(View view) {
        Intent but7 = new Intent(Modele.this, ModelHolda.class);
        startActivity(but7);
    }
}
