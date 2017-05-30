package com.example.sony.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseError;

public class PlynnoscFinansowa extends AppCompatActivity {

    private String mEmail;
    Firebase mFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plynnosc_finansowa);

        Intent intent = getIntent();
        mEmail = intent.getStringExtra("the email");

        Firebase.setAndroidContext(this);
        mFirebase = new Firebase("https://financeapp-7fbe1.firebaseio.com/");
/***********************************************************************************
        //Pobieranie danych z Firebase do formularza
        Firebase userRef = mFirebase.child("users/" + mEmail);
        userRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // ...
                Post newPost = dataSnapshot.getValue(Post.class);
                System.out.println("Author: " + newPost.author);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // ...
            }
        });
*********************************************************************************/
    }

    public void calculatePlynnosc(View view) {
        EditText editText = (EditText) findViewById(R.id.zapasy);
        int zapasy = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.zobowiazaniaBiezace);
        int zobBiez = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.aktywaObrotowe);
        int ao = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.krotkoterminoweRozliczenieMiedzyokresowe);
        int rmk = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.srodkiPieniezneIInneAktywaPieniezne);
        int srPien = Integer.parseInt(editText.getText().toString());

        Firebase userRef = mFirebase.child("users/" + mEmail);
        ResultModel user = new ResultModel(zapasy, zobBiez, ao, rmk, srPien);
        userRef.setValue(user);

        double biezaca = (double)ao/(double)zobBiez;
        String biezacaS = String.valueOf(biezaca);
        double szybka = (double)(ao-zapasy-rmk)/(double)zobBiez;
        String szybkaS = String.valueOf(szybka);
        double zaostrzona = (double)srPien/(double)zobBiez;
        String zaostrzonaS = String.valueOf(zaostrzona);

        Intent int1 = new Intent(PlynnoscFinansowa.this, PlynnoscFinansowa2.class);
        int1.putExtra("the email", mEmail);
        int1.putExtra("biezaca", biezacaS);
        int1.putExtra("szybka", szybkaS);
        int1.putExtra("zaostrzona", zaostrzonaS);

        startActivity(int1);
    }
}
