package com.sandbox.observables;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.sandbox.observables.Data.DataPoint;
import com.sandbox.observables.Data.DataPointContainer;
import com.sandbox.observables.UI.MVPAdapter;

import java.util.Random;

public class MVPListActivity extends AppCompatActivity {
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_list);
        //find recycler view
        RecyclerView recyclerView = findViewById(R.id.dataList);
        //set a layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        //set the adapter
        RecyclerView.Adapter adapter = new MVPAdapter(DataPointContainer.getInstance().getDataPointList());
        recyclerView.setAdapter(adapter);
    }

    public void addData(View view) {
        new DataPoint("name".concat(String.valueOf(random.nextInt())), Color.GREEN, String.valueOf(random.nextInt()));
    }
}
