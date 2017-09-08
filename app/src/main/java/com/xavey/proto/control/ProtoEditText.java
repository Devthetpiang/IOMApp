package com.xavey.proto.control;

import android.content.Context;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.xavey.proto.R;
import com.xavey.proto.helper.AppValues;

/**
 * Created by tinmaungaye on 3/31/2016.
 */
public class ProtoEditText extends AppCompatEditText{
    private EditText et;
    public ProtoEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        et = this;
        initControl(context, attrs);
    }
    public ProtoEditText(Context context) {
        super(context);

    }

    public ProtoEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    protected void initControl(Context context, AttributeSet attrs) {
        addTextChangedListener(inputCaptureWatcher);
    }

    private TextWatcher inputCaptureWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,	int after) {}
        @Override
        public void afterTextChanged(Editable s) {
            String code = et.getResources().getResourceEntryName(et.getId()).replace("et_",""); // widgetA1
            Boolean ignore = false;
            if(et.getParent().getParent().getClass()== CardView.class){
                RecyclerView rv = (RecyclerView)et.getParent().getParent().getParent();
                if(rv==null) {
                    ignore = true;
                }else{
                    code = rv.getResources().getResourceEntryName(rv.getId()).replace("rv_","")+"_"+code;
                }

            }
            if(!ignore){
                AppValues.getInstance().appendToCurrentRecords(code,s.toString());
            }
        }
    };
}
