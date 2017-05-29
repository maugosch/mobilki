package com.example.sony.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.firebase.client.Firebase;

public class WskaznikWyplacalnosci extends AppCompatActivity {

    private String mEmail;
    Firebase mFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wskaznik_wyplacalnosci);

        Intent intent = getIntent();
        mEmail = intent.getStringExtra("the email");

        Firebase.setAndroidContext(this);
        mFirebase = new Firebase("https://financeapp-7fbe1.firebaseio.com/");

    }

    public void calculate(View view) {
        EditText editText = (EditText) findViewById(R.id.zobowiazaniaOgolem);
        int zobOg = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.aktywaOgolem);
        int ao = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.kapitalObcy);
        int ko = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.kapitalWlasny);
        int kw = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.przecietnyStanZapasow);
        int przecStanZapasow = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.przychodyZeSprzedazy);
        int przychZeSprz = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.zobowiazaniaDlugoterminowe);
        int zobDl = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.zyskBrutto);
        int wfBrutto = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.odsetki);
        int odsetki = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.rataKapitalowa);
        int rataKap = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.zyskNetto);
        int wf = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.Amortyzacja);
        int amortyzacja = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.przecientyStanZobowiazan);
        int przecStanZob = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.dodatniePrzeplywyOP);
        int cfOP = Integer.parseInt(editText.getText().toString());

        Firebase userRef = mFirebase.child("users/" + mEmail);
        ResultModel user = new ResultModel(zobOg, ao, ko, kw, przecStanZapasow,
                przychZeSprz, zobDl, wfBrutto, odsetki, rataKap, wf, amortyzacja, przecStanZob, cfOP);
        userRef.setValue(user);

        Intent int1 = new Intent(WskaznikWyplacalnosci.this, WskaznikWyplacalnosci2.class);
        int1.putExtra("the email", mEmail);
        startActivity(int1);
    }
}
