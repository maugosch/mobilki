package com.example.sony.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.firebase.client.Firebase;

public class ModelAltman extends AppCompatActivity {

    private String mEmail;
    Firebase mFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_altman);

        Intent intent = getIntent();
        mEmail = intent.getStringExtra("the email");

        Firebase.setAndroidContext(this);
        mFirebase = new Firebase("https://financeapp-7fbe1.firebaseio.com/");

    }

    public void calculate(View view) {
        EditText editText = (EditText) findViewById(R.id.kapitalObrotowyNetto);
        int kon = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.aktywaOgolem);
        int a = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.zyskiZatrzymane);
        int zz = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.ebit);
        int ebit = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.przychodyZeSprzedazy);
        int przychZeSprz = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.kapitalWlasny);
        int kw = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.zobowiazaniaOgolem);
        int zobOg = Integer.parseInt(editText.getText().toString());

        Firebase userRef = mFirebase.child("users/" + mEmail + "/ModelA");
        ResultModelForModels user = new ResultModelForModels(kon, a, zz, ebit, przychZeSprz, kw, zobOg);
        userRef.setValue(user);

        double z = 0.717*(double)kon/(double)a + 0.847*(double)zz/(double)a + 3.107*(double)ebit/(double)a +
                0.42*(double)kw/(double)zobOg + 0.998*(double)przychZeSprz/(double)a;
        String zS = String.valueOf(z);


        Intent int1 = new Intent(ModelAltman.this, ModelAltman2.class);
        int1.putExtra("the email", mEmail);
        int1.putExtra("zet", zS);

        startActivity(int1);
    }


}
