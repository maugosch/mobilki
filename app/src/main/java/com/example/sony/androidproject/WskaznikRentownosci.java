package com.example.sony.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.firebase.client.Firebase;

public class WskaznikRentownosci extends AppCompatActivity {

    private String mEmail;
    Firebase mFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wskaznik_rentownosci);

        Intent intent = getIntent();
        mEmail = intent.getStringExtra("the email");

        Firebase.setAndroidContext(this);
        mFirebase = new Firebase("https://financeapp-7fbe1.firebaseio.com/");

    }

    public void calculate(View view) {
        EditText editText = (EditText) findViewById(R.id.zyskBiezacy);
        int zyskBiez = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.strataZLatUbieglych);
        int strata = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.kapitalWlasny);
        int kw = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.kosztUzyskaniaPrzychodow);
        int kup = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.przychodyZeSprzedazy);
        int przychZeSprz = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.aktywaOgolem);
        int a = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.zyskNetto);
        int wf = Integer.parseInt(editText.getText().toString());

        Firebase userRef = mFirebase.child("users/" + mEmail);
        ResultModel user = new ResultModel(zyskBiez, strata, kw, kup, przychZeSprz, a, wf);
        userRef.setValue(user);

        Intent int1 = new Intent(WskaznikRentownosci.this, WskaznikRentownosci2.class);
        int1.putExtra("the email", mEmail);
        startActivity(int1);
    }
}
