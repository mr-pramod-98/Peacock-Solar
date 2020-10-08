package com.example.peacocksolar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.example.peacocksolar.Authentication.LoginActivity;
import com.example.peacocksolar.Authentication.RegisterActivity;

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