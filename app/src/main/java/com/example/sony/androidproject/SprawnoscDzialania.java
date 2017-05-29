package com.example.sony.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.firebase.client.Firebase;

public class SprawnoscDzialania extends AppCompatActivity {

    private String mEmail;
    Firebase mFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sprawnosc_dzialania);

        Intent intent = getIntent();
        mEmail = intent.getStringExtra("the email");

        Firebase.setAndroidContext(this);
        mFirebase = new Firebase("https://financeapp-7fbe1.firebaseio.com/");
        findViewById(R.id.mainButtonSprawnoscDzialania).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                saveButtonClick();

            }
        });

    }

    private void saveButtonClick(){
        Firebase alanRef = mFirebase.child("users");
        ResultModel alan = new ResultModel("Alan Turing", 1912);
        alanRef.setValue(alan);
    }
}
