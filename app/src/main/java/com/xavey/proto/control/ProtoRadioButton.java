package com.xavey.proto.control;

import android.content.Context;
import android.support.v7.widget.AppCompatRadioButton;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.xavey.proto.helper.AppValues;

/**
 * Created by tinmaungaye on 3/31/2016.
 */
public class ProtoRadioButton extends AppCompatRadioButton {
    private RadioButton rb;
    public ProtoRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        rb = this;
        initControl(context, attrs);
    }
    public ProtoRadioButton(Context context) {
        super(context);

    }

    public ProtoRadioButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    protected void initControl(Context context, AttributeSet attrs) {

        setOnCheckedChangeListener(toggleButtonChangeListener);
    }

    final CompoundButton.OnCheckedChangeListener toggleButtonChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(rb.isChecked()){
                String code = rb.getResources().getResourceEntryName(rb.getId()).replace("rg_","").replace("rb_", ""); // widgetA1
                String value = code.substring(code.lastIndexOf("_")+1,code.length());
                if(rb.getParent().getClass()== RadioGroup.class){
                    RadioGroup rg= ((RadioGroup)rb.getParent());
                    code = rg.getResources().getResourceEntryName(rg.getId()).replace("rg_","");
                }
                AppValues.getInstance().appendToCurrentRecords(code,value);
            }
        }
    };


}
