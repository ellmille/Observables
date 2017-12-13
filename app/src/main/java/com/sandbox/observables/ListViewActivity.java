package com.sandbox.observables;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.sandbox.observables.Data.Device;
import com.sandbox.observables.UI.DeviceListViewAdapter;

import java.util.Random;

public class ListViewActivity extends AppCompatActivity {
   // private ActivityListViewBinding binding;
    private RecyclerView recyclerView;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        recyclerView = findViewById(R.id.device_list);
        DeviceListViewAdapter viewAdapter = new DeviceListViewAdapter();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(viewAdapter);

//        binding = DataBindingUtil.setContentView(this, R.layout.activity_list_view);
//        binding.setDeviceList(DeviceContainer.getInstance().getDeviceList());
    }

    public void addDevice(View view){
        new Device("Device".concat(String.valueOf(random.nextInt(100))), random.nextInt(100));
        recyclerView.getAdapter().notifyDataSetChanged();
    }
}
