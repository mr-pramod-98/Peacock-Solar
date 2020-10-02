package com.example.peacocksolar.Components;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.peacocksolar.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeFragment extends Fragment {

    // WIDGETS
    FloatingActionButton addLeadButton;

    private Listener listenerAddLead;

    public interface Listener {
        void onClickLoadAddLeadFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        addLeadButton = view.findViewById(R.id.add_lead_button);

        addLeadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
}