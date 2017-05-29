package com.example.sony.androidproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.firebase.client.Firebase;

public class SprawnoscDzialania extends AppCompatActivity {

    Firebase mFirebase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sprawnosc_dzialania);

        Firebase.setAndroidContext(this);
<<<<<<< HEAD
        mFirebase = new Firebase("https://financeapp-7fbe1.firebaseio.com/");
=======
        mFirebase = new Firebase("https://finanse-aa551.firebaseio.com/");
>>>>>>> 157afc0dcced57ad5a228ff4f7b1eb5f6fd25cc7
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
