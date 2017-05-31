package com.example.sony.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WskaznikWyplacalnosci2 extends AppCompatActivity {

    private String mEmail;
    private TextView wskaznikOgolnegoZadluzenia, wskaznikZadluzeniaKapitaluWlasnego, wskaznikZobowiazanDlugoterminowych, wskaznikZadluzeniaDlugoterminowego, wskaznikPokryciaDlugu, wskaznikPokryciaOdsetekZykiem, wskaznikPokryciaDluguZNadwyzka, wskaznikPokryciaZobowiazanNadwyzka, wskaznikPokryciaDluguGotowki, wskaznikPokryciaOdsetekGotowkaOperacyjna;
    private String wynikWW1, wynikWW2, wynikWW3, wynikWW4, wynikWW5, wynikWW6, wynikWW7, wynikWW8, wynikWW9, wynikWW10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        mEmail = intent.getStringExtra("the email");
        wynikWW1 = intent.getStringExtra("wskaznikOgolnegoZadluzenia");
        wynikWW2 = intent.getStringExtra("wskaznikZadluzeniaKapitaluWlasnego");
        wynikWW3 = intent.getStringExtra("wskaznikZobowiazanDlugoterminowych");
        wynikWW4 = intent.getStringExtra("wskaznikZadluzeniaDlugoterminowego");
        wynikWW5 = intent.getStringExtra("wskaznikPokryciaDlugu");
        wynikWW6 = intent.getStringExtra("wskaznikPokryciaOdsetekZykiem");
        wynikWW7 = intent.getStringExtra("wskaznikPokryciaDluguZNadwyzka");
        wynikWW8 = intent.getStringExtra("wskaznikPokryciaZobowiazanNadwyzka");
        wynikWW9 = intent.getStringExtra("wskaznikPokryciaDluguGotowki");
        wynikWW10 = intent.getStringExtra("wskaznikPokryciaOdsetekGotowkaOperacyjna");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wskaznik_wyplacalnosci2);

        wskaznikOgolnegoZadluzenia = (TextView)findViewById(R.id.wskaznikOgolnegoZadluzenia);
        wskaznikOgolnegoZadluzenia.setText(wynikWW1);
        wskaznikZadluzeniaKapitaluWlasnego = (TextView)findViewById(R.id.wskaznikZadluzeniaKapitaluWlasnego);
        wskaznikZadluzeniaKapitaluWlasnego.setText(wynikWW2);
        wskaznikZobowiazanDlugoterminowych = (TextView)findViewById(R.id.wskaznikZobowiazanDlugoterminowych);
        wskaznikZobowiazanDlugoterminowych.setText(wynikWW3);
        wskaznikZadluzeniaDlugoterminowego = (TextView)findViewById(R.id.wskaznikZadluzeniaDlugoterminowego);
        wskaznikZadluzeniaDlugoterminowego.setText(wynikWW4);
        wskaznikPokryciaDlugu = (TextView)findViewById(R.id.wskaznikPokryciaDlugu);
        wskaznikPokryciaDlugu.setText(wynikWW5);
        wskaznikPokryciaOdsetekZykiem = (TextView)findViewById(R.id.wskaznikPokryciaOdsetekZykiem);
        wskaznikPokryciaOdsetekZykiem.setText(wynikWW6);
        wskaznikPokryciaDluguZNadwyzka = (TextView)findViewById(R.id.wskaznikPokryciaDluguZNadwyzka);
        wskaznikPokryciaDluguZNadwyzka.setText(wynikWW7);
        wskaznikPokryciaZobowiazanNadwyzka = (TextView)findViewById(R.id.wskaznikPokryciaZobowiazanNadwyzka);
        wskaznikPokryciaZobowiazanNadwyzka.setText(wynikWW8);
        wskaznikPokryciaDluguGotowki = (TextView)findViewById(R.id.wskaznikPokryciaDluguGotowki);
        wskaznikPokryciaDluguGotowki.setText(wynikWW9);
        wskaznikPokryciaOdsetekGotowkaOperacyjna = (TextView)findViewById(R.id.wskaznikPokryciaOdsetekGotowkaOperacyjna);
        wskaznikPokryciaOdsetekGotowkaOperacyjna.setText(wynikWW10);

    }
}
