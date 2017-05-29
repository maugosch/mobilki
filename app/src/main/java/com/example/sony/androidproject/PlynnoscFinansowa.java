package com.example.sony.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PlynnoscFinansowa extends AppCompatActivity {

    private String mEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plynnosc_finansowa);

        Intent intent = getIntent();
        mEmail = intent.getStringExtra("the email");
    }

    public void calculatePlynnosc(View view) {
        Intent int1 = new Intent(PlynnoscFinansowa.this, PlynnoscFinansowa2.class);
        int1.putExtra("the email", mEmail);
        startActivity(int1);
    }
}
