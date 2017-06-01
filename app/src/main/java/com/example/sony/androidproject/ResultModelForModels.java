package com.example.sony.androidproject;

import com.firebase.client.Firebase;

/**
 * Created by Małgorzata Graja on 29.05.2017.
 */

public class ResultModelForModels {
    private int kon;
    private int ao;
    private int zz;
    private int ebit;
    private int przychZeSprz;
    private int kw;
    private int zobOg;
    private int zobKr;
    private int a;
    private int wf;
    private int stanSrA;
    private int kosztSprz;

    public ResultModelForModels(){    }

    //Altman 7 danych
    public ResultModelForModels(int kon, int a,int zz, int ebit, int przychZeSprz, int kw, int zobOg) {
        this.zobOg = zobOg;
        this.a = a;
        this.kw = kw;
        this.przychZeSprz = przychZeSprz;
        this.kon = kon;
        this.zz = zz;
        this.ebit = ebit;

    }

    //Hołda 8 danych
    public ResultModelForModels(int ao,int zobKr,int zobOg,int a,int wf,int stanSrA,int kosztSprz,int przychZeSprz) {
        this.zobOg = zobOg;
        this.ao = ao;
        this.przychZeSprz = przychZeSprz;
        this.zobKr = zobKr;
        this.a = a;
        this.wf = wf;
        this.stanSrA = stanSrA;
        this.kosztSprz = kosztSprz;

    }






    public long getKon() {return kon;}
    public long getAo() {return ao;}
    public long getZz() {return zz;}
    public long getEBIT() {return ebit;}
    public long getPrzychZeSprz() {return przychZeSprz;}
    public long getKW() {return kw;}
    public long getZobOg() {return zobOg;}
    public long getZobKr() {return zobKr;}
    public long getA() {return a;}
    public long getWF() {return wf;}
    public long getStanSrA() {return stanSrA;}
    public long getKosztSprz() {return kosztSprz;}

}
