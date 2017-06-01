package com.example.sony.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.firebase.client.Firebase;

public class ModelHolda extends AppCompatActivity {

    private String mEmail;
    Firebase mFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_holda);

        Intent intent = getIntent();
        mEmail = intent.getStringExtra("the email");

        Firebase.setAndroidContext(this);
        mFirebase = new Firebase("https://financeapp-7fbe1.firebaseio.com/");

    }

    public void calculate(View view) {
        EditText editText = (EditText) findViewById(R.id.aktywaObrotowe);
        int ao = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.zobowiazaniaKrotkoterminowe);
        int zobKr = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.zobowiazaniaOgolem);
        int zobOg = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.aktywaHolda);
        int a = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.zyskNetto);
        int wf = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.stanSredniAktywow);
        int stanSrA = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.kosztyWlasneSprzedazy);
        int kosztSprz = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.przychodyZeSprzedazy);
        int przychZeSprz = Integer.parseInt(editText.getText().toString());

        Firebase userRef = mFirebase.child("users/" + mEmail + "/ModelH");
        ResultModelForModels user = new ResultModelForModels(ao, zobKr, zobOg, a, wf, stanSrA, kosztSprz, przychZeSprz);
        userRef.setValue(user);

        double z = 0.605 + 0.681 * (double)ao/(double)zobKr - 0.0196 * (double)zobOg/(double)a
                + 0.00969 * (double)wf/(double)stanSrA + 0.000672 * (double)zobKr*360/(double)kosztSprz
                + 0.157 * (double)przychZeSprz/(double)stanSrA;
        String zS = String.valueOf(z);


        Intent int1 = new Intent(ModelHolda.this, ModelHolda2.class);
        int1.putExtra("the email", mEmail);
        int1.putExtra("zet", zS);

        startActivity(int1);

    }
}
