package com.example.sony.financialapp;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import com.example.sony.androidproject.R;
import com.ms.square.android.expandabletextview.ExpandableTextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class SecondActivity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        listView = (ExpandableListView)findViewById(R.id.expandFinancial);
        initData();
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listHash);
        listView.setAdapter(listAdapter);
    }

    private void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("Płynność finansowa:");
        listDataHeader.add("Sprawność działania:");
        listDataHeader.add("Wskaźniki giełdowe:");
        listDataHeader.add("Wskaźniki wypłacalności:");
        listDataHeader.add("Wskaźniki renowności:");

    List<String>plynnosc = new ArrayList<>();
        plynnosc.add("aktywa obrotowe");
        plynnosc.add("zobowiązania bieżące");
        plynnosc.add("zapasy");
        plynnosc.add("krótkoterminowe rozliczenia międzyokresowe");
        plynnosc.add("środki pieniężne i inne aktywa");
    }
}