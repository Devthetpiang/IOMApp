package com.xavey.proto.helper;

import com.xavey.proto.api.model.json.Form;
import com.xavey.proto.api.model.json.FormData;
import com.xavey.proto.api.model.json.FormDoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by tinmaungaye on 4/2/2016.
 */
public class RecordConverter {
    public static ArrayList<FormData> fromAppValue(String[] index){
        ArrayList<FormData> fds = new ArrayList<FormData>();
        Map<String,String> rec= new TreeMap<String,String>(AppValues.getInstance().getCurrentRecords());
        Iterator it = rec.entrySet().iterator();
        while (it.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry)it.next();
            FormData data = new FormData();
            data.setField_id(String.valueOf(Arrays.asList(index).indexOf(pair.getKey().toString().toUpperCase())));
            data.setField_label(pair.getKey().toString().toUpperCase());
            data.setField_name("_" + pair.getKey().toString().toUpperCase());
            data.setField_value(pair.getValue().toString());
            fds.add(data);
            it.remove(); // avoids a ConcurrentModificationException
        }
        Collections.sort(fds,new RecordComparator());
        return fds;
    }
    
    public static FormDoc fromDBSting(String json){
        FormDoc fd = new FormDoc();
        return fd;
    }
}
