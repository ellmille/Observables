package com.sandbox.observables;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.sandbox.observables.Data.DataPoint;
import com.sandbox.observables.UI.ActivityContract;
import com.sandbox.observables.UI.ActivityPresenter;
import com.sandbox.observables.databinding.ActivityMvpBinding;

public class MvpActivity extends AppCompatActivity implements ActivityContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMvpBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_mvp);
        //call presenter
        ActivityPresenter activityPresenter = new ActivityPresenter(this, getApplicationContext());
        DataPoint dataPoint = new DataPoint("NAME", Color.DKGRAY, "VALUE");
        binding.setData(dataPoint);
        binding.setPresenter(activityPresenter);
    }

    @Override
    public void showData(DataPoint dataPoint) {
        Toast.makeText(getApplicationContext(), dataPoint.getName(), Toast.LENGTH_LONG).show();
    }
}
