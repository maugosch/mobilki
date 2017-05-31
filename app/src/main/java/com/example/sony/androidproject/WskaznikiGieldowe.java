package com.example.sony.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class WskaznikiGieldowe extends AppCompatActivity {

    private String mEmail;
    Firebase mFirebase;
    private ResultModel newPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wskazniki_gieldowe);

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

                EditText tIlAkcji = (EditText) findViewById(R.id.iloscAkcjiZwyklych);
                EditText tZyskDyw = (EditText) findViewById(R.id.zyskPrzeznaczonyNaDywidenty);
                EditText tCenaAk = (EditText) findViewById(R.id.cenaAkcji);
                EditText tKW = (EditText) findViewById(R.id.kapitalWlasny);
                EditText tPrzychZAk = (EditText) findViewById(R.id.przychodZeSprz1Akc);
                EditText tZysk = (EditText) findViewById(R.id.zyskNetto);


                if (newPost.ilAkcji != 0) {
                    tIlAkcji.setText(new Integer(newPost.ilAkcji).toString());
                }
                if (newPost.dywidendy != 0) {
                    tZyskDyw.setText(new Integer(newPost.dywidendy).toString());
                }
                if (newPost.cenaAkcji != 0) {
                    tCenaAk.setText(new Integer(newPost.cenaAkcji).toString());
                }
                if (newPost.kw != 0) {
                    tKW.setText(new Integer(newPost.kw).toString());
                }
                if (newPost.przychZeSprz != 0) {
                    tPrzychZAk.setText(new Integer(newPost.przychZeSprz).toString());
                }
                if (newPost.wf != 0) {
                    tZysk.setText(new Integer(newPost.wf).toString());
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
        EditText editText = (EditText) findViewById(R.id.iloscAkcjiZwyklych);
        int ilAkcji = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.zyskPrzeznaczonyNaDywidenty);
        int dywidendy = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.cenaAkcji);
        int cenaAkcji = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.kapitalWlasny);
        int kw = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.przychodZeSprz1Akc);
        int przychZeSprz = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.zyskNetto);
        int wf = Integer.parseInt(editText.getText().toString());

        Firebase userRef = mFirebase.child("users/" + mEmail);
        ResultModel user = new ResultModel(ilAkcji, dywidendy, cenaAkcji, kw, przychZeSprz, wf);
        userRef.setValue(user);


        double zyskNaAkcje = (double)wf/(double)ilAkcji;
        String zyskNaAkcjeS = String.valueOf(zyskNaAkcje);
        double wskaznikDiwydentyNaAkcje = (double)dywidendy/(double)ilAkcji;
        String wskaznikDiwydentyNaAkcjeS = String.valueOf(wskaznikDiwydentyNaAkcje);
        double cenaAkcjiDoZyskuNaAkcje = (double)cenaAkcji/(double)wf;
        String cenaAkcjiDoZyskuNaAkcjeS = String.valueOf(cenaAkcjiDoZyskuNaAkcje);
        double wartoscKsiegowaNaAkcje = (double)kw/(double)ilAkcji;
        String wartoscKsiegowaNaAkcjeS = String.valueOf(wartoscKsiegowaNaAkcje);
        double wskaznikProduktywnosciJednejAkcji = (double)przychZeSprz/(double)ilAkcji;
        String wskaznikProduktywnosciJednejAkcjiS = String.valueOf(wskaznikProduktywnosciJednejAkcji);


        Intent int1 = new Intent(WskaznikiGieldowe.this, WskaznikiGieldowe2.class);
        int1.putExtra("the email", mEmail);
        int1.putExtra("zyskNaAkcje", zyskNaAkcjeS);
        int1.putExtra("wskaznikDiwydentyNaAkcje", wskaznikDiwydentyNaAkcjeS);
        int1.putExtra("cenaAkcjiDoZyskuNaAkcje", cenaAkcjiDoZyskuNaAkcjeS);
        int1.putExtra("wartoscKsiegowaNaAkcje", wartoscKsiegowaNaAkcjeS);
        int1.putExtra("wskaznikProduktywnosciJednejAkcji", wskaznikProduktywnosciJednejAkcjiS);

        startActivity(int1);
    }

}
