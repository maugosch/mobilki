package com.example.sony.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.sony.androidproject.LoginActivity.M_EMAIL;

public class Modele extends AppCompatActivity {
    private String mEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modele);

        Intent intent = getIntent();
        mEmail = intent.getStringExtra("the email");


        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.wynik);
        textView.setText("WITAJ " + mEmail);
    }

    public void modelAltman(View view) {
        Intent but6 = new Intent(Modele.this, ModelAltman.class);
        but6.putExtra("the email", mEmail);
        startActivity(but6);
    }

    public void modelHolda(View view) {
        Intent but7 = new Intent(Modele.this, ModelHolda.class);
        but7.putExtra("the email", mEmail);
        startActivity(but7);
    }
}
