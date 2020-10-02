package com.example.peacocksolar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class ProfileActivity extends AppCompatActivity {

    // WIDGETS
    private Toolbar toolbar;
    private EditText nameEditText, emailEditText, phoneEditText;
    private TextView dobEditText;
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
        dobEditText = findViewById(R.id.date_of_birth_edit_text_profile);
        saveButton = findViewById(R.id.save_button);

        // DISABLE EMAIL FIELD SINCE "EMAIL SHOULD BE UNIQUE" AND CANNOT BE CHANGED
        emailEditText.setEnabled(false);


        dobEditText.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                // Use the current date as the default date in the picker
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(ProfileActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        String date = day + "/" + month + "/" + year;
                        dobEditText.setText(date);
                    }
                }, year, month, day);

                datePickerDialog.show();
            }
        });


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