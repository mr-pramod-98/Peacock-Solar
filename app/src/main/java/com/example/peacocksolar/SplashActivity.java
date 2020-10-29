package com.example.peacocksolar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.example.peacocksolar.Authentication.LoginActivity;
import com.example.peacocksolar.SharedPreferences.SharedUserData;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ENABLE FULL-SCREEN
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onStart() {
        super.onStart();

        SharedUserData sharedUserData = new SharedUserData(getApplicationContext());

        // CHECKING IF THE USER IS LOGGED-IN OR NOT
        if(sharedUserData.getIsLoggedIn()) {
            // LAUNCH "MAIN ACTIVITY" WHEN USER IS LOGGED-IN
            // HANDLING THE DELAY
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {

                    // LAUNCH THE "lOG-IN ACTIVITY" ONCE THE TIMER IS OVER
                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }, 1500);

        } else {
            // LAUNCH "LOGIN ACTIVITY" WHEN USER IS LOGGED-OUT
            // HANDLING THE DELAY
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {

                    // LAUNCH THE "lOG-IN ACTIVITY" ONCE THE TIMER IS OVER
                    Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(i);
                    finish();
                }
            }, 1500);
        }
    }
}