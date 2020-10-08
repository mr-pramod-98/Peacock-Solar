package com.example.peacocksolar.Components.MyLeads;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.peacocksolar.R;


public class RecyclerViewMyLeadsAdapter extends RecyclerView.Adapter<RecyclerViewMyLeadsAdapter.ViewHolder> {

    private Listener listener;

    public interface Listener {
        void onCreateProposalClick();
        void onMessageClick(String phoneNumber);
        void onContactClicked(String phoneNumber);
    }

    public void setMyLeadActionsListener(Listener listener) {
        this.listener = listener;
    }


    public RecyclerViewMyLeadsAdapter() { }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_my_leads_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.call_lead_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener != null){
                    listener.onContactClicked("9343280082");
                }
            }
        });

        holder.message_lead_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener != null){
                    listener.onMessageClick("9343280082");
                }
            }
        });

        holder.create_proposal_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener != null){
                    listener.onCreateProposalClick();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

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
