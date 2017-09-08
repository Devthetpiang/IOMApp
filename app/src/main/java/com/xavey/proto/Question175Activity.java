package com.xavey.proto;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.xavey.proto.adapter.SingleAdapter;
import com.xavey.proto.api.model.FormRecords;
import com.xavey.proto.api.model.json.Form;
import com.xavey.proto.api.model.json.FormDoc;
import com.xavey.proto.api.model.json.FormLocation;
import com.xavey.proto.api.model.json.Organisation;
import com.xavey.proto.api.model.json.Worker;
import com.xavey.proto.helper.AppValues;
import com.xavey.proto.helper.DBHelper;
import com.xavey.proto.helper.GPSTracker;
import com.xavey.proto.helper.RecordConverter;
import com.xavey.proto.helper.SessionManager;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

/**
 * Created by tinmaungaye on 3/19/16.
 */
public class Question175Activity extends BaseActivity {
    private ViewPager viewPager;
    private int mCurrentTabPosition = 0;
    private SingleAdapter mSingleAdapter;
    private SessionManager session;
    private HashMap<String,String> fromIndex = new HashMap<String,String>();
    private boolean jumping=false;
    private int targetJump = -1;
   // public Location l;
   // GPSTracker gps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //gps = GPSTracker.getInstance();
       // gps.set_context(this);
      //  gps.getLocation(this);

        setContentView(R.layout.activity_question);
        session = new SessionManager(this);
        viewPager = (ViewPager) findViewById(R.id.pager);
        mSingleAdapter = new SingleAdapter(getSupportFragmentManager(),getResources().getStringArray(R.array.question_titles));
        AppValues.getInstance().setRecordDT(new Date());
        viewPager.setAdapter(mSingleAdapter);
        viewPager.addOnPageChangeListener(mPageChangeListener);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                showClosingDialog();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private final ViewPager.SimpleOnPageChangeListener mPageChangeListener = new ViewPager.SimpleOnPageChangeListener() {

        @Override
        public void onPageSelected(final int position) {
            boolean flag = onTabChangedWithJump(viewPager.getAdapter(), mCurrentTabPosition, position);
            if(flag){

            }
            else {
                mCurrentTabPosition = position;
            }
        }
    };

