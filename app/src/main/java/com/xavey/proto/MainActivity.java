package com.xavey.proto;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.location.Location;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.xavey.proto.adapter.RecordAdapter;
import com.xavey.proto.api.SampleClient;
import com.xavey.proto.api.model.FormRecords;
import com.xavey.proto.api.model.SyncStatus;
import com.xavey.proto.api.model.json.FormDoc;
import com.xavey.proto.helper.AppValues;
import com.xavey.proto.helper.DBHelper;
import com.xavey.proto.helper.SessionManager;
import com.xavey.proto.helper.GPSTracker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    RecordAdapter recAdapter;
    ListView lv_main;
    SessionManager session;
    DBHelper dh;
    public Dialog dialog;
    GPSTracker gps;
    Location l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // gps = GPSTracker.getInstance();
        gps=new GPSTracker();
        gps.set_context(this);
        gps.getLocation(this);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        lv_main = (ListView) findViewById(R.id.lv_main);
        setSupportActionBar(toolbar);



        session = new SessionManager(this);
        dh = new DBHelper(this);
        displayDashboard();
        AppValues.getInstance().setCurrentRecords(new HashMap<String, String>());
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMenuDialog();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_sync) {
            SyncDocs(true,true);
        }  else if (id == R.id.nav_stat) {

        }
           else if (id == R.id.nav_export) {

            try {
                export_json();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            else if (id == R.id.nav_logout) {
            session.setLogin(false);
            session.setToken("");
            session.setLoginUser(-1, "");
            finish();
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showMenuDialog(){
        dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_menu);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        Window window = dialog.getWindow();
        WindowManager.LayoutParams param = window.getAttributes();
        param.gravity = Gravity.BOTTOM | Gravity.RIGHT;
        dialog.setCanceledOnTouchOutside(true);

        View cross =(View) dialog.findViewById(R.id.cross);
        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        View community =(View) dialog.findViewById(R.id.rl_community);
        community.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(gps.canGetLocation()){

                    AppValues.getInstance().setLat(String.valueOf(gps.getLatitude()));
                    AppValues.getInstance().setLng(String.valueOf(gps.getLongitude()));
                    AppValues.getInstance().setWorkingForm(178);
                    Intent intent = new Intent(MainActivity.this, Question178Activity.class);
                    startActivity(intent);

                }
                else{
                    gps.showSettingsAlert("GPS Setting","This form needs GPS location. Please turn on your GPS to continue.");
                }


            }
        });

        View grandparent =(View) dialog.findViewById(R.id.rl_grandparent);
        grandparent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gps.canGetLocation()){
                    AppValues.getInstance().setLat(String.valueOf(gps.getLatitude()));
                    AppValues.getInstance().setLng(String.valueOf(gps.getLongitude()));
                    AppValues.getInstance().setWorkingForm(175);
                    Intent intent = new Intent(MainActivity.this, Question175Activity.class);
                    startActivity(intent);

                     }
                else{
                    gps.showSettingsAlert("GPS Setting","This form needs GPS location. Please turn on your GPS to continue.");
                }

            }
        });

        dialog.show();
    }

    private void displayDashboard(){
        String completed_synced = "Completed, Uploaded";
        String completed = "Completed, Un-uploaded";
        String uncompleted = "Uncompleted, Un-uploaded";
        String uncompleted_synced = "Uncompleted, Uploaded";
        try {
            ArrayList<FormRecords> frs = dh.getAllRecordsByUser(session.getLoginUserId());
            HashMap<String, SyncStatus> thisMap = new HashMap<String, SyncStatus>();
            for (FormRecords fr : frs){
                if(fr.getCompleted() && !fr.getSynced()){
                    if(thisMap.containsKey(completed)){
                        SyncStatus ss = thisMap.get(completed);
                        ss.setTotalCount(ss.getTotalCount()+1);
                        thisMap.put(completed,ss);
                    }
                    else{
                        SyncStatus ss = new SyncStatus();
                        ss.setTotalCount(1);
                        ss.setGroup(completed);
                        ss.setSynced(false);
                        thisMap.put(completed,ss);
                    }
                }
                else if(fr.getCompleted() && fr.getSynced()){
                    if(thisMap.containsKey(completed_synced)){
                        SyncStatus ss = thisMap.get(completed_synced);
                        ss.setTotalCount(ss.getTotalCount()+1);
                        thisMap.put(completed_synced,ss);
                    }
                    else{
                        SyncStatus ss = new SyncStatus();
                        ss.setTotalCount(1);
                        ss.setGroup(completed_synced);
                        ss.setSynced(true);
                        thisMap.put(completed_synced,ss);
                    }
                }
                else if(!fr.getCompleted() && !fr.getSynced()){
                    if(thisMap.containsKey(uncompleted)){
                        SyncStatus ss = thisMap.get(uncompleted);
                        ss.setTotalCount(ss.getTotalCount()+1);
                        thisMap.put(uncompleted,ss);
                    }
                    else{
                        SyncStatus ss = new SyncStatus();
                        ss.setTotalCount(1);
                        ss.setGroup(uncompleted);
                        ss.setSynced(false);
                        thisMap.put(uncompleted,ss);
                    }
                }
                else if(!fr.getCompleted() && fr.getSynced()){
                    if(thisMap.containsKey(uncompleted_synced)){
                        SyncStatus ss = thisMap.get(uncompleted_synced);
                        ss.setTotalCount(ss.getTotalCount()+1);
                        thisMap.put(uncompleted_synced,ss);
                    }
                    else{
                        SyncStatus ss = new SyncStatus();
                        ss.setTotalCount(1);
                        ss.setGroup(uncompleted_synced);
                        ss.setSynced(true);
                        thisMap.put(uncompleted_synced,ss);
                    }
                }
            }

            recAdapter = new RecordAdapter(thisMap.values(), MainActivity.this);
            lv_main.setAdapter(recAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void export_json() throws IOException {
        ArrayList<FormRecords> frs = new ArrayList<FormRecords>();
        try {
            frs = dh.getAllRecordsBy(session.getLoginUserId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int j = 0; j < frs.size(); j++) {
            FormRecords fr_s = frs.get(j);
            Gson gson = new Gson();
            FormDoc fd = gson.fromJson(fr_s.getRecords(), FormDoc.class);
            fd.getData().size();
            fd.setSubmit_datetime(new Date().toString());
            String json = gson.toJson(fd);
            write_file(json,fd.getDocument_id()+".txt");

        }
    }



    public void export_csv() throws IOException {
        Boolean returnCode = false;
        int i = 0;
        String csvHeader = "";
        String csvValues = "";
        write_file("","");
        // no of record  12 data.0 data.1.. data.11

        String header = "_id,timestamp,form.id,form.title,location.lat,location.lng,document_id,submit_datetime,FormData.field_name,FormData.field_label,FromData.field_id,FormData.field_value,,worker.id,worker.name,Organization.id,Organization.org_name,completed";

        StringBuilder sb = new StringBuilder();

        ArrayList<FormRecords> frs = new ArrayList<FormRecords>();
        try {
            frs = dh.getAllRecordsBy(session.getLoginUserId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int j = 0; j < frs.size(); j++) {

            FormRecords fr_s = frs.get(j);
            Gson gson = new Gson();
            FormDoc fd = gson.fromJson(fr_s.getRecords(), FormDoc.class);
            fd.getData().size();
            sb.append(fd.get_id());
            sb.append(fd.getTimestamp());
            sb.append(fd.getForm().getId());
            sb.append(fd.getForm().getTitle());
            sb.append(fd.getLocation().getLat());
            sb.append(fd.getLocation().getLng());
            sb.append(fd.getDocument_id());
            sb.append(fd.getWorker().getId());
            sb.append(fd.getWorker().getName());
            sb.append(fd.getOrg().getId());
            sb.append(fd.getOrg().getOrg_name());
            sb.append(fd.getCompleted());

            fd.setSubmit_datetime(new Date().toString());

            for (i = 0; i < fd.getData().size(); i++) {
                header += "data." + String.valueOf(i) + ".field_id";
                sb.append(fd.getData().get(i).getField_id());
                header += "data." + String.valueOf(i) + ".field_name";
                sb.append(fd.getData().get(i).getField_id());
                header += "data." + String.valueOf(i) + ".field_label";
                sb.append(fd.getData().get(i).getField_id());
                header += "data." + String.valueOf(i) + ".field_value";
                sb.append(fd.getData().get(i).getField_id());
            }
        }
    }

    private  void write_file(String toWrite,String fileName) throws IOException
    {
        String root = Environment.getExternalStorageDirectory().toString();

        ApplicationValues.XAVEY_DIRECTORY = new File(root, "/Xavey");

        if (!ApplicationValues.XAVEY_DIRECTORY.exists()) {
            Boolean flag=ApplicationValues.XAVEY_DIRECTORY.mkdir();
        }

        final File CSV_DIRECTORY = new File(ApplicationValues.XAVEY_DIRECTORY, "ExportData");

        String outFileName = fileName;
        if (!CSV_DIRECTORY.exists()) {
            Boolean flag=CSV_DIRECTORY.mkdir();
        }

        File outFile = new File(CSV_DIRECTORY, outFileName);
        FileWriter fileWriter = new FileWriter(outFile);
        BufferedWriter out = new BufferedWriter(fileWriter);
        out.write(toWrite);
        out.close();
    }

    public void SyncDocs(boolean all, boolean completed) {
        ArrayList<FormRecords> frs = new ArrayList<FormRecords>();
        try {
            if(all){
               //do all
               frs = dh.getAllRecordsByUser_Unsynced(session.getLoginUserId());
            }
            else if(completed){
               //do completed
               frs = dh.getAllRecordsByUser_Unsynced_Completed(session.getLoginUserId());
            }
            else{
               //do uncompleted
               frs = dh.getAllRecordsByUser_Unsynced_Uncompleted(session.getLoginUserId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(frs!=null && frs.size()>0){
            Sync(frs.get(0).getRecords(),frs.get(0).get_id(), all,completed);
        }
    }

    private void Sync(String json, final String db_id, final boolean all, final boolean completed){
        Gson gson = new Gson();
        FormDoc fd = gson.fromJson(json, FormDoc.class);
        fd.getData().size(); // no of record  12 data.0 data.1.. data.11

        String header = "_id,timestamp,form.id,form.title,location.lat,location.lng,document_id,submit_datetime,FormData.field_name,FormData.field_label,FromData.field_id,FormData.field_value,,worker.id,worker.name,Organization.id,Organization.org_name,completed";

        StringBuilder sb = new StringBuilder();

        sb.append(fd.get_id());
        sb.append(fd.getTimestamp());
        sb.append(fd.getForm().getId());
        sb.append(fd.getForm().getTitle());
        sb.append(fd.getLocation().getLat());
        sb.append(fd.getLocation().getLng());
        sb.append(fd.getDocument_id());

        for (int i = 0; i < fd.getData().size(); i++) {
            header += "data." + String.valueOf(i) + ".field_id";
            sb.append(fd.getData().get(i).getField_id());
            header += "data." + String.valueOf(i) + ".field_name";
            sb.append(fd.getData().get(i).getField_id());
            header += "data." + String.valueOf(i) + ".field_label";
            sb.append(fd.getData().get(i).getField_id());
            header += "data." + String.valueOf(i) + ".field_value";
            sb.append(fd.getData().get(i).getField_id());
        }
        sb.append(fd.getWorker().getId());
        sb.append(fd.getWorker().getName());
        sb.append(fd.getOrg().getId());
        sb.append(fd.getOrg().getOrg_name());
        sb.append(fd.getCompleted());
        fd.setSubmit_datetime(new Date().toString());

        SampleClient.getWoodyApiClient(this).postDoc(session.getToken(), fd, new Callback<Object>() {
            @Override
            public void success(Object o, Response response) {

                try {
                    if (response.getStatus() == 200 && o != null) {
                        dh.updateFormRecordsSyncedStatus(true,db_id);
                        displayDashboard();
                        SyncDocs(all, completed);
                    } else{
                        Toast.makeText(getApplicationContext(),
                                getResources().getString(R.string.api_error_generic_message), Toast.LENGTH_LONG).show();

                    }
                } catch (Exception e) {
                    Log.d("SyncAPI", e.getStackTrace().toString());
                    Toast.makeText(getApplicationContext(),
                            e.getMessage(), Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("AuthAPI", error.toString());
                String err = "API Error, please try again";
                if (error.getMessage().equals(getResources().getString(R.string.api_error_offline))) {
                    err = (getResources().getString(R.string.api_error_offline_message));
                }
                Toast.makeText(getApplicationContext(),
                        err, Toast.LENGTH_LONG).show();
            }
        });
    }
}
