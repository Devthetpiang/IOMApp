package com.xavey.proto;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.xavey.proto.api.SampleClient;
import com.xavey.proto.api.model.Auth;
import com.xavey.proto.api.model.User;
import com.xavey.proto.helper.DBHelper;
import com.xavey.proto.helper.SessionManager;

import java.util.Date;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by tinmaungaye on 3/31/2016.
 */
public class LoginActivity extends Activity {

    private String DadTest1 ;
    private String GeneTest2;
    private String GeneTest3;


    private Button btnLogin;
    private Button btnLinkToRegister;
    private EditText inputEmail;
    private EditText inputPassword;
    private ProgressDialog pDialog;
    private SessionManager session;
    private DBHelper db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        // SQLite database handler
        db = new DBHelper(getApplicationContext());

        // Session manager
        session = new SessionManager(getApplicationContext());

        // Check if user is already logged in or not
        if (session.isLoggedIn()) {
            // User is already logged in. Take him to main activity
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        // Login button Click Event
        btnLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                String user_name = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();
                String android_id = Settings.Secure.getString(getContentResolver(),
                        Settings.Secure.ANDROID_ID);
                // Check for empty data in the form
                if (!user_name.isEmpty() && !password.isEmpty()) {
                    // login user
                    checkLogin(user_name, password, android_id);
                } else {
                    // Prompt user to enter credentials
                    Toast.makeText(getApplicationContext(),
                            "Please enter the credentials!", Toast.LENGTH_LONG)
                            .show();
                }
            }

        });
    }

    /**
     * function to verify login details in mysql db
     * */
    private void checkLogin(final String username, final String password, final String device) {
        // Tag used to cancel the request
        String tag_string_req = "req_login";
        Auth auth = new Auth();
        auth.setUsername(username);
        auth.setPassword(password);
        auth.setDevice(device);
        pDialog.setMessage("Logging in ...");
        showDialog();

        SampleClient.getWoodyApiClient(this).postAuthToken(auth, new Callback<User>() {

            @Override
            public void success(User user, Response response) {

                try {
                    if (response.getStatus() == 200 && user != null) {
                        Date d = new Date();
                        user.setLast_record(d);
                        user.setLast_login(d);
                        db.createUser(user);
                        session.setLogin(true);
                        session.setToken(user.getToken());
                        session.setLoginUser(user.getUser_id(),user.getUsername());
                        Intent intent = new Intent();
                        intent.setClass(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    } else if (response.getStatus() == 401 || response.getStatus() == 403) {
                        Toast.makeText(getApplicationContext(),
                                "Invalid access", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "Please try again", Toast.LENGTH_LONG).show();

                    }
                    hideDialog();
                } catch (Exception e) {
                    Log.d("AuthAPI", e.getStackTrace().toString());
                    Toast.makeText(getApplicationContext(),
                            e.getMessage(), Toast.LENGTH_LONG).show();
                    hideDialog();
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
                hideDialog();
            }
        });

    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}

