package com.example.peacocksolar.Authentication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.peacocksolar.Components.MyLeads.Models.LeadsData;
import com.example.peacocksolar.Components.MyLeads.MyLeadsFragment;
import com.example.peacocksolar.Components.MyLeads.RecyclerViewMyLeadsAdapter;
import com.example.peacocksolar.Components.Profile.Models.UserDate;
import com.example.peacocksolar.MainActivity;
import com.example.peacocksolar.R;
import com.example.peacocksolar.SharedPreferences.SharedUserData;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    // WIDGETS
    private LinearLayout signUpLink;
    private Button signInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ENABLE FULL-SCREEN
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.activity_login);

        // INITIALIZING VARIABLES
        signUpLink = findViewById(R.id.sign_up_link);
        signInButton = findViewById(R.id.sign_in_button);

        // HANDLING OC-CLICK ON "SIGN-UP LINK"
        signUpLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // ON-CLICK LAUNCH "REGISTER ACTIVITY"
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        // HANDLING OC-CLICK ON "SIGN-IN BUTTON"
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // TODO: AUTHENTICATE USER
                // GET USER-DATA
                getUserData();
            }
        });
    }

    // THIS METHOD IS USED TO GET THE USER-DATA
    private void getUserData() {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://3.6.93.71:8000/agents/1";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        UserDate[] userDate = new Gson().fromJson(response, UserDate[].class);
                        SharedUserData sharedUserData = new SharedUserData(getApplicationContext());

                        sharedUserData.setUserID(userDate[0].getId());
                        sharedUserData.setName(userDate[0].getName());
                        sharedUserData.setEmail(userDate[0].getEmail());
                        sharedUserData.setPhoneNumber(userDate[0].getPhoneNumber());
                        sharedUserData.setGender(userDate[0].getGender().equals("1")? "Male": "Female");
                        sharedUserData.setDateOfBirth(userDate[0].getDateOfBirth());
                        sharedUserData.setIsLoggedIn(true);

                        // AFTER SETTING USER-DATA LAUNCH "MAIN ACTIVITY"
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LoginActivity.this, "error:" + error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}