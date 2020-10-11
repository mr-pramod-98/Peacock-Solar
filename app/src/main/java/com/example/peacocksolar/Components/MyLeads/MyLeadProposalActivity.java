package com.example.peacocksolar.Components.MyLeads;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;

import com.example.peacocksolar.R;

public class MyLeadProposalActivity extends AppCompatActivity {

    // WIDGETS
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_lead_proposal);

        // INITIALIZING VARIABLES
        toolbar = (Toolbar) findViewById(R.id.toolbar);


        /* ========================= TOOLBAR SETUP -> START ===========================*/
        // PROFILE TOOLBAR
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
        /* ========================= TOOLBAR SETUP -> END ===========================*/
    }


    // THIS METHOD IS USED TO HANDLE THE "BACK PRESS ACTION"
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}