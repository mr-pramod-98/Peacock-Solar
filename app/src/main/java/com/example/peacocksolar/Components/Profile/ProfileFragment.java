package com.example.peacocksolar.Components.Profile;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.peacocksolar.Authentication.LoginActivity;
import com.example.peacocksolar.R;
import com.example.peacocksolar.SharedPreferences.SharedUserData;

public class ProfileFragment extends Fragment {

    // WIDGETS
    private TextView user_name, user_email, user_phone_number, user_gender, user_dob;
    private CardView profileEditButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // INITIALIZING VARIABLES
        profileEditButton = view.findViewById(R.id.profile_edit_button);
        user_name = view.findViewById(R.id.user_name);
        user_email = view.findViewById(R.id.user_email);
        user_phone_number = view.findViewById(R.id.user_phone_number);
        user_gender = view.findViewById(R.id.user_gender);
        user_dob = view.findViewById(R.id.user_dob);

        // SETTING USER-DATE
        setUserData();

        // HANDLING OC-CLICK ON "PROFILE EDIT BUTTON"
        profileEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // ON-CLICK LAUNCH "EDIT-PROFILE ACTIVITY"
                Intent intent = new Intent(getActivity(), EditProfileActivity.class);
                startActivity(intent);
            }
        });
    }

    // THIS METHOD IS USED TO SET USER-DATA
    private void setUserData() {
        SharedUserData sharedUserData = new SharedUserData(getContext());
        user_name.setText(sharedUserData.getName());
        user_email.setText(sharedUserData.getEmail());
        user_phone_number.setText(sharedUserData.getPhoneNumber());
        user_gender.setText(sharedUserData.getGender());
        user_dob.setText(sharedUserData.getDateOfBirth().substring(0, 10));
    }
}