package com.example.peacocksolar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class ProfileActivity extends AppCompatActivity {

    // WIDGETS
    private Toolbar toolbar;
    private EditText nameEditText, emailEditText, phoneEditText;
    private Spinner genderSpinner;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        nameEditText = findViewById(R.id.name_edit_text_profile);
        emailEditText = findViewById(R.id.email_edit_text_profile);
        phoneEditText = findViewById(R.id.phone_edit_text_profile);
        genderSpinner = findViewById(R.id.gender_spinner_profile);
        saveButton = findViewById(R.id.save_button);

        // DISABLE EMAIL FIELD SINCE "EMAIL SHOULD BE UNIQUE" AND CANNOT BE CHANGED
        emailEditText.setEnabled(false);


        /* ====================== SPINNER GENDER SETUP -> START ========================*/
        // CREATE AN "ArrayAdapter" USING THE STRING ARRAY AND A DEFAULT SPINNER LAYOUT
        ArrayAdapter<CharSequence> arrayAdapterGender = ArrayAdapter.createFromResource(
                this,
                R.array.profile_spinner_gender,
                R.layout.spinner_text_style
        );

        // SPECIFY THE LAYOUT TO USE WHEN THE LIST OF CHOICES APPEARS
        arrayAdapterGender.setDropDownViewResource(R.layout.spinner_drop_down_style);

        // APPLY THE ADAPTER TO THE SPINNER
        genderSpinner.setAdapter(arrayAdapterGender);

        // SET "OnItemSelectedListener" LISTENER TO THE SPINNER
        genderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // SETTING THE DEFAULT VALUE TO THE USERS GENDER
        genderSpinner.setSelection(arrayAdapterGender.getPosition("Male"));
        /* ======================= SPINNER GENDER SETUP -> END ========================*/


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
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}