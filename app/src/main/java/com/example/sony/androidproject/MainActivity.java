package com.example.sony.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.firebase.client.Firebase;

import static com.example.sony.androidproject.LoginActivity.M_EMAIL;

public class MainActivity extends AppCompatActivity {

    private String mEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        mEmail = intent.getStringExtra(M_EMAIL);


        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.wynik);
        textView.setText("WITAJ " + mEmail);
    }

    public void wskaznikiFinansowe (View view){
        Intent but8 = new Intent(MainActivity.this, MainMainActivity.class);
        but8.putExtra("the email", mEmail);
        startActivity(but8);
    }

    public void modeleUpadlosci (View view) {
        Intent but9 = new Intent(MainActivity.this, Modele.class);
        but9.putExtra("the email", mEmail);
        startActivity(but9);
    }
}