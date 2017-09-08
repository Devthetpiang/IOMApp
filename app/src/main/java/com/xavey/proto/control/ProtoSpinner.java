package com.xavey.proto.control;

import android.content.Context;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.xavey.proto.helper.AppValues;

import java.util.Objects;

/**
 * Created by tinmaungaye on 3/31/2016.
 */
public class ProtoSpinner extends AppCompatSpinner {
    private Spinner sp;
    public ProtoSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        sp = this;
        initControl(context, attrs);
    }
    public ProtoSpinner(Context context) {
        super(context);

    }

    public ProtoSpinner(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    protected void initControl(Context context, AttributeSet attrs) {
        setOnItemSelectedListener(itemSelectedListener);
    }

    final OnItemSelectedListener itemSelectedListener = new OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            OnItemSelected(parent, view, pos, id);
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
        }
    };

    public void OnItemSelected(AdapterView<?> parent, View view,
                               int pos, long id){
        String code = sp.getResources().getResourceEntryName(sp.getId()).replace("sp_", "");
        if(sp.getParent().getParent().getClass()== CardView.class){
            RecyclerView rv = (RecyclerView)sp.getParent().getParent().getParent();
            code = rv.getResources().getResourceEntryName(rv.getId()).replace("rv_","")+"_"+code;
        }
        String value = String.valueOf(pos);
        if(code.equals("pre_state") || code.equals("pre_township") || code.equals("pre_village"))
        {
            Object item=parent.getItemAtPosition(pos);
            value=String.valueOf(item);
            //AppValues.getInstance().appendToCurrentRecords(code,values);
        }

        if (pos == 0) {value = "";}
        AppValues.getInstance().appendToCurrentRecords(code, value);
    }


}
