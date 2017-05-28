package com.example.sony.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void wskaznikiFinansowe (View view){
        Intent but8 = new Intent(MainActivity.this, MainMainActivity.class);
        startActivity(but8);
    }

    public void modeleUpadlosci (View view) {
        Intent but9 = new Intent(MainActivity.this, Modele.class);
        startActivity(but9);
    }
}