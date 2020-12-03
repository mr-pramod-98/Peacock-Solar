package com.example.peacocksolar.Components.LearnMore;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.peacocksolar.R;

public class LearnMoreFragment extends Fragment {

    // WIDGET
    private ListView listView;

    // VARIABLES
    private ListViewAdapter listViewAdapter;

    // CONSTANTS
    private static final String[] listItems = {"Why Solar", "Parts of Solar", "Benefits of Solar", "About Peacock Solar"};

    public LearnMoreFragment() {    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_learn_more, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // INITIALIZING VARIABLES
        listView = view.findViewById(R.id.list_view);
        listViewAdapter = new ListViewAdapter(listItems);

        // SET ADAPTER FOR CUSTOM LIST-VIEW
        listView.setAdapter(listViewAdapter);

        // HANDLING ON-CLICK ON "LIST-VIEW ITEMS"
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getContext(), adapterView.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    // CUSTOM LIST-VIEW ADAPTER CLASS
    class ListViewAdapter extends BaseAdapter {
        private String[] listItems;

        public ListViewAdapter(String[] listItems) {
            this.listItems = listItems;
        }

        @Override
        public int getCount() {
            return listItems.length;
        }

        @Override
        public Object getItem(int i) {
            return listItems[i];
        }

        @Override
        public long getItemId(int i) {
            return (long) i;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            // INFLATE THE CUSTOM LIST-VIEW LAYOUT
            convertView = getLayoutInflater().inflate(R.layout.listview_layout_style, parent, false);

            // SET TEXT
            TextView listItemText = convertView.findViewById(R.id.list_item_text);
            listItemText.setText(listItems[position]);

            return convertView;
        }
    }
}