package com.example.peacocksolar.Components;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;

import com.example.peacocksolar.R;

public class AddLeadActivity extends AppCompatActivity {

    // WIDGETS
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lead);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        // ADD LEAD TOOLBAR
        setSupportActionBar(toolbar);

        // ENABLING "BACK-ARROW" IN THE TOOLBAR
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // HANDLING CLICK ON THE "BACK-ARROW"
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}