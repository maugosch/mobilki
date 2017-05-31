package com.example.sony.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WskaznikiGieldowe2 extends AppCompatActivity {

    private String mEmail;
    private TextView zyskNaAkcje, wskaznikDiwydentyNaAkcje, cenaAkcjiDoZyskuNaAkcje, wartoscKsiegowaNaAkcje, wskaznikProduktywnosciJednejAkcji;
    private String wynikWG1, wynikWG2, wynikWG3, wynikWG4, wynikWG5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        mEmail = intent.getStringExtra("the email");
        wynikWG1 = intent.getStringExtra("zyskNaAkcje");
        wynikWG2 = intent.getStringExtra("wskaznikDiwydentyNaAkcje");
        wynikWG3 = intent.getStringExtra("cenaAkcjiDoZyskuNaAkcje");
        wynikWG4 = intent.getStringExtra("wartoscKsiegowaNaAkcje");
        wynikWG5 = intent.getStringExtra("wskaznikProduktywnosciJednejAkcji");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wskazniki_gieldowe2);

        zyskNaAkcje = (TextView)findViewById(R.id.zyskNaAkcje);
        zyskNaAkcje.setText(wynikWG1);
        wskaznikDiwydentyNaAkcje = (TextView)findViewById(R.id.wskaznikDiwydentyNaAkcje);
        wskaznikDiwydentyNaAkcje.setText(wynikWG2);
        cenaAkcjiDoZyskuNaAkcje = (TextView)findViewById(R.id.cenaAkcjiDoZyskuNaAkcje);
        cenaAkcjiDoZyskuNaAkcje.setText(wynikWG3);
        wartoscKsiegowaNaAkcje = (TextView)findViewById(R.id.wartoscKsiegowaNaAkcje);
        wartoscKsiegowaNaAkcje.setText(wynikWG4);
        wskaznikProduktywnosciJednejAkcji = (TextView)findViewById(R.id.wskaznikProduktywnosciJednejAkcji);
        wskaznikProduktywnosciJednejAkcji.setText(wynikWG5);
    }
}
