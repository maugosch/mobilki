package com.example.sony.androidproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class WskaznikRentownosci2 extends AppCompatActivity {

    private String mEmail;
    private TextView wskaznikPokryciaStrat, wskaznikSkumulowanychStrat, wskaznikOperacyjnosci, produktywnoscAktywow, mnoznikKapitaluWlasnego, rentownoscKapitalowWlasnych, rentownoscMajatku, rentownoscSprzedazy;
    private String wynikWR1, wynikWR2, wynikWR3, wynikWR4, wynikWR5, wynikWR6, wynikWR7, wynikWR8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        mEmail = intent.getStringExtra("the email");
        wynikWR1 = intent.getStringExtra("wskaznikPokryciaStrat");
        wynikWR2 = intent.getStringExtra("wskaznikSkumulowanychStrat");
        wynikWR3 = intent.getStringExtra("wskaznikOperacyjnosci");
        wynikWR4 = intent.getStringExtra("produktywnoscAktywow");
        wynikWR5 = intent.getStringExtra("mnoznikKapitaluWlasnego");
        wynikWR6 = intent.getStringExtra("rentownoscKapitalowWlasnych");
        wynikWR7 = intent.getStringExtra("rentownoscMajatku");
        wynikWR8 = intent.getStringExtra("rentownoscSprzedazy");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wskaznik_rentownosci2);

        wskaznikPokryciaStrat = (TextView)findViewById(R.id.wskaznikPokryciaStrat);
        wskaznikPokryciaStrat.setText(wynikWR1);
        wskaznikSkumulowanychStrat = (TextView)findViewById(R.id.wskaznikSkumulowanychStrat);
        wskaznikSkumulowanychStrat.setText(wynikWR2);
        wskaznikOperacyjnosci = (TextView)findViewById(R.id.wskaznikOperacyjnosci);
        wskaznikOperacyjnosci.setText(wynikWR3);
        produktywnoscAktywow = (TextView)findViewById(R.id.produktywnoscAktywow);
        produktywnoscAktywow.setText(wynikWR4);
        mnoznikKapitaluWlasnego = (TextView)findViewById(R.id.mnoznikKapitaluWlasnego);
        mnoznikKapitaluWlasnego.setText(wynikWR5);
        rentownoscKapitalowWlasnych = (TextView)findViewById(R.id.rentownoscKapitalowWlasnych);
        rentownoscKapitalowWlasnych.setText(wynikWR6);
        rentownoscMajatku = (TextView)findViewById(R.id.rentownoscMajatku);
        rentownoscMajatku.setText(wynikWR7);
        rentownoscSprzedazy = (TextView)findViewById(R.id.rentownoscSprzedazy);
        rentownoscSprzedazy.setText(wynikWR8);
    }

}
