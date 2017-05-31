package com.example.sony.androidproject;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

public class MainMainActivity extends AppCompatActivity {

    private String mEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_main);

        Intent intent = getIntent();
        mEmail = intent.getStringExtra("the email");
    }


    public void plynnoscFinansowa(View view) {
        Intent but1 = new Intent(MainMainActivity.this, PlynnoscFinansowa.class);
        but1.putExtra("the email", mEmail);
        startActivity(but1);
    }


    public void wskaznikGieldowy(View view) {
        Intent but3 = new Intent(MainMainActivity.this, WskaznikiGieldowe.class);
        but3.putExtra("the email", mEmail);
        startActivity(but3);
    }

    public void wskaznikWyplacalnosci(View view) {
        Intent but4 = new Intent(MainMainActivity.this, WskaznikRentownosci.class);
        but4.putExtra("the email", mEmail);
        startActivity(but4);
    }

    public void wskaznikRentownosci(View view) {
        Intent but5 = new Intent(MainMainActivity.this, WskaznikWyplacalnosci.class);
        but5.putExtra("the email", mEmail);
        startActivity(but5);
    }


}
