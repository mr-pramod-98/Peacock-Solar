package com.example.peacocksolar.Components.Home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.peacocksolar.R;


public class RecyclerViewLeadsAdapter extends RecyclerView.Adapter<RecyclerViewLeadsAdapter.ViewHolder> {


    public RecyclerViewLeadsAdapter() {
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_leads_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView lead_name;
        TextView lead_address;
        Button call_lead_button;
        Button message_lead_button;
        Button create_proposal_button;

        private ViewHolder(@NonNull View itemView) {
            super(itemView);
            lead_name = itemView.findViewById(R.id.lead_name);
            lead_address = itemView.findViewById(R.id.lead_address);
            call_lead_button = itemView.findViewById(R.id.call_button);
            message_lead_button = itemView.findViewById(R.id.message_button);
            create_proposal_button = itemView.findViewById(R.id.create_proposal_button);
        }
    }
}