    public void doForm(boolean completed){
        Date d = new Date();
        Organisation o = new Organisation();
        o.setId(Integer.parseInt(getResources().getString(R.string.org_id)));
        o.setOrg_name(getResources().getString(R.string.org_title));

        Form f = new Form();
        f.setId(Integer.parseInt(getResources().getString(R.string.form_id_175)));
        f.setTitle(getResources().getString(R.string.form_title_175));

        Worker w = new Worker();
        w.setId(session.getLoginUserId());
        w.setName(session.getLoginUserName());

          FormLocation fl = new FormLocation();
          GPSTracker gps=new GPSTracker();
          Location l=gps.getLocation(this);

        if(String.valueOf(l.getLatitude()).equals("") || String.valueOf(l.getLatitude()).equals(0) )
        {
              AppValues.getInstance().setLat(String.valueOf(""));
        }
        else
        {

             AppValues.getInstance().setLat(String.valueOf(gps.getLatitude()));
        }

        if (String.valueOf(l.getLongitude()).equals("") || String.valueOf(l.getLongitude()).equals(0))
        {
            AppValues.getInstance().setLng(String.valueOf(""));
        }
        else
        {

            AppValues.getInstance().setLng(String.valueOf(gps.getLongitude()));
        }

          fl.setLat(AppValues.getInstance().getLat());
          fl.setLng(AppValues.getInstance().getLng());

        FormDoc fdoc = new FormDoc();
        fdoc.setDocument_id("doc-" +  UUID.randomUUID().toString());
        fdoc.setTimestamp(d.getTime());

        fdoc.setOrg(o);
        fdoc.setForm(f);
        fdoc.setWorker(w);
        fdoc.setLocation(fl);
        fdoc.setData(RecordConverter.fromAppValue(getResources().getStringArray(R.array.id_index)));
        fdoc.setCompleted(completed);

        Gson gson = new Gson();
        String json = gson.toJson(fdoc);

        FormRecords fr = new FormRecords();
        fr.set_id(UUID.randomUUID().toString());
        fr.setUser_id(session.getLoginUserId());
        fr.setCreated_on(AppValues.getInstance().getRecordDT());
        fr.setQ_id(f.getId());
        fr.setSynced(false);
        fr.setFinished_on(d);
        fr.setCompleted(completed);
        fr.setRecords(json);

        DBHelper dh = new DBHelper(this);
        try {
            dh.createFormRecords(fr);
            AppValues.getInstance().setCurrentRecords(new HashMap<String, String>());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected boolean onTabChangedWithJump(final PagerAdapter adapter, final int oldPosition, final int newPosition) {
        int jump=-1;
        if(jumping){
            if(newPosition == targetJump){
                jumping=false;
                targetJump=-1;
            }
        }
        else{
            if(oldPosition>-1) {
                if (oldPosition > newPosition) {
                    // to left
                    jump = skipToLeft(oldPosition);

                } else {
                    // to right
                    jump = skipToRight(oldPosition);

                }

                if(jump == oldPosition){
                    //required field's value missing
                    Toast toast = Toast.makeText(getApplicationContext(),"Missing required fields.", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
                if (jump > -1) {
                    jumping = true;
                    targetJump=jump;
                    mCurrentTabPosition = jump - 1;
                    viewPager.setCurrentItem(jump);
                    return true;
                }
            }
        }
        return false;
    }

    private int skipToRight(int oldPos) {
        Fragment f = mSingleAdapter.getRegFragment(oldPos);

        String[] qs = getResources().getStringArray(R.array.question_titles);

        switch (qs[oldPos]){
            case "SC_A":
              //  fromIndex.put("J2","SC_A");
               // return getQIndex(qs,"J2");
                if((!AppValues.getInstance().getCurrentRecords().containsKey("sc_a"))){
                    return oldPos;
                }
                else if(AppValues.getInstance().getCurrentRecords().containsKey("sc_a")
                        && AppValues.getInstance().getCurrentRecords().get("sc_a").equals("2")){
                    fromIndex.put("SUBMIT","SC_A");
                    return getQIndex(qs,"SUBMIT");
                }
                break;
            case "SC_B":
                    if((!AppValues.getInstance().getCurrentRecords().containsKey("sc_b"))){
                    return oldPos;
                }
                else if(AppValues.getInstance().getCurrentRecords().containsKey("sc_b")
                        && AppValues.getInstance().getCurrentRecords().get("sc_b").equals("2")){
                    fromIndex.put("SUBMIT","SC_B");
                    return getQIndex(qs,"SUBMIT");
                }
                    break;
            case "SC_C":
                if((!AppValues.getInstance().getCurrentRecords().containsKey("sc_c"))){
                    return oldPos;
                }
                else if(AppValues.getInstance().getCurrentRecords().containsKey("sc_c")
                        && AppValues.getInstance().getCurrentRecords().get("sc_c").equals("4")){
                    fromIndex.put("SC_E","SC_C");
                    return getQIndex(qs,"SC_E");
                }
                else if(AppValues.getInstance().getCurrentRecords().containsKey("sc_c")
                        && AppValues.getInstance().getCurrentRecords().get("sc_c").equals("3")){
                    fromIndex.put("SUBMIT","SC_C");
                    return getQIndex(qs,"SUBMIT");
                }
                    break;
            case "SC_D":
                if((!AppValues.getInstance().getCurrentRecords().containsKey("sc_d"))){
                    return oldPos;
                }
                else if(AppValues.getInstance().getCurrentRecords().containsKey("sc_d")
                        && AppValues.getInstance().getCurrentRecords().get("sc_d").equals("2")){
                    fromIndex.put("SUBMIT","SC_D");
                    return getQIndex(qs,"SUBMIT");
                }
                    break;
            case "SC_E":
                if((!AppValues.getInstance().getCurrentRecords().containsKey("sc_e"))){
                    return oldPos;
                }
                else if(AppValues.getInstance().getCurrentRecords().containsKey("sc_e")
                        && AppValues.getInstance().getCurrentRecords().get("sc_e").equals("1")){
                    fromIndex.put("SUBMIT","SC_E");
                    return getQIndex(qs,"SUBMIT");
                }
                break;
            case"PRE":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("pre_state") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("pre_township") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("pre_village") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("pre_type") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("pre_respondent") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("pre_designated")){
                    return oldPos;
                }
                break;
            case "A1":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("a1_1_a1_b") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("a1_1_a1_c") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("a1_1_a1_d") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("a1_1_a1_e") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("a1_1_a1_f") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("a1_1_a1_g")){
                    return oldPos;
                }
                break;
            case "B1":
                if((!AppValues.getInstance().getCurrentRecords().containsKey("b1")) ||
                        (AppValues.getInstance().getCurrentRecords().get("b1").equals("5") && !AppValues.getInstance().getCurrentRecords().containsKey("b1_other"))){
                    return oldPos;
                }
                break;
            case "B2":
                if((!AppValues.getInstance().getCurrentRecords().containsKey("b2")) ||
                        (AppValues.getInstance().getCurrentRecords().get("b2").equals("6") && !AppValues.getInstance().getCurrentRecords().containsKey("b2_other"))){
                    return oldPos;
                }
                break;
            case "B3":
                if((!AppValues.getInstance().getCurrentRecords().containsKey("b3")) ||
                        (AppValues.getInstance().getCurrentRecords().get("b3").equals("6") && !AppValues.getInstance().getCurrentRecords().containsKey("b3_other"))){
                    return oldPos;
                }
                break;
            case "B4":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("b4")){
                    return oldPos;
                }
                break;
            case "B5":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("b5")){
                    return oldPos;
                }
                break;
            case "B6":
                View v =f.getView();
                RadioGroup rg = (RadioGroup)v.findViewById(R.id.rg_b6);
                if(rg!=null && rg.getCheckedRadioButtonId()!= -1){
                    if(rg.getCheckedRadioButtonId()==R.id.rg_b6_3 || rg.getCheckedRadioButtonId()==R.id.rg_b6_4){
                        fromIndex.put("B10","B6");
                        return getQIndex(qs,"B10");
                    }
                }else{
                    return oldPos;
                }
                break;
            case "B7":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("b7")){
                    return oldPos;
                }
                break;
            case "B8":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("b8")){
                    return oldPos;
                }
                break;
            case "B9":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("b9")){
                    return oldPos;
                }
                break;
            case "B10":
                if((!AppValues.getInstance().getCurrentRecords().containsKey("b10")) ||
                        (AppValues.getInstance().getCurrentRecords().get("b10").equals("1") && !AppValues.getInstance().getCurrentRecords().containsKey("b10_other"))){
                    return oldPos;
                }
                break;
            case "B11":
                if((!AppValues.getInstance().getCurrentRecords().containsKey("b11")) ||
                        (AppValues.getInstance().getCurrentRecords().get("b11").equals("1") &&
                                !AppValues.getInstance().getCurrentRecords().containsKey("b11_other"))){
                    return oldPos;
                }
                break;
            case "B12":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("b12_1_1") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("b12_1_2") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("b12_2_1") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("b12_2_2") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("b12_3_1") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("b12_3_2")){
                    return oldPos;
                }
                break;
            case "C1":
                if((!AppValues.getInstance().getCurrentRecords().containsKey("c1")) ||
                        (AppValues.getInstance().getCurrentRecords().get("c1").equals("8") &&
                                !AppValues.getInstance().getCurrentRecords().containsKey("c1_other"))){
                    return oldPos;
                }
                break;
            case "C2":
                if((!AppValues.getInstance().getCurrentRecords().containsKey("c2_1")) &&
                        (!AppValues.getInstance().getCurrentRecords().containsKey("c2_2")) &&
                        (!AppValues.getInstance().getCurrentRecords().containsKey("c2_3")) &&
                        (!AppValues.getInstance().getCurrentRecords().containsKey("c2_4"))){
                    return oldPos;
                }
                else if(AppValues.getInstance().getCurrentRecords().containsKey("c2_5") &&
                        !AppValues.getInstance().getCurrentRecords().containsKey("c2_other")){
                    return oldPos;
                }
                break;
            case "C3":
                if((!AppValues.getInstance().getCurrentRecords().containsKey("c3_1")) &&
                        (!AppValues.getInstance().getCurrentRecords().containsKey("c3_2")) &&
                        (!AppValues.getInstance().getCurrentRecords().containsKey("c3_3")) &&
                        (!AppValues.getInstance().getCurrentRecords().containsKey("c3_4"))){
                    return oldPos;
                }
                else if(AppValues.getInstance().getCurrentRecords().containsKey("c3_5") &&
                        !AppValues.getInstance().getCurrentRecords().containsKey("c3_other")){
                    return oldPos;
                }
                break;
            case "C4":
                if((!AppValues.getInstance().getCurrentRecords().containsKey("c4_1")) &&
                        (!AppValues.getInstance().getCurrentRecords().containsKey("c4_2")) &&
                        (!AppValues.getInstance().getCurrentRecords().containsKey("c4_3")) &&
                        (!AppValues.getInstance().getCurrentRecords().containsKey("c4_4")) &&
                        (!AppValues.getInstance().getCurrentRecords().containsKey("c4_5"))){
                    return oldPos;
                }
                else if(AppValues.getInstance().getCurrentRecords().containsKey("c4_6") &&
                        !AppValues.getInstance().getCurrentRecords().containsKey("c4_other")){
                    return oldPos;
                }
                break;
            case "C5":
                if((!AppValues.getInstance().getCurrentRecords().containsKey("c5_1")) &&
                        (!AppValues.getInstance().getCurrentRecords().containsKey("c5_2")) &&
                        (!AppValues.getInstance().getCurrentRecords().containsKey("c5_3")) &&
                        (!AppValues.getInstance().getCurrentRecords().containsKey("c5_4")) &&
                        (!AppValues.getInstance().getCurrentRecords().containsKey("c5_5")) &&
                        (!AppValues.getInstance().getCurrentRecords().containsKey("c5_6"))){
                    return oldPos;
                }
                break;
            case "C6":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("c6")){
                    return oldPos;
                }
                break;
            case "C7":
                if((!AppValues.getInstance().getCurrentRecords().containsKey("c7_1")) &&
                        (!AppValues.getInstance().getCurrentRecords().containsKey("c7_2")) &&
                        (!AppValues.getInstance().getCurrentRecords().containsKey("c7_3")) &&
                        (!AppValues.getInstance().getCurrentRecords().containsKey("c7_4")) &&
                        (!AppValues.getInstance().getCurrentRecords().containsKey("c7_5")) &&
                        (!AppValues.getInstance().getCurrentRecords().containsKey("c7_6"))){
                    return oldPos;
                }
                else if(AppValues.getInstance().getCurrentRecords().containsKey("c7_7") &&
                        !AppValues.getInstance().getCurrentRecords().containsKey("c7_other")){
                    return oldPos;
                }
                break;
            case "C8":
                if((!AppValues.getInstance().getCurrentRecords().containsKey("c8")) ||
                        (AppValues.getInstance().getCurrentRecords().get("c8").equals("2") &&
                                !AppValues.getInstance().getCurrentRecords().containsKey("c2_2_0"))||
                        (AppValues.getInstance().getCurrentRecords().get("c8").equals("6") &&
                                !AppValues.getInstance().getCurrentRecords().containsKey("c8_other"))){
                    return oldPos;
                }
                break;
            case "C9":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("c9_1") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("c9_2") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("c9_3") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("c9_4") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("c9_5") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("c9_6") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("c9_7") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("c9_8") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("c9_9") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("c9_10") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("c9_11") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("c9_12") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("c9_13") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("c9_14") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("c9_15")){
                    return oldPos;
                }
                break;
            case "C10":
                View v10 =f.getView();
                RadioGroup rg10 = (RadioGroup)v10.findViewById(R.id.rg_c10);
                if(rg10!=null && rg10.getCheckedRadioButtonId()!= -1){
                    if(rg10.getCheckedRadioButtonId()==R.id.rg_c10_1 || rg10.getCheckedRadioButtonId()==R.id.rg_c10_2 || rg10.getCheckedRadioButtonId()==R.id.rg_c10_3){
                        fromIndex.put("C12","C10");
                        return getQIndex(qs,"C12");
                    }
                }
                else{
                    return oldPos;
                }
                break;
            case "C11":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("c11")){
                    return oldPos;
                }
                break;
            case "C12":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("c12")){
                    return oldPos;
                }
                break;
            case "C13":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("c13")){
                    return oldPos;
                }
                break;
            case "C14":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("c14")){
                    return oldPos;
                }
                break;
            case "C15":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("c15")){
                    return oldPos;
                }
                break;
            case "D1":
                View vd1 =f.getView();
                RadioGroup rgd1 = (RadioGroup)vd1.findViewById(R.id.rg_d1);
                if(rgd1!=null && rgd1.getCheckedRadioButtonId()!= -1){
                    if(rgd1.getCheckedRadioButtonId()==R.id.rg_d1_0){
                        fromIndex.put("D6","D1");
                        return getQIndex(qs,"D6");
                    }
                }
                else{
                    return oldPos;
                }
                break;
            case "D2":
                View vd2 =f.getView();
                RadioGroup rgd2 = (RadioGroup)vd2.findViewById(R.id.rg_d2);
                if(rgd2!=null && rgd2.getCheckedRadioButtonId()!= -1){
                    if(rgd2.getCheckedRadioButtonId()==R.id.rg_d2_1){
                        fromIndex.put("D4","D2");
                        return getQIndex(qs,"D4");
                    }
                }
                else{
                    return oldPos;
                }
                break;
            case "D3":
                if((!AppValues.getInstance().getCurrentRecords().containsKey("d3")) ||
                        (AppValues.getInstance().getCurrentRecords().get("d3").equals("7") &&
                                !AppValues.getInstance().getCurrentRecords().containsKey("d3_other"))){
                    return oldPos;
                }
                break;
            case "D4":
                if((!AppValues.getInstance().getCurrentRecords().containsKey("d4")) ||
                        (AppValues.getInstance().getCurrentRecords().get("d4").equals("10") &&
                                !AppValues.getInstance().getCurrentRecords().containsKey("d4_other"))){
                    return oldPos;
                }
                break;
            case "D5":
                if((!AppValues.getInstance().getCurrentRecords().containsKey("d5")) ||
                        (AppValues.getInstance().getCurrentRecords().get("d5").equals("5") &&
                                !AppValues.getInstance().getCurrentRecords().containsKey("d5_other"))){
                    return oldPos;
                }
                break;
            case "D6":
                View vd6 =f.getView();
                RadioGroup rgd6 = (RadioGroup)vd6.findViewById(R.id.rg_d6);
                if(rgd6!=null && rgd6.getCheckedRadioButtonId()!= -1){
                    if(rgd6.getCheckedRadioButtonId()==R.id.rg_d6_2){
                        fromIndex.put("E","D6");
                        return getQIndex(qs,"E");
                    }
                }
                else{
                    return  oldPos;
                }

                break;
            case "D7":
                View vd7 =f.getView();
                RadioGroup rgd7 = (RadioGroup)vd7.findViewById(R.id.rg_d7);
                if(rgd7!=null && rgd7.getCheckedRadioButtonId()!= -1){
                    if(rgd7.getCheckedRadioButtonId()==R.id.rg_d7_0){
                        fromIndex.put("E","D7");
                        return getQIndex(qs,"E");
                    }
                    else if((!AppValues.getInstance().getCurrentRecords().containsKey("d7")) ||
                            (AppValues.getInstance().getCurrentRecords().get("d7").equals("10") &&
                                    !AppValues.getInstance().getCurrentRecords().containsKey("d7_other"))){
                        return oldPos;
                    }
                }
                else{
                    return oldPos;
                }
                break;
            case "D8":
                View vd8 =f.getView();
                RadioGroup rgd8 = (RadioGroup)vd8.findViewById(R.id.rg_d8);
                if(rgd8!=null && rgd8.getCheckedRadioButtonId()!= -1){
                    if(rgd8.getCheckedRadioButtonId()==R.id.rg_d8_1){
                        fromIndex.put("D10","D8");
                        return getQIndex(qs,"D10");
                    }
                }
                else{
                    return oldPos;
                }
                break;
            case "D9":
                if((!AppValues.getInstance().getCurrentRecords().containsKey("d9")) ||
                        (AppValues.getInstance().getCurrentRecords().get("d9").equals("7") &&
                                !AppValues.getInstance().getCurrentRecords().containsKey("d9_other"))){
                    return oldPos;
                }
                break;
            case "D10":
                if((!AppValues.getInstance().getCurrentRecords().containsKey("d10")) ||
                        (AppValues.getInstance().getCurrentRecords().get("d10").equals("10") &&
                                !AppValues.getInstance().getCurrentRecords().containsKey("d10_other"))){
                    return oldPos;
                }
                break;
            case "D11":
                if((!AppValues.getInstance().getCurrentRecords().containsKey("d11")) ||
                        (AppValues.getInstance().getCurrentRecords().get("d11").equals("5") &&
                                !AppValues.getInstance().getCurrentRecords().containsKey("d5_other"))){
                    return oldPos;
                }
                break;
            case "F1":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("f1")){
                    return oldPos;
                }
                break;
            case "F2":
                View vf2 =f.getView();
                RadioGroup rgf2 = (RadioGroup)vf2.findViewById(R.id.rg_f2);
                if(rgf2!=null && rgf2.getCheckedRadioButtonId()!= -1){
                    if(rgf2.getCheckedRadioButtonId()==R.id.rg_f2_6){
                        fromIndex.put("G1","F2");
                        return getQIndex(qs,"G1");
                    }
                }
                else{
                    return oldPos;
                }
                break;
            case "F3":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("f3")){
                    return oldPos;
                }
                break;
            case "F4":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("f4_1") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("f4_2") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("f4_3") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("f4_4") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("f4_5") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("f4_6") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("f4_7") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("f4_8") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("f4_9") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("f4_10")){
                    return oldPos;
                }
                break;
            case "F5":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("f5_1") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("f5_2") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("f5_3") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("f5_4") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("f5_5") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("f5_6")){
                    return oldPos;
                }
                break;
            case "F6":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("f6")){
                    return oldPos;
                }
                break;
            case "F7":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("f7")){
                    return oldPos;
                }
                break;
            case "F8":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("f8_1") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("f8_2") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("f8_3") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("f8_4") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("f8_5")){
                    return oldPos;
                }
                break;
            case "F9":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("f9")){
                    return oldPos;
                }
                break;
            case "G1":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("g1")){
                    return oldPos;
                }
                break;
            case "G2":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("g2_1") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("g2_2")){
                    return oldPos;
                }
                break;
            case "G3":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("g3")){
                    return oldPos;
                }
                break;
            case "H1":
                View h1 =f.getView();
                EditText eh1 = (EditText)h1.findViewById(R.id.et_h1);
                if(h1!=null &&  eh1.getText()!=null){
                    if(Integer.parseInt(eh1.getText().toString())<1){
                        fromIndex.put("I1","H1");
                        return getQIndex(qs,"I1");
                    }
                }
                else{
                    return oldPos;
                }
                break;
            case "I1":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("i1")){
                    return oldPos;
                }
                break;
            case "I2":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("i2_1") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("i2_2") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("i2_3") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("i2_4") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("i2_5")){
                    return oldPos;
                }
                break;
            case "I3":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("i3_1") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("i3_2") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("i3_3") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("i3_4") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("i3_5")){
                    return oldPos;
                }
                break;
            case "I4":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("i4_1") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("i4_2") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("i4_3") ||
                       // !AppValues.getInstance().getCurrentRecords().containsKey("i4_4") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("i4_4")){
                    return oldPos;
                }
                break;
            case "I5":
                View vi5 =f.getView();
                RadioGroup rgi5 = (RadioGroup)vi5.findViewById(R.id.rg_i5);
                if(rgi5!=null && rgi5.getCheckedRadioButtonId()!= -1){
                    if(rgi5.getCheckedRadioButtonId()==R.id.rg_i5_1){
                        fromIndex.put("I7","I5");
                        return getQIndex(qs,"I7");
                    }
                }
                else{
                    return oldPos;
                }
                break;
            case "I6":
                View vi6 =f.getView();
                RadioGroup rgi6 = (RadioGroup)vi6.findViewById(R.id.rg_i6);
                if(rgi6!=null && rgi6.getCheckedRadioButtonId()!= -1){
                    if(rgi6.getCheckedRadioButtonId()==R.id.rg_i6_1 || rgi6.getCheckedRadioButtonId()==R.id.rg_i6_2){
                        fromIndex.put("I9","I6");
                        return getQIndex(qs,"I9");
                    }
                }
                else{
                    return oldPos;
                }
                break;
            case "I7":
                if((!AppValues.getInstance().getCurrentRecords().containsKey("i7")) ||
                        (AppValues.getInstance().getCurrentRecords().get("i7").equals("5") &&
                                !AppValues.getInstance().getCurrentRecords().containsKey("i7_other"))){
                    return oldPos;
                }
                break;
            case "I8":
                if((!AppValues.getInstance().getCurrentRecords().containsKey("i8_1")) &&
                        (!AppValues.getInstance().getCurrentRecords().containsKey("i8_2")) &&
                        (!AppValues.getInstance().getCurrentRecords().containsKey("i8_3")) &&
                        (!AppValues.getInstance().getCurrentRecords().containsKey("i8_4")) &&
                        (!AppValues.getInstance().getCurrentRecords().containsKey("i8_6"))){
                    return oldPos;
                }
                else if(AppValues.getInstance().getCurrentRecords().containsKey("i8_5") &&
                        !AppValues.getInstance().getCurrentRecords().containsKey("i8_other")){
                    return oldPos;
                }
                break;
            case "I9":
                View vi9 =f.getView();
                RadioGroup rgi9 = (RadioGroup)vi9.findViewById(R.id.rg_i9);
                if(rgi9!=null && rgi9.getCheckedRadioButtonId()!= -1){
                    if(rgi9.getCheckedRadioButtonId()==R.id.rg_i9_2){
                        fromIndex.put("SUBMIT","I9");
                        return getQIndex(qs,"SUBMIT");
                    }
                }
                else{
                    return oldPos;
                }
                break;
            case "I10":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("i10")){
                    return oldPos;
                }
                break;
            case "I11":
                View vi11 =f.getView();
                RadioGroup rgi11 = (RadioGroup)vi11.findViewById(R.id.rg_i11);
                if(rgi11!=null && rgi11.getCheckedRadioButtonId()!= -1){
                    if(rgi11.getCheckedRadioButtonId()==R.id.rg_i11_2){
                        fromIndex.put("SUBMIT","I11");
                        return getQIndex(qs,"SUBMIT");
                    }
                }
                else{
                    return oldPos;
                }
                break;
            case "I12":
                View vi12 =f.getView();
                RadioGroup rgi12 = (RadioGroup)vi12.findViewById(R.id.rg_i12);
                if(rgi12!=null && rgi12.getCheckedRadioButtonId()!= -1){
                    if(rgi12.getCheckedRadioButtonId()==R.id.rg_i12_6){
                        fromIndex.put("SUBMIT","I12");
                        return getQIndex(qs,"SUBMIT");
                    }
                    else if((!AppValues.getInstance().getCurrentRecords().containsKey("i12")) ||
                            (AppValues.getInstance().getCurrentRecords().get("i12").equals("5") &&
                                    !AppValues.getInstance().getCurrentRecords().containsKey("i12_other"))){
                        return oldPos;
                    }
                }
                else{
                    return oldPos;
                }
                break;
            case "I13":
                if((!AppValues.getInstance().getCurrentRecords().containsKey("i13_1")) &&
                        (!AppValues.getInstance().getCurrentRecords().containsKey("i13_2")) &&
                        (!AppValues.getInstance().getCurrentRecords().containsKey("i13_3")) &&
                        (!AppValues.getInstance().getCurrentRecords().containsKey("i13_4")) &&
                        (!AppValues.getInstance().getCurrentRecords().containsKey("i13_6"))){
                    return oldPos;
                }
                else if(AppValues.getInstance().getCurrentRecords().containsKey("i13_5") &&
                        !AppValues.getInstance().getCurrentRecords().containsKey("i13_other")){
                    return oldPos;
                }
                break;
            case "J1":
                View vj1 =f.getView();
                RadioGroup rgj1 = (RadioGroup)vj1.findViewById(R.id.rg_j1);
                if(rgj1!=null && rgj1.getCheckedRadioButtonId()!= -1){
                    if(rgj1.getCheckedRadioButtonId()==R.id.rg_j1_2){
                        fromIndex.put("J4","J1");
                        return getQIndex(qs,"J4");
                    }
                }
                else{
                    return oldPos;
                }
                break;
            case "J2":
                if((!AppValues.getInstance().getCurrentRecords().containsKey("j2_1_1")) &&
                        (!AppValues.getInstance().getCurrentRecords().containsKey("j2_2_1")) &&
                        (!AppValues.getInstance().getCurrentRecords().containsKey("j2_3_1")) &&
                        (!AppValues.getInstance().getCurrentRecords().containsKey("j2_4_1"))){
                    return oldPos;
                }
                break;
            case "J3":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("j3")){
                    return oldPos;
                }
                break;
            case "J4":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("j4")){
                    return oldPos;
                }
                break;
            case "J5":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("j5")){
                    return oldPos;
                }
                break;
            default:
                break;
        }
        return -1;
    }

    private int skipToLeft(int oldPos) {
        String[] qs = getResources().getStringArray(R.array.question_titles);
        String thisQ = qs[oldPos];
        if(fromIndex.containsKey(thisQ)){
            String fromQ = fromIndex.get(thisQ);
            fromIndex.remove(thisQ);
            return getQIndex(qs,fromQ);
        }
        return -1;
    }

    private int getQIndex(String[] qs, String searchItem){
        int x = -1;
        for(int i=0; i<qs.length;i++){
            if(qs[i].equals(searchItem)){
                x = i;
                break;
            }
        }
        return x;
    }

    public void ShowDialog(){
        final Dialog dialog = new Dialog(Question175Activity.this);
        dialog.setContentView(R.layout.dialog_ref);
        dialog.setTitle("Custom Dialog");
        dialog.show();
        Button declineButton = (Button) dialog.findViewById(R.id.btn_ok);
        declineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    @Override
    public void onBackPressed() {
        showClosingDialog();
    }

    private void showClosingDialog(){
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Closing the Interview")
                .setMessage("Are you sure you want to end this survey?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        doForm(false);
                        finish();
                        Intent intent = new Intent(Question175Activity.this, MainActivity.class);
                        startActivity(intent);
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }
}
