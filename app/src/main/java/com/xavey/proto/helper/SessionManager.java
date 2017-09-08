package com.xavey.proto.helper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import com.xavey.proto.LoginActivity;
import com.xavey.proto.api.model.json.Worker;

import java.util.Set;

/**
 * Created by tinmaungaye on 3/31/2016.
 */
public class SessionManager  {
    // LogCat tag
    private static String TAG = SessionManager.class.getSimpleName();

    // Shared Preferences
    SharedPreferences pref;

    SharedPreferences.Editor editor;
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "GCILogin";

    private static final String KEY_IS_LOGGEDIN = "isLoggedIn";
    private static final String KEY_LOGGEDIN_USER_ID = "loggedInUserId";
    private static final String KEY_LOGGEDIN_USER_NAME = "loggedInUserName";
    private static final String KEY_LOGGEDIN_TOKEN = "loggedInToken";

    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setLogin(boolean isLoggedIn) {

        editor.putBoolean(KEY_IS_LOGGEDIN, isLoggedIn);

        // commit changes
        editor.commit();

        Log.d(TAG, "User login session modified!");
    }

    public boolean isLoggedIn(){
        return pref.getBoolean(KEY_IS_LOGGEDIN, false);
    }

    public void setToken(String token) {
        editor.putString(KEY_LOGGEDIN_TOKEN, token);
        editor.commit();
    }

    public String getToken(){
        return pref.getString(KEY_LOGGEDIN_TOKEN, "");
    }

    public void setLoginUser(int id, String name) {
        editor.putInt(KEY_LOGGEDIN_USER_ID, id);
        editor.putString(KEY_LOGGEDIN_USER_NAME, name);
        // commit changes
        editor.commit();
    }

    public int getLoginUserId(){
        return pref.getInt(KEY_LOGGEDIN_USER_ID, -1);
    }
    public String getLoginUserName(){
        return pref.getString(KEY_LOGGEDIN_USER_NAME, "");
    }


}
