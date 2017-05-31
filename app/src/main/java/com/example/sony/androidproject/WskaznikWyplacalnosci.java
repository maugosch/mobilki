package com.example.sony.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class WskaznikWyplacalnosci extends AppCompatActivity {

    private String mEmail;
    Firebase mFirebase;
    private ResultModel newPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wskaznik_wyplacalnosci);

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

                EditText tZO = (EditText) findViewById(R.id.zobowiazaniaOgolem);
                EditText tA = (EditText) findViewById(R.id.aktywaOgolem);
                EditText tKO = (EditText) findViewById(R.id.kapitalObcy);
                EditText tKW = (EditText) findViewById(R.id.kapitalWlasny);
                EditText tStanZap = (EditText) findViewById(R.id.przecietnyStanZapasow);
                EditText tSprz = (EditText) findViewById(R.id.przychodyZeSprzedazy);
                EditText tZDl = (EditText) findViewById(R.id.zobowiazaniaDlugoterminowe);
                EditText tWFBr = (EditText) findViewById(R.id.zyskBrutto);
                EditText tOdsetki = (EditText) findViewById(R.id.odsetki);
                EditText tRata = (EditText) findViewById(R.id.rataKapitalowa);
                EditText tWF = (EditText) findViewById(R.id.zyskNetto);
                EditText tAmo = (EditText) findViewById(R.id.Amortyzacja);
                EditText tStanZob = (EditText) findViewById(R.id.przecientyStanZobowiazan);
                EditText tCFOp = (EditText) findViewById(R.id.dodatniePrzeplywyOP);


                if (newPost.zobOg != 0) {
                    tZO.setText(new Integer(newPost.zobOg).toString());
                }
                if (newPost.a != 0) {
                    tA.setText(new Integer(newPost.a).toString());
                }
                if (newPost.ko != 0) {
                    tKO.setText(new Integer(newPost.ko).toString());
                }
                if (newPost.kw != 0) {
                    tKW.setText(new Integer(newPost.kw).toString());
                }
                if (newPost.przecStanZapasow != 0) {
                    tStanZap.setText(new Integer(newPost.przecStanZapasow).toString());
                }
                if (newPost.przychZeSprz != 0) {
                    tSprz.setText(new Integer(newPost.przychZeSprz).toString());
                }
                if (newPost.zobDl != 0) {
                    tZDl.setText(new Integer(newPost.zobDl).toString());
                }
                if (newPost.wfBrutto != 0) {
                    tWFBr.setText(new Integer(newPost.wfBrutto).toString());
                }
                if (newPost.odsetki != 0) {
                    tOdsetki.setText(new Integer(newPost.odsetki).toString());
                }
                if (newPost.rataKap != 0) {
                    tRata.setText(new Integer(newPost.rataKap).toString());
                }
                if (newPost.wf != 0) {
                    tWF.setText(new Integer(newPost.wf).toString());
                }
                if (newPost.amortyzacja != 0) {
                    tAmo.setText(new Integer(newPost.amortyzacja).toString());
                }
                if (newPost.przecStanZob != 0) {
                    tStanZob.setText(new Integer(newPost.przecStanZob).toString());
                }
                if (newPost.cfOP != 0) {
                    tCFOp.setText(new Integer(newPost.cfOP).toString());
                }

            }

            @Override
            public void onCancelled(FirebaseError databaseError) {
                // ...
                //Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }



        });
