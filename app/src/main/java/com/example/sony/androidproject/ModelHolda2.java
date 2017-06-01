package com.example.sony.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ModelHolda2 extends AppCompatActivity {

    private TextView zetH;
    String wynikZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_holda2);

        Intent intent = getIntent();
        wynikZ = intent.getStringExtra("zet");


        zetH = (TextView)findViewById(R.id.zetH);
        zetH.setText(wynikZ);
    }
}
