package com.example.sony.financialapp;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;


public class ExpandableListAdapter extends BaseExpandableListAdapter  {

    private Context context;
    private List<String> listDataHeader;
    private HashMap<String,List<String>> listHashMap;


    public ExpandableListAdapter(Context context, List<String> listDataHeader, HashMap<String, List<String>> listHashMap) {
        this.context = context;
        this.listDataHeader = listDataHeader;
        this.listHashMap = listHashMap;
    }

    @Override
    public int getGroupCount()  {
        return listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int i)   {
        return listHashMap.get(listDataHeader.get(i)).size();
    }

    @Override
    public Object getGroup(int i)  {
        return listDataHeader.get(i);
    }

    @Override
    public Object getChild(int i, int i1)  {
        return listHashMap.get(listDataHeader.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i)   {
        return i;
    }

    @Override
    public long getChildId(int i, int i1)  {
        return i1;
    }

    @Override
    public boolean hasStableIds()   {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup)  {
        String headerTitle = (String)getGroup(i);
        if (view == null)
        {
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.financial_groups, null);
        }
        TextView listFinancial = (TextView) view.findViewById(R.id.listFinancial);
        listFinancial.setTypeface(null, Typeface.BOLD);
        listFinancial.setText(headerTitle);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup)  {
        final String childText = (String)getChild(i,i1);
        if (view == null)
        {
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.financial_fields, null);
        }
        TextView txtListChild = (TextView)view.findViewById(R.id.fieldsFinancial);
        txtListChild.setText(childText);
        return view;
    }


    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
