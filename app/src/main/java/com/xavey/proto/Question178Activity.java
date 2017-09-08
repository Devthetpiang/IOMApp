package com.xavey.proto;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;

import com.google.gson.Gson;
import com.xavey.proto.adapter.SingleAdapter;
import com.xavey.proto.adapter.SingleAdapter178;
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
public class Question178Activity extends BaseActivity {
    private ViewPager viewPager;
    private int mCurrentTabPosition = 0;
    private SingleAdapter178 mSingleAdapter;
    private SessionManager session;
    private HashMap<String,String> fromIndex = new HashMap<String,String>();
    private boolean jumping=false;
    private int targetJump = -1;
    //public  GPSTracker gps;
    Location l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.activity_question);
        session = new SessionManager(this);
        viewPager = (ViewPager) findViewById(R.id.pager);
        mSingleAdapter = new SingleAdapter178(getSupportFragmentManager(),getResources().getStringArray(R.array.question_titles_178));
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
        f.setId(Integer.parseInt(getResources().getString(R.string.form_id_178)));
        f.setTitle(getResources().getString(R.string.form_title_178));

        Worker w = new Worker();
        w.setId(session.getLoginUserId());
        w.setName(session.getLoginUserName());

        FormLocation fl = new FormLocation();
        GPSTracker gps=new GPSTracker();
        Location l=gps.getLocation(this);


        if(String.valueOf(gps.getLatitude()).equals("") || String.valueOf(gps.getLatitude()).equals(0) )
        {
              AppValues.getInstance().setLat(String.valueOf(""));
        }
        else
       {
            //  fl.setLat(String.valueOf(l.getLatitude()));
            //  AppValues.getInstance().getLat().equals("");
              AppValues.getInstance().setLat(String.valueOf(gps.getLatitude()));
        }

        if (String.valueOf(gps.getLongitude()).equals("") || String.valueOf(gps.getLongitude()).equals(0))
       {
           AppValues.getInstance().setLng(String.valueOf(""));
        }
        else
        {
             // fl.setLng(String.valueOf(l.getLongitude()));
             // AppValues.getInstance().getCurrentRecords().clear();
            AppValues.getInstance().setLng(String.valueOf(gps.getLongitude()));
        }

        fl.setLat(AppValues.getInstance().getLat());
        fl.setLng(AppValues.getInstance().getLng());

        FormDoc fdoc = new FormDoc();
        fdoc.setDocument_id("doc-" + UUID.randomUUID().toString());
        fdoc.setTimestamp(d.getTime());

        fdoc.setOrg(o);
        fdoc.setForm(f);
        fdoc.setWorker(w);
        fdoc.setLocation(fl);
        fdoc.setData(RecordConverter.fromAppValue(getResources().getStringArray(R.array.id_index_178)));
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

        String[] qs = getResources().getStringArray(R.array.question_titles_178);

        switch (qs[oldPos]){
            case"PRE":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("pre_state") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("pre_township") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("pre_village") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("pre_type") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("pre_respondent") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("pre_respondent_title")){
                    return oldPos;
                }
                break;
            case "Q1":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("q1")){
                    return oldPos;
                }
                break;
            case "Q2":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("q2")){
                    return oldPos;
                }
                break;
            case "Q3A":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("q3a")){
                    return oldPos;
                }
                break;
            case "Q3B":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("q3b1") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("q3b2") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("q3b3")){
                    return oldPos;
                }
                break;
            case "Q4":
                if((!AppValues.getInstance().getCurrentRecords().containsKey("q4a")) ||
                        (AppValues.getInstance().getCurrentRecords().get("q4a").equals("10") &&
                                !AppValues.getInstance().getCurrentRecords().containsKey("q4a_other")) ||
                (!AppValues.getInstance().getCurrentRecords().containsKey("q4b")) ||
                        (AppValues.getInstance().getCurrentRecords().get("q4b").equals("10") &&
                                !AppValues.getInstance().getCurrentRecords().containsKey("q4b_other")) ||
                (!AppValues.getInstance().getCurrentRecords().containsKey("q4c")) ||
                        (AppValues.getInstance().getCurrentRecords().get("q4c").equals("10") &&
                                !AppValues.getInstance().getCurrentRecords().containsKey("q4c_other"))){
                    return oldPos;
                }
                break;
            case "Q5":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("q5a") ||
                        !AppValues.getInstance().getCurrentRecords().containsKey("q5b")){
                    return oldPos;
                }
                break;
            case "Q6":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("q6")){
                    return oldPos;
                }
                break;
            case "Q7":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("q7")){
                    return oldPos;
                }
                break;
            case "Q8":
                if((!AppValues.getInstance().getCurrentRecords().containsKey("q8")) ||
                        (AppValues.getInstance().getCurrentRecords().get("q8").equals("5") &&
                                !AppValues.getInstance().getCurrentRecords().containsKey("q8_other"))){
                    return oldPos;
                }
                break;
            case "Q9":
                View q9 =f.getView();
                RadioGroup rg9 = (RadioGroup)q9.findViewById(R.id.rg_q9);
                if(rg9!=null && rg9.getCheckedRadioButtonId()!= -1){
                    if(rg9.getCheckedRadioButtonId()==R.id.rg_q9_2){
                        fromIndex.put("Q11","Q9");
                        return getQIndex(qs,"Q11");
                    }
                }
                else{
                    return oldPos;
                }
                break;
            case "Q10":
                if((!AppValues.getInstance().getCurrentRecords().containsKey("q10")) ||
                        (AppValues.getInstance().getCurrentRecords().get("q10").equals("4") &&
                                !AppValues.getInstance().getCurrentRecords().containsKey("q10_other"))){
                    return oldPos;
                }
                break;
            case "Q11":
                if((!AppValues.getInstance().getCurrentRecords().containsKey("q11")) ||
                        (AppValues.getInstance().getCurrentRecords().get("q11").equals("7") &&
                                !AppValues.getInstance().getCurrentRecords().containsKey("q11_other"))){
                    return oldPos;
                }
                break;
            case "Q12":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("q12")){
                    return oldPos;
                }
                break;
            case "Q13":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("q13")){
                    return oldPos;
                }
                break;
            case "Q14":
                if((!AppValues.getInstance().getCurrentRecords().containsKey("q14a")) ||
                        (!AppValues.getInstance().getCurrentRecords().containsKey("q14b")) ||
                        (!AppValues.getInstance().getCurrentRecords().containsKey("q14c")) ||
                        (!AppValues.getInstance().getCurrentRecords().containsKey("q14d")) ||
                        (!AppValues.getInstance().getCurrentRecords().containsKey("q14e")) ||
                        (!AppValues.getInstance().getCurrentRecords().containsKey("q14f")) ||
                        (!AppValues.getInstance().getCurrentRecords().containsKey("q14g")) ||
                        (!AppValues.getInstance().getCurrentRecords().containsKey("q14h"))){
                    return oldPos;
                }
                break;
            case "Q15":
                if((!AppValues.getInstance().getCurrentRecords().containsKey("q15a")) ||
                        (!AppValues.getInstance().getCurrentRecords().containsKey("q15b")) ||
                        (!AppValues.getInstance().getCurrentRecords().containsKey("q15c")) ||
                        (!AppValues.getInstance().getCurrentRecords().containsKey("q15d")) ||
                        (!AppValues.getInstance().getCurrentRecords().containsKey("q15e"))){
                    return oldPos;
                }
                break;
            case "Q16":
                if((!AppValues.getInstance().getCurrentRecords().containsKey("q16_1")) &&
                        (!AppValues.getInstance().getCurrentRecords().containsKey("q16_2")) &&
                        (!AppValues.getInstance().getCurrentRecords().containsKey("q16_3")) &&
                        (!AppValues.getInstance().getCurrentRecords().containsKey("q16_4"))){
                    return oldPos;
                }
                else if(AppValues.getInstance().getCurrentRecords().containsKey("q16_4") &&
                        !AppValues.getInstance().getCurrentRecords().containsKey("q16_other")){
                    return oldPos;
                }
                break;
            case "Q17":
                if((!AppValues.getInstance().getCurrentRecords().containsKey("q17a")) ||
                        (!AppValues.getInstance().getCurrentRecords().containsKey("q17b")) ||
                        (!AppValues.getInstance().getCurrentRecords().containsKey("q17c")) ||
                        (!AppValues.getInstance().getCurrentRecords().containsKey("q17d")) ||
                        (!AppValues.getInstance().getCurrentRecords().containsKey("q17e")) ||
                        (!AppValues.getInstance().getCurrentRecords().containsKey("q17f"))){
                    return oldPos;
                }
                break;
            case "Q18":if((!AppValues.getInstance().getCurrentRecords().containsKey("q18a")) ||
                    (!AppValues.getInstance().getCurrentRecords().containsKey("q18b")) ||
                    (!AppValues.getInstance().getCurrentRecords().containsKey("q18c")) ||
                    (!AppValues.getInstance().getCurrentRecords().containsKey("q18d")) ||
                    (!AppValues.getInstance().getCurrentRecords().containsKey("q18e")) ||
                    (!AppValues.getInstance().getCurrentRecords().containsKey("q18f")) ||
                    (!AppValues.getInstance().getCurrentRecords().containsKey("q18g"))){
                return oldPos;
            }
                break;
            case "Q19":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("q19")){
                    return oldPos;
                }
                break;
            case "Q20":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("q20")){
                    return oldPos;
                }
                break;
            case "Q21":
                if(!AppValues.getInstance().getCurrentRecords().containsKey("q21")){
                    return oldPos;
                }
                break;

            default:
                break;
        }
        return -1;
    }

    private int skipToLeft(int oldPos) {
        String[] qs = getResources().getStringArray(R.array.question_titles_178);
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
        final Dialog dialog = new Dialog(Question178Activity.this);
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
                        Intent intent = new Intent(Question178Activity.this, MainActivity.class);
                        startActivity(intent);
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }
}
