package com.example.peacocksolar.Components.LearnMore;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.peacocksolar.R;

public class LearnMoreFragment extends Fragment {

    // WIDGET
    private ListView listView;

    // VARIABLES
    private ArrayAdapter<String> listItemsAdapter;

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
        listItemsAdapter = new ArrayAdapter<String>(
                getContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                listItems);

        listView.setAdapter(listItemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getContext(), adapterView.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}