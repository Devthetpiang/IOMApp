package com.xavey.proto;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.xavey.proto.helper.SessionManager;

/**
 * Created by tinmaungaye on 3/31/2016.
 */
public class BaseActivity extends AppCompatActivity {

    private SessionManager session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        session = new SessionManager(this);
        if(!session.isLoggedIn()) {
            finish();
            Intent intent = new Intent();
            intent.setClass(this, LoginActivity.class);
            startActivity(intent);
        }
    }
}
