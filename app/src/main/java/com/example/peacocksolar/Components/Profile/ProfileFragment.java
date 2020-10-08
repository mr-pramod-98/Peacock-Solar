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

import com.example.peacocksolar.R;

public class ProfileFragment extends Fragment {

    // WIDGETS
    CardView profileEditButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // INITIALIZING VARIABLES
        profileEditButton = view.findViewById(R.id.profile_edit_button);

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
}