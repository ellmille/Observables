package com.sandbox.observables;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sandbox.observables.Data.DataPointContainer;
import com.sandbox.observables.UI.MVPAdapter;

public class MVPListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_list);
        recyclerView = findViewById(R.id.dataList);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MVPAdapter(DataPointContainer.getInstance().getDataPointList());
        recyclerView.setAdapter(adapter);
    }
}
