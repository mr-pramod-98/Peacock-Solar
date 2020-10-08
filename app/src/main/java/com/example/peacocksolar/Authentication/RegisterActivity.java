package com.example.peacocksolar.Authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.peacocksolar.R;

public class RegisterActivity extends AppCompatActivity {

    // WIDGETS
    private LinearLayout signInLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ENABLE FULL-SCREEN
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.activity_register);

        // INITIALIZING VARIABLES
        signInLink = findViewById(R.id.sign_in_link);

        // HANDLING OC-CLICK ON "SIGN-IN LINK"
        signInLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ON-CLICK LAUNCH "LOGIN ACTIVITY"
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}