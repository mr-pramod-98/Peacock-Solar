package com.example.peacocksolar.Components.MyLeads;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.peacocksolar.Components.MyLeads.RecyclerViewMyLeadsAdapter;
import com.example.peacocksolar.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MyLeadsFragment extends Fragment implements RecyclerViewMyLeadsAdapter.Listener {

    // WIDGETS
    private FloatingActionButton addLeadButton;
    private RecyclerView recyclerView;
    private ViewGroup viewGroup;

    // VAR
    private RecyclerViewMyLeadsAdapter adapter;
    private Listener listenerAddLead;
    private String phoneNumber;

    // CONSTANTS
    private final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;

    public interface Listener {
        void onClickLoadAddLeadFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_leads, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // INITIALIZING VARIABLES
        addLeadButton = view.findViewById(R.id.add_lead_button);
        recyclerView = view.findViewById(R.id.recycler_view_my_leads);
        viewGroup = view.findViewById(android.R.id.content);
        adapter = new RecyclerViewMyLeadsAdapter();

        /* ========================= RECYCLER VIEW SETUP -> START ===========================*/
        // SET ADAPTER FOR THE RECYCLER-VIEW
        recyclerView.setAdapter(adapter);

        // SET LAYOUT-MANAGER FOR THE RECYCLER-VIEW
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView.hasFixedSize();
        /* ========================= RECYCLER VIEW SETUP -> END ===========================*/

        // SETTING THE LISTENER FOR "MY LEAD ACTIONS"
        adapter.setMyLeadActionsListener(this);

        // HANDLING ON-CLICK ON "ADD-LEAD BUTTON" (i.e, FLOATING ACTION BUTTON)
        addLeadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // CALL THIS METHOD IN THE CLASS WHICH IMPLEMENTS THIS LISTENER (i.e, HERE IT IS MAIN ACTIVITY)
                listenerAddLead.onClickLoadAddLeadFragment();
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listenerAddLead = (Listener) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listenerAddLead = null;
    }


    @Override
    public void onCreateProposalClick() {

        // CREATING A DIALOG TO ASK FOR USER CONFIRMATION
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View alertLayout = LayoutInflater.from(getContext()).inflate(R.layout.alert_layout_style, viewGroup, false);

        // SET THE VIEW
        builder.setView(alertLayout);

        // SHOW THE DIALOG
        final AlertDialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();


        // TODO: TAKE ACTION WHEN "YES" IS CLICKED
        alertLayout.findViewById(R.id.button_yes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "TODO:// ACTION PENDING", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        // LAUNCH THE ACTIVITY TO CALCULATE THE CAPACITY WHEN "NO" IS CLICKED
        alertLayout.findViewById(R.id.button_no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MyLeadProposalActivity.class);
                startActivity(intent);
                dialog.dismiss();
            }
        });



    }

    @Override
    public void onMessageClick(String phoneNumber) {
        // LAUNCH "DEFAULT MESSAGING APP"
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:" + phoneNumber));
        startActivity(intent);
    }

    @Override
    public void onContactClicked(String phoneNumber) {
        // GLOBALLY ASSIGN
        this.phoneNumber = phoneNumber;

        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

            // PERMISSION NOT GRANTED
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.CALL_PHONE)) {
                // SHOW AN EXPLANATION TO THE USER.
                // AFTER THE USER SEES THE EXPLANATION, REQUEST THE PERMISSION.
                // CREATING A DIALOG TO ASK FOR USER CONFIRMATION
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Request to call");
                builder.setMessage("Require this permission to make call");

                // REQUEST AGAIN WHEN "OK" IS CLICKED
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityCompat.requestPermissions(
                                getActivity(),
                                new String[]{Manifest.permission.CALL_PHONE},
                                MY_PERMISSIONS_REQUEST_CALL_PHONE
                        );
                    }
                });

                // DISMISS THE DIALOG WHEN "DISMISS" IS CLICKED
                builder.setNegativeButton("DISMISS", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                // SHOW THE DIALOG
                AlertDialog dialog = builder.create();
                dialog.show();

            } else {
                // NO EXPLANATION NEEDED, REQUEST THE PERMISSION
                ActivityCompat.requestPermissions(
                        getActivity(),
                        new String[]{Manifest.permission.CALL_PHONE},
                        MY_PERMISSIONS_REQUEST_CALL_PHONE
                );
            }
        } else {
            // PERMISSION HAS ALREADY BEEN GRANTED, LAUNCH "PHONE DIALER"
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + this.phoneNumber));
            startActivity(intent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CALL_PHONE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // PERMISSION GRANTED, LAUNCH "PHONE DIALER"
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + this.phoneNumber));
                    startActivity(intent);

                } else {
                    // PERMISSION DENIED DISABLE THE FUNCTIONALITY THE DEPENDS ON THE PERMISSION
                    Toast.makeText(getContext(), "Cannot make call without the call permission", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}