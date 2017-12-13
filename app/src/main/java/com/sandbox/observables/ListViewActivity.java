package com.sandbox.observables;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.sandbox.observables.Data.DataPoint;
import com.sandbox.observables.UI.DataListViewAdapter;

import java.util.Random;

/**
 * Simple example of databinding and observable array list
 */

public class ListViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        recyclerView = findViewById(R.id.device_list);
        DataListViewAdapter viewAdapter = new DataListViewAdapter();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(viewAdapter);
    }

    public void addDevice(View view){
        new DataPoint("name".concat(String.valueOf(random.nextInt())), Color.GREEN, String.valueOf(random.nextInt()));
        recyclerView.getAdapter().notifyDataSetChanged();
    }
}
