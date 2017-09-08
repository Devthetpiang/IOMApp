package com.xavey.proto.helper;

import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;

import com.xavey.proto.R;
import com.xavey.proto.api.model.FormRecord;
import com.xavey.proto.api.model.User;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by tinmaungaye on 3/30/16.
 */
public class AppValues{
    private static AppValues mInstance = null;

    public static String AuthToken ="";
    public static String CurrentPost = "";

    private boolean mZawGyiDisplay = true;
    private boolean mCategoryDisplay = true;
    private Date recordDT;
    private String lat="";
    private String lng="";
    private int workingForm=0;
    private static String root = Environment.getExternalStorageDirectory().toString();

    private HashMap<String,String> currentRecords = new HashMap<String,String>();

    private SparseArray<RecyclerView.ViewHolder> A1ViewHolders = new SparseArray<RecyclerView.ViewHolder>();

    private AppValues(){
    }

    public static AppValues getInstance(){
        if(mInstance == null)
        {
            mInstance = new AppValues();
        }
        return mInstance;
    }

    public HashMap<String, String> getCurrentRecords() {
        return currentRecords;
    }

    public void setCurrentRecords(HashMap<String, String> currentRecords) {
        this.currentRecords = currentRecords;
    }

    public void appendToCurrentRecords(String key, String value){
        if(value.equals("")) {
            this.currentRecords.remove(key);
        }
        else{
            this.currentRecords.put(key, value);
        }
    }

    public SparseArray<RecyclerView.ViewHolder> getA1ViewHolders() {
        return A1ViewHolders;
    }

    public void setA1ViewHolders(SparseArray<RecyclerView.ViewHolder> a1ViewHolders) {
        A1ViewHolders = a1ViewHolders;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public Date getRecordDT() {
        return recordDT;
    }

    public void setRecordDT(Date recordDT) {
        this.recordDT = recordDT;
    }

    public int getWorkingForm() {
        return workingForm;
    }

    public void setWorkingForm(int workingForm) {
        this.workingForm = workingForm;
    }
}