/*********************************************************************************/

    }

    public void calculate(View view) {
        EditText editText = (EditText) findViewById(R.id.zobowiazaniaOgolem);
        int zobOg = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.aktywaOgolem);
        int ao = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.kapitalObcy);
        int ko = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.kapitalWlasny);
        int kw = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.przecietnyStanZapasow);
        int przecStanZapasow = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.przychodyZeSprzedazy);
        int przychZeSprz = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.zobowiazaniaDlugoterminowe);
        int zobDl = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.zyskBrutto);
        int wfBrutto = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.odsetki);
        int odsetki = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.rataKapitalowa);
        int rataKap = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.zyskNetto);
        int wf = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.Amortyzacja);
        int amortyzacja = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.przecientyStanZobowiazan);
        int przecStanZob = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.dodatniePrzeplywyOP);
        int cfOP = Integer.parseInt(editText.getText().toString());

        Firebase userRef = mFirebase.child("users/" + mEmail);
        ResultModel user = new ResultModel(zobOg, ao, ko, kw, przecStanZapasow,
                przychZeSprz, zobDl, wfBrutto, odsetki, rataKap, wf, amortyzacja, przecStanZob, cfOP);
        userRef.setValue(user);

        double wskaznikOgolnegoZadluzenia = (double)zobOg/(double)ao;
        String wskaznikOgolnegoZadluzeniaS = String.valueOf(wskaznikOgolnegoZadluzenia);
        double wskaznikZadluzeniaKapitaluWlasnego = (double)ko/(double)kw;
        String wskaznikZadluzeniaKapitaluWlasnegoS = String.valueOf(wskaznikZadluzeniaKapitaluWlasnego);
        double wskaznikZobowiazanDlugoterminowych = (double)(przecStanZapasow * 365)/(double)przychZeSprz;
        String wskaznikZobowiazanDlugoterminowychS = String.valueOf(wskaznikZobowiazanDlugoterminowych);
        double wskaznikZadluzeniaDlugoterminowego = (double)zobDl/(double)kw;
        String wskaznikZadluzeniaDlugoterminowegoS = String.valueOf(wskaznikZadluzeniaDlugoterminowego);
        double wskaznikPokryciaDlugu = (double)(wfBrutto + odsetki)/(double)(rataKap + odsetki);
        String wskaznikPokryciaDluguS = String.valueOf(wskaznikPokryciaDlugu);
        double wskaznikPokryciaOdsetekZykiem = (double)(wfBrutto + odsetki)/(double)odsetki;
        String wskaznikPokryciaOdsetekZykiemS = String.valueOf(wskaznikPokryciaOdsetekZykiem);
        double wskaznikPokryciaDluguZNadwyzka = (double)(wf + amortyzacja)/(double)(rataKap + odsetki);
        String wskaznikPokryciaDluguZNadwyzkaS = String.valueOf(wskaznikPokryciaDluguZNadwyzka);
        double wskaznikPokryciaZobowiazanNadwyzka = (double)(wf + amortyzacja)/(double)przecStanZob;
        String wskaznikPokryciaZobowiazanNadwyzkaS = String.valueOf(wskaznikPokryciaZobowiazanNadwyzka);
        double wskaznikPokryciaDluguGotowki = (double)cfOP/(double)(rataKap + odsetki);
        String wskaznikPokryciaDluguGotowkiS = String.valueOf(wskaznikPokryciaDluguGotowki);
        double wskaznikPokryciaOdsetekGotowkaOperacyjna = (double)cfOP/(double)odsetki;
        String wskaznikPokryciaOdsetekGotowkaOperacyjnaS = String.valueOf(wskaznikPokryciaOdsetekGotowkaOperacyjna);

        Intent int1 = new Intent(WskaznikWyplacalnosci.this, WskaznikWyplacalnosci2.class);
        int1.putExtra("the email", mEmail);
        int1.putExtra("wskaznikOgolnegoZadluzenia", wskaznikOgolnegoZadluzeniaS);
        int1.putExtra("wskaznikZadluzeniaKapitaluWlasnego", wskaznikZadluzeniaKapitaluWlasnegoS);
        int1.putExtra("wskaznikZobowiazanDlugoterminowych", wskaznikZobowiazanDlugoterminowychS);
        int1.putExtra("wskaznikZadluzeniaDlugoterminowego", wskaznikZadluzeniaDlugoterminowegoS);
        int1.putExtra("wskaznikPokryciaDlugu", wskaznikPokryciaDluguS);
        int1.putExtra("wskaznikPokryciaOdsetekZykiem", wskaznikPokryciaOdsetekZykiemS);
        int1.putExtra("wskaznikPokryciaDluguZNadwyzka", wskaznikPokryciaDluguZNadwyzkaS);
        int1.putExtra("wskaznikPokryciaZobowiazanNadwyzka", wskaznikPokryciaZobowiazanNadwyzkaS);
        int1.putExtra("wskaznikPokryciaDluguGotowki", wskaznikPokryciaDluguGotowkiS);
        int1.putExtra("wskaznikPokryciaOdsetekGotowkaOperacyjna", wskaznikPokryciaOdsetekGotowkaOperacyjnaS);

        startActivity(int1);
    }
}
