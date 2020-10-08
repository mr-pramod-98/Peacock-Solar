package com.example.peacocksolar.Authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.peacocksolar.MainActivity;
import com.example.peacocksolar.R;

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

                // ON-CLICK LAUNCH "MAIN ACTIVITY"
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}