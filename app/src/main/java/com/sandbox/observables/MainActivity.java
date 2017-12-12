package com.sandbox.observables;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.sandbox.observables.Data.Device;
import com.sandbox.observables.Data.DeviceContainer;
import com.sandbox.observables.databinding.ActivityMainBinding;

import java.util.Random;
//todo: https://developer.android.com/topic/libraries/data-binding/index.html

public class MainActivity extends AppCompatActivity {
    private Random random = new Random();
    private Vital vital = new Vital(14, 0, "name");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set binding
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setVital(vital);
        binding.setDevice(DeviceContainer.getInstance().getDeviceList());
    }

    public void changeValue(View view) {
        vital.setValue(random.nextInt());
        vital.setName("NAME+".concat(String.valueOf(random.nextInt())));
        vital.setPriority();
    }

    public void addDevice(View view) {
        new Device("Device".concat(String.valueOf(vital.getValue())), vital.getValue());
    }

    @BindingAdapter("bind:numberText")
    public static void setNumberText(TextView view, int number){
        view.setText(String.valueOf(number));
    }
    @BindingAdapter("bind:colorText")
    public static void setTextColor(TextView view, int number){
        view.setTextColor(getPriorityColor(number));
    }

    private static int getPriorityColor(int number){
        if(number == 0){
            return Color.GREEN;
        }else if(number == 1){
            return Color.YELLOW;
        }
        return Color.RED;
    }
}
