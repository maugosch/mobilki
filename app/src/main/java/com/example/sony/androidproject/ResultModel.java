package com.example.sony.androidproject;

import com.firebase.client.Firebase;
import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Sony on 2017-05-28.
 */
@IgnoreExtraProperties
public class ResultModel {

    public int zapasy;
    public int zobBiez;
    public int ao;
    public int rmk;
    public int srPien;
    public int zyskBiez;
    public int strata;
    public int kw;
    public int kup;
    public int przychZeSprz;
    public int a;
    public int wf;
    public int ilAkcji;
    public int dywidendy;
    public int cenaAkcji;
    public int zobOg;
    public int ko;
    public int przecStanZapasow;
    public int zobDl;
    public int wfBrutto;
    public int odsetki;
    public int rataKap;
    public int amortyzacja;
    public int przecStanZob;
    public int cfOP;


    public ResultModel() {
    }
/*
    public ResultModel(String mail, int count) {
        this.mail = mail;
        this.count = count;
    }*/

    //plynnosc finansowa 5 danych
    public ResultModel(int zapasy, int zobBiez, int ao, int rmk, int srPien) {
        this.zapasy = zapasy;
        this.zobBiez = zobBiez;
        this.ao = ao;
        this.rmk = rmk;
        this.srPien = srPien;
    }

    //rentownosc 7 danych
    public ResultModel(int zyskBiez, int strata, int kw, int kup, int przychZeSprz, int a, int wf) {
        this.zyskBiez = zyskBiez;
        this.strata = strata;
        this.kw = kw;
        this.kup = kup;
        this.przychZeSprz = przychZeSprz;
        this.a = a;
        this.wf = wf;
    }

    //wsk. giełdowe 6 danych
    public ResultModel(int ilAkcji, int dywidendy, int cenaAkcji, int kw, int przychZeSprz, int wf) {
        this.ilAkcji = ilAkcji;
        this.dywidendy = dywidendy;
        this.kw = kw;
        this.cenaAkcji = cenaAkcji;
        this.przychZeSprz = przychZeSprz;
        this.wf = wf;
    }

    //wsk. wyplacalnosci 14 danych
    public ResultModel(int zobOg,int ao,int ko,int kw,int przecStanZapasow,
                       int przychZeSprz,int zobDl,int wfBrutto,int odsetki,
                       int rataKap,int wf,int amortyzacja,int przecStanZob,int cfOP) {
        this.zobOg = zobOg;
        this.ao = ao;
        this.kw = kw;
        this.ko = ko;
        this.przecStanZapasow = przecStanZapasow;
        this.przychZeSprz = przychZeSprz;
        this.zobDl = zobDl;
        this.wfBrutto = wfBrutto;
        this.odsetki = odsetki;
        this.rataKap = rataKap;
        this.wf = wf;
        this.amortyzacja = amortyzacja;
        this.przecStanZob = przecStanZob;
        this.cfOP = cfOP;
    }

    public ResultModel(int zapasy,
                       int zobBiez,
                       int ao,
                       int rmk,
                       int srPien,
                       int zyskBiez,
                       int strata,
                       int kw,
                       int kup,
                       int przychZeSprz,
                       int a,
                       int wf,
                       int ilAkcji,
                       int dywidendy,
                       int cenaAkcji,
                       int zobOg,
                       int ko,
                       int przecStanZapasow,
                       int zobDl,
                       int wfBrutto,
                       int odsetki,
                       int rataKap,
                       int amortyzacja,
                       int przecStanZob,
                       int cfOP) {
        this.zapasy = zapasy;
        this.zobBiez =zobBiez;
        this.ao =ao;
        this.rmk =rmk;
        this.srPien =srPien;
        this.zyskBiez =zyskBiez;
        this.strata =strata;
        this.kw =kw;
        this.kup =kup;
        this.przychZeSprz =przychZeSprz;
        this.a =a;
        this.wf =wf;
        this.ilAkcji =ilAkcji;
        this.dywidendy =dywidendy;
        this.cenaAkcji =cenaAkcji;
        this.zobOg =zobOg;
        this.ko =ko;
        this.przecStanZapasow =przecStanZapasow;
        this.zobDl =zobDl;
        this.wfBrutto =wfBrutto;
        this.odsetki =odsetki;
        this.rataKap =rataKap;
        this.amortyzacja =amortyzacja;
        this.przecStanZob =przecStanZob;
        this.cfOP =cfOP;
    }




    public long getZapasy() {
        return zapasy;
    }

    public long getZobBiez() {
        return zobBiez;
    }

    public long getAo() {
        return ao;
    }

    public long getRmk() {
        return rmk;
    }

    public long getSrPien() {
        return srPien;
    }

    public long getZyskBiez() {
        return zyskBiez;
    }

    public long getStrata() {
        return strata;
    }

    public long getKW() {
        return kw;
    }

    public long getKUP() {
        return kup;
    }

    public long getPrzychZeSprz() {
        return przychZeSprz;
    }

    public long getA() {
        return a;
    }

    public long getWF() {
        return wf;
    }

    public long getIlAkcji() {
        return ilAkcji;
    }

    public long getCenaAkcji() {
        return cenaAkcji;
    }

    public long getDywidendy() {
        return dywidendy;
    }


}
