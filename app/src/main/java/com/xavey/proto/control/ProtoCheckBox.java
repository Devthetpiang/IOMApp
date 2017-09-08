package com.xavey.proto.control;

import android.content.Context;
import android.support.v7.widget.AppCompatCheckBox;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.xavey.proto.helper.AppValues;

/**
 * Created by tinmaungaye on 3/31/2016.
 */
public class ProtoCheckBox extends AppCompatCheckBox {
    private AppCompatCheckBox rb;
    public ProtoCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        rb = this;
        initControl(context, attrs);
    }
    public ProtoCheckBox(Context context) {
        super(context);

    }

    public ProtoCheckBox(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    protected void initControl(Context context, AttributeSet attrs) {

        setOnCheckedChangeListener(toggleButtonChangeListener);
    }

    final OnCheckedChangeListener toggleButtonChangeListener = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            String code = rb.getResources().getResourceEntryName(rb.getId()).replace("rg_","").replace("rb_", ""); // widgetA1
            if(rb.isChecked()){
                AppValues.getInstance().appendToCurrentRecords(code,"1");
            }
            else{
                //will remove the item
                AppValues.getInstance().appendToCurrentRecords(code,"");
            }
        }
    };


}
