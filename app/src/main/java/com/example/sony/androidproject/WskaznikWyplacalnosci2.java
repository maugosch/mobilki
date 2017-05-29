package com.example.sony.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WskaznikWyplacalnosci2 extends AppCompatActivity {

    private String mEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wskaznik_wyplacalnosci2);

        Intent intent = getIntent();
        mEmail = intent.getStringExtra("the email");
    }
}
