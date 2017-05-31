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

public class WskaznikRentownosci extends AppCompatActivity {

    private String mEmail;
    Firebase mFirebase;
    private ResultModel newPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wskaznik_rentownosci);

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

                EditText tZyskB = (EditText) findViewById(R.id.zyskBiezacy);
                EditText tStrata = (EditText) findViewById(R.id.strataZLatUbieglych);
                EditText tKW = (EditText) findViewById(R.id.kapitalWlasny);
                EditText tKUP = (EditText) findViewById(R.id.kosztUzyskaniaPrzychodow);
                EditText tPrzychSprz = (EditText) findViewById(R.id.przychodyZeSprzedazy);
                EditText tA = (EditText) findViewById(R.id.aktywaOgolem);
                EditText tWF = (EditText) findViewById(R.id.zyskNetto);


                if (newPost.zyskBiez != 0) {
                    tZyskB.setText(new Integer(newPost.zyskBiez).toString());
                }
                if (newPost.strata != 0) {
                    tStrata.setText(new Integer(newPost.strata).toString());
                }
                if (newPost.kw != 0) {
                    tKW.setText(new Integer(newPost.kw).toString());
                }
                if (newPost.kup != 0) {
                    tKUP.setText(new Integer(newPost.kup).toString());
                }
                if (newPost.przychZeSprz != 0) {
                    tPrzychSprz.setText(new Integer(newPost.przychZeSprz).toString());
                }
                if (newPost.a != 0) {
                    tA.setText(new Integer(newPost.a).toString());
                }
                if (newPost.wf != 0) {
                    tWF.setText(new Integer(newPost.wf).toString());
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
        EditText editText = (EditText) findViewById(R.id.zyskBiezacy);
        int zyskBiez = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.strataZLatUbieglych);
        int strata = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.kapitalWlasny);
        int kw = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.kosztUzyskaniaPrzychodow);
        int kup = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.przychodyZeSprzedazy);
        int przychZeSprz = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.aktywaOgolem);
        int a = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.zyskNetto);
        int wf = Integer.parseInt(editText.getText().toString());

        Firebase userRef = mFirebase.child("users/" + mEmail);
        ResultModel user = new ResultModel(zyskBiez, strata, kw, kup, przychZeSprz, a, wf);
        userRef.setValue(user);

        double wskaznikPokryciaStrat = (double)zyskBiez/(double)(strata * 100);
        String wskaznikPokryciaStratS = String.valueOf(wskaznikPokryciaStrat);
        double wskaznikSkumulowanychStrat = (double)kw/(double)(strata * 100);
        String wskaznikSkumulowanychStratS = String.valueOf(wskaznikSkumulowanychStrat);
        double wskaznikOperacyjnosci = (double)kup/(double)(przychZeSprz * 100);
        String wskaznikOperacyjnosciS = String.valueOf(wskaznikOperacyjnosci);
        double produktywnoscAktywow = (double)przychZeSprz/(double)a;
        String produktywnoscAktywowS = String.valueOf(produktywnoscAktywow);
        double mnoznikKapitaluWlasnego = (double)a/(double)kw;
        String mnoznikKapitaluWlasnegoS = String.valueOf(mnoznikKapitaluWlasnego);
        double rentownoscKapitalowWlasnych = (double)wf/(double)(kw * 100);
        String rentownoscKapitalowWlasnychS = String.valueOf(rentownoscKapitalowWlasnych);
        double rentownoscMajatku = (double)wf/(double)(a * 100);
        String rentownoscMajatkuS = String.valueOf(rentownoscMajatku);
        double rentownoscSprzedazy = (double)wf/(double)(przychZeSprz * 100);
        String rentownoscSprzedazyS = String.valueOf(rentownoscSprzedazy);

        Intent int1 = new Intent(WskaznikRentownosci.this, WskaznikRentownosci2.class);
        int1.putExtra("the email", mEmail);
        int1.putExtra("wskaznikPokryciaStrat", wskaznikPokryciaStratS);
        int1.putExtra("wskaznikSkumulowanychStrat", wskaznikSkumulowanychStratS);
        int1.putExtra("wskaznikOperacyjnosci", wskaznikOperacyjnosciS);
        int1.putExtra("produktywnoscAktywow", produktywnoscAktywowS);
        int1.putExtra("mnoznikKapitaluWlasnego", mnoznikKapitaluWlasnegoS);
        int1.putExtra("rentownoscKapitalowWlasnych", rentownoscKapitalowWlasnychS);
        int1.putExtra("rentownoscMajatku", rentownoscMajatkuS);
        int1.putExtra("rentownoscSprzedazy", rentownoscSprzedazyS);

        startActivity(int1);
    }
}
