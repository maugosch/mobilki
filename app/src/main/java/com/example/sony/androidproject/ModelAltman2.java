package com.example.sony.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ModelAltman2 extends AppCompatActivity {

    private TextView zetA;
    String wynikZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_altman2);
        Intent intent = getIntent();
        wynikZ = intent.getStringExtra("zet");


        zetA = (TextView)findViewById(R.id.zetA);
        zetA.setText(wynikZ);
    }
}
