package com.example.sony.androidproject;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

public class MainMainActivity extends AppCompatActivity {

    public void plynnoscFinansowa(View view) {
        Intent but1 = new Intent(MainMainActivity.this, PlynnoscFinansowa.class);
        startActivity(but1);
    }

    public void sprawnoscDzialania(View view) {
        Intent but2 = new Intent(MainMainActivity.this, SprawnoscDzialania.class);
        startActivity(but2);
    }

    public void wskaznikGieldowy(View view) {
        Intent but3 = new Intent(MainMainActivity.this, WskaznikiGieldowe.class);
        startActivity(but3);
    }

    public void wskaznikWyplacalnosci(View view) {
        Intent but4 = new Intent(MainMainActivity.this, WskaznikRentownosci.class);
        startActivity(but4);
    }

    public void wskaznikRentownosci(View view) {
        Intent but5 = new Intent(MainMainActivity.this, WskaznikWyplacalnosci.class);
        startActivity(but5);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_main);
    }

}
