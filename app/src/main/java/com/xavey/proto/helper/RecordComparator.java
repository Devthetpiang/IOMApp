package com.xavey.proto.helper;

import com.xavey.proto.api.model.json.FormData;
import com.xavey.proto.api.model.json.FormDoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by tinmaungaye on 4/5/2016.
 */
public class RecordComparator implements Comparator<FormData>
{
    public int compare(FormData left, FormData right) {
        Integer l = Integer.parseInt(left.getField_id());
        Integer r = Integer.parseInt(right.getField_id());
        return l.compareTo(r);
        //return left.getField_id().compareTo(right.getField_id());
    }
}