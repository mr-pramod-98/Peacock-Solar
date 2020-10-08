package com.example.peacocksolar.Components.MyLeads;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.peacocksolar.Components.MyLeads.RecyclerViewMyLeadsAdapter;
import com.example.peacocksolar.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MyLeadsFragment extends Fragment {

    // WIDGETS
    FloatingActionButton addLeadButton;
    private RecyclerView recyclerView;

    // VAR
    private RecyclerViewMyLeadsAdapter adapter;

    private Listener listenerAddLead;

    public interface Listener {
        void onClickLoadAddLeadFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_leads, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        addLeadButton = view.findViewById(R.id.add_lead_button);
        recyclerView = view.findViewById(R.id.recycler_view_my_leads);
        adapter = new RecyclerViewMyLeadsAdapter();

        // SET ADAPTER FOR THE RECYCLER-VIEW
        recyclerView.setAdapter(adapter);
        // SET LAYOUT-MANAGER FOR THE RECYCLER-VIEW
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView.hasFixedSize();

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