package com.xavey.proto.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.xavey.proto.api.model.FormRecords;
import com.xavey.proto.api.model.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by tinmaungaye on 3/30/16.
 */
public class DBHelper extends SQLiteOpenHelper {

    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Na me
    private static final String DATABASE_NAME = "XaveyProto";

    // Table Names
    protected static final String TABLE_FORMRECORDS = "form_records";
    protected static final String TABLE_USER = "user";
    protected static final String TABLE_AUTH = "auth";

    // auth column names
    protected static final String A_ATOKENT = "access_token";
    protected static final String A_RTOKEN = "refresh_token";
    protected static final String A_EXPIRESIN = "expires_in";
    protected static final String A_TOKENTYPE = "token_type";

    // user column names
    protected static final String U__ID = "_id";
    protected static final String U_USER_NAME = "username";
    protected static final String U_EMAIL = "email";
    protected static final String U_ROLE = "role";
    protected static final String U_ORGANIZATION = "organization";
    protected static final String U_HASHED_PASSWORD = "hashed_password";
    protected static final String U_LAST_LOGGEDIN_ON = "last_login";
    protected static final String U_LAST_RECORDED_ON = "last_record";

    // form_record column names
    protected static final String FR_ID = "_id";
    protected static final String FR_Q_ID = "q_id";
    protected static final String FR_F_RECORDS = "f_records";
    protected static final String FR_CREATED_ON = "created_on";
    protected static final String FR_FINISHED_ON = "finished_on";
    protected static final String FR_COMPLETED = "completed";
    protected static final String FR_SYNCED = "synced";
    protected static final String FR_USER_ID = "user_id";

    // Table Create Statements

    private static final String CREATE_TABLE_FORMRECORDS = "CREATE TABLE IF NOT EXISTS "
            + TABLE_FORMRECORDS + "(" + FR_ID + " TEXT PRIMARY KEY,"
            + FR_Q_ID + " INTEGER,"
            + FR_F_RECORDS + " TEXT,"
            + FR_USER_ID + " TEXT,"
            + FR_SYNCED + " BOOLEAN,"
            + FR_COMPLETED + " BOOLEAN,"
            + FR_CREATED_ON + " DATETIME,"
            + FR_FINISHED_ON + " DATETIME" + ")";

    // User table create statement
    private static final String CREATE_TABLE_USER = "CREATE TABLE IF NOT EXISTS "
            + TABLE_USER + "(" + U__ID + " INTEGER PRIMARY KEY,"
            + U_USER_NAME + " TEXT,"
            + U_ROLE + " INTEGER,"
            + U_ORGANIZATION + " INTEGER,"
            + U_EMAIL + " TEXT,"
            + U_HASHED_PASSWORD + " TEXT,"
            + U_LAST_LOGGEDIN_ON + " DATETIME,"
            + U_LAST_RECORDED_ON + " DATETIME" + ")";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_FORMRECORDS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_AUTH);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FORMRECORDS);
        // create new tables
        onCreate(db);
    }

    /**
     * get datetime
     * */
    public String getDateTime(Date d) throws Exception{
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        return dateFormat.format(d);

    }
    public Date getDateTime(String d) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        return format.parse(d);
    }

    public Boolean getBoolean(Integer b){
        return b==1? true:false;
    }

    public void deleteAuth() throws Exception{
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_AUTH, null, null);
    }

    public ArrayList<FormRecords> getAllRecordsByUser(int user_id) throws Exception {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<FormRecords> lFR= new ArrayList<FormRecords>();
        String selectQuery = "SELECT * FROM " + TABLE_FORMRECORDS + " WHERE "+FR_USER_ID+" = "+user_id+" ORDER BY date("+ FR_CREATED_ON +") DESC";
        Log.e(LOG, selectQuery);
        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null) {
            if (c.moveToFirst()) {

                while (c.isAfterLast() == false) {
                    FormRecords n = new FormRecords();
                    n.set_id(c.getString(c.getColumnIndex(FR_ID)));
                    n.setRecords(c.getString(c.getColumnIndex(FR_F_RECORDS)));
                    n.setQ_id(c.getInt(c.getColumnIndex(FR_Q_ID)));
                    n.setSynced(getBoolean(c.getInt(c.getColumnIndex(FR_SYNCED))));
                    n.setCreated_on(getDateTime(c.getString(c.getColumnIndex(FR_CREATED_ON))));
                    n.setFinished_on(getDateTime(c.getString(c.getColumnIndex(FR_FINISHED_ON))));
                    n.setCompleted(getBoolean(c.getInt(c.getColumnIndex(FR_COMPLETED))));
                    n.setUser_id(c.getInt(c.getColumnIndex(FR_USER_ID)));
                    lFR.add(n);
                    c.moveToNext();
                }
            }
        }
        return lFR;
    }

    public ArrayList<FormRecords> getAllRecordsBy(int user_id) throws Exception {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<FormRecords> lFR= new ArrayList<FormRecords>();
        String selectQuery = "SELECT * FROM " + TABLE_FORMRECORDS + " WHERE  "+FR_USER_ID+" = "+user_id+"";
        Log.e(LOG, selectQuery);
        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null) {
            if (c.moveToFirst()) {

                while (c.isAfterLast() == false) {
                    FormRecords n = new FormRecords();
                    n.set_id(c.getString(c.getColumnIndex(FR_ID)));
                    n.setRecords(c.getString(c.getColumnIndex(FR_F_RECORDS)));
                    n.setQ_id(c.getInt(c.getColumnIndex(FR_Q_ID)));
                    n.setSynced(getBoolean(c.getInt(c.getColumnIndex(FR_SYNCED))));
                    n.setCreated_on(getDateTime(c.getString(c.getColumnIndex(FR_CREATED_ON))));
                    n.setFinished_on(getDateTime(c.getString(c.getColumnIndex(FR_FINISHED_ON))));
                    n.setCompleted(getBoolean(c.getInt(c.getColumnIndex(FR_COMPLETED))));
                    n.setUser_id(c.getInt(c.getColumnIndex(FR_USER_ID)));
                    lFR.add(n);
                    c.moveToNext();
                }
            }
        }
        return lFR;
    }

    public ArrayList<FormRecords> getAllRecordsByUser_Unsynced(int user_id) throws Exception {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<FormRecords> lFR= new ArrayList<FormRecords>();
        String selectQuery = "SELECT * FROM " + TABLE_FORMRECORDS + " WHERE "+FR_SYNCED+"=0 AND "+FR_USER_ID+" = "+user_id+" ORDER BY date("+ FR_CREATED_ON +") DESC";
        Log.e(LOG, selectQuery);
        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null) {
            if (c.moveToFirst()) {

                while (c.isAfterLast() == false) {
                    FormRecords n = new FormRecords();
                    n.set_id(c.getString(c.getColumnIndex(FR_ID)));
                    n.setRecords(c.getString(c.getColumnIndex(FR_F_RECORDS)));
                    n.setQ_id(c.getInt(c.getColumnIndex(FR_Q_ID)));
                    n.setSynced(getBoolean(c.getInt(c.getColumnIndex(FR_SYNCED))));
                    n.setCreated_on(getDateTime(c.getString(c.getColumnIndex(FR_CREATED_ON))));
                    n.setFinished_on(getDateTime(c.getString(c.getColumnIndex(FR_FINISHED_ON))));
                    n.setCompleted(getBoolean(c.getInt(c.getColumnIndex(FR_COMPLETED))));
                    n.setUser_id(c.getInt(c.getColumnIndex(FR_USER_ID)));
                    lFR.add(n);
                    c.moveToNext();
                }
            }
        }
        return lFR;
    }

    public ArrayList<FormRecords> getAllRecordsByUser_Unsynced_Completed(int user_id) throws Exception {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<FormRecords> lFR= new ArrayList<FormRecords>();
        String selectQuery = "SELECT * FROM " + TABLE_FORMRECORDS + " WHERE "+FR_SYNCED+"=0 AND "+ FR_COMPLETED +"=1 AND "+FR_USER_ID+" = "+user_id+" ORDER BY date("+ FR_CREATED_ON +") DESC";
        Log.e(LOG, selectQuery);
        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null) {
            if (c.moveToFirst()) {

                while (c.isAfterLast() == false) {
                    FormRecords n = new FormRecords();
                    n.set_id(c.getString(c.getColumnIndex(FR_ID)));
                    n.setRecords(c.getString(c.getColumnIndex(FR_F_RECORDS)));
                    n.setQ_id(c.getInt(c.getColumnIndex(FR_Q_ID)));
                    n.setSynced(getBoolean(c.getInt(c.getColumnIndex(FR_SYNCED))));
                    n.setCreated_on(getDateTime(c.getString(c.getColumnIndex(FR_CREATED_ON))));
                    n.setFinished_on(getDateTime(c.getString(c.getColumnIndex(FR_FINISHED_ON))));
                    n.setCompleted(getBoolean(c.getInt(c.getColumnIndex(FR_COMPLETED))));
                    n.setUser_id(c.getInt(c.getColumnIndex(FR_USER_ID)));
                    lFR.add(n);
                    c.moveToNext();
                }
            }
        }
        return lFR;
    }

    public ArrayList<FormRecords> getAllRecordsByUser_Unsynced_Uncompleted(int user_id) throws Exception {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<FormRecords> lFR= new ArrayList<FormRecords>();
        String selectQuery = "SELECT * FROM " + TABLE_FORMRECORDS + " WHERE "+FR_SYNCED+"=0 AND "+ FR_COMPLETED +"=0 AND "+FR_USER_ID+" = "+user_id+" ORDER BY date("+ FR_CREATED_ON +") DESC";
        Log.e(LOG, selectQuery);
        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null) {
            if (c.moveToFirst()) {

                while (c.isAfterLast() == false) {
                    FormRecords n = new FormRecords();
                    n.set_id(c.getString(c.getColumnIndex(FR_ID)));
                    n.setRecords(c.getString(c.getColumnIndex(FR_F_RECORDS)));
                    n.setQ_id(c.getInt(c.getColumnIndex(FR_Q_ID)));
                    n.setSynced(getBoolean(c.getInt(c.getColumnIndex(FR_SYNCED))));
                    n.setCreated_on(getDateTime(c.getString(c.getColumnIndex(FR_CREATED_ON))));
                    n.setFinished_on(getDateTime(c.getString(c.getColumnIndex(FR_FINISHED_ON))));
                    n.setCompleted(getBoolean(c.getInt(c.getColumnIndex(FR_COMPLETED))));
                    n.setUser_id(c.getInt(c.getColumnIndex(FR_USER_ID)));
                    lFR.add(n);
                    c.moveToNext();
                }
            }
        }
        return lFR;
    }

    public void updateFormRecordsSyncedStatus(boolean synced, String fr_id) throws Exception {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(CREATE_TABLE_FORMRECORDS); //with if not exists
        ContentValues cv=new ContentValues();
        cv.put(FR_SYNCED, synced);
        db.update(TABLE_FORMRECORDS, cv, FR_ID + " = ?", new String[]{fr_id});
    }

    public void createFormRecords(FormRecords records) throws Exception {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(CREATE_TABLE_FORMRECORDS); //with if not exists
        ContentValues cv = new ContentValues();
        cv.put(FR_SYNCED, records.getSynced());
        cv.put(FR_F_RECORDS,records.getRecords());
        cv.put(FR_CREATED_ON, getDateTime(records.getCreated_on()));
        cv.put(FR_FINISHED_ON,getDateTime(records.getFinished_on()));
        cv.put(FR_ID,records.get_id());
        cv.put(FR_Q_ID,records.getQ_id());
        cv.put(FR_USER_ID,records.getUser_id());
        cv.put(FR_COMPLETED,records.getCompleted());
        db.insert(TABLE_FORMRECORDS, null, cv);
    }

    public void createUser(User u) throws Exception {
        SQLiteDatabase db = getWritableDatabase();

        String triggerQuery="DELETE FROM " + TABLE_USER + " WHERE " + U__ID + " = " + u.getUser_id() + "";
        db.rawQuery(triggerQuery,null);

        ContentValues values = new ContentValues();
        values.put(U_USER_NAME, u.getUsername());
        values.put(U_HASHED_PASSWORD, u.getPassword());
        values.put(U__ID,u.getUser_id());
        values.put(U_EMAIL, u.getEmail());
        values.put(U_ORGANIZATION, u.getOrganization());
        values.put(U_ROLE, u.getRole());
        values.put(U_LAST_LOGGEDIN_ON,getDateTime(u.getLast_login()));
        values.put(U_LAST_RECORDED_ON,getDateTime(u.getLast_record()));
        db.insert(TABLE_USER, null, values);
    }

    public void deleteUser() throws Exception{
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_USER, null, null);
    }

    public User getUserByID(int id) throws Exception {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_USER + " WHERE id="+ String.valueOf(id) +" LIMIT 1";
        Log.e(LOG, selectQuery);
        Cursor c = db.rawQuery(selectQuery, null);
        User u = new User();

        if (c != null && c.getCount()>0) {
            c.moveToFirst();
            u.setUser_id(c.getInt(c.getColumnIndex(U__ID)));
            u.setLast_login(getDateTime(c.getString(c.getColumnIndex(U_LAST_LOGGEDIN_ON))));
            u.setLast_record(getDateTime(c.getString(c.getColumnIndex(U_LAST_RECORDED_ON))));
            u.setPassword(c.getString(c.getColumnIndex(U_HASHED_PASSWORD)));
            u.setUsername(c.getString(c.getColumnIndex(U_USER_NAME)));
            u.setRole(c.getInt(c.getColumnIndex(U_ROLE)));
            u.setOrganization(c.getInt(c.getColumnIndex(U_ORGANIZATION)));
            u.setEmail(c.getString(c.getColumnIndex(U_EMAIL)));
        }

        return u;
    }


}
