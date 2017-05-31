package com.example.sony.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseError;

public class PlynnoscFinansowa extends AppCompatActivity {

    private String mEmail;
    Firebase mFirebase;
    private ResultModel newPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plynnosc_finansowa);

        Intent intent = getIntent();
        mEmail = intent.getStringExtra("the email");

        Firebase.setAndroidContext(this);
        mFirebase = new Firebase("https://financeapp-7fbe1.firebaseio.com/");
/***********************************************************************************/
        newPost = LoginActivity.getModel();
        //Pobieranie danych z Firebase do formularza
        Firebase userRef = mFirebase.child("users/" + mEmail);
        userRef.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // ...
                newPost = dataSnapshot.getValue(ResultModel.class);
                EditText  tZap= (EditText)findViewById(R.id.zapasy);
                EditText  tZobB= (EditText)findViewById(R.id.zobowiazaniaBiezace);
                EditText  tAO= (EditText)findViewById(R.id.aktywaObrotowe);
                EditText  tRMK= (EditText)findViewById(R.id.krotkoterminoweRozliczenieMiedzyokresowe);
                EditText  tSrPien= (EditText)findViewById(R.id.srodkiPieniezneIInneAktywaPieniezne);
                if (newPost.zapasy != 0) {
                    tZap.setText(new Integer(newPost.zapasy).toString());
                }
                if (newPost.zobBiez != 0) {
                    tZobB.setText(new Integer(newPost.zobBiez).toString());
                }
                if (newPost.ao != 0) {
                    tAO.setText(new Integer(newPost.ao).toString());
                }
                if (newPost.rmk != 0) {
                    tRMK.setText(new Integer(newPost.rmk).toString());
                }
                if (newPost.srPien != 0) {
                    tSrPien.setText(new Integer(newPost.srPien).toString());
                }

                System.out.println("KOMUNIKAT###############***************** " + newPost.zapasy);
                Log.d("My App", "KOMUNIKAT*****************############### " + newPost.zapasy);
            }

            @Override
            public void onCancelled(FirebaseError databaseError) {
                // ...
                //Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }



        });
/*********************************************************************************/
    }

    public void calculatePlynnosc(View view) {
        EditText editText = (EditText) findViewById(R.id.zapasy);
        int zapasy = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.zobowiazaniaBiezace);
        int zobBiez = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.aktywaObrotowe);
        int ao = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.krotRozMiedzokres);
        int rmk = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.srodkiPieniezne);
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
