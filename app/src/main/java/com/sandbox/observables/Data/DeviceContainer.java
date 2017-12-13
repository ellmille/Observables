package com.sandbox.observables.Data;

import android.databinding.ObservableArrayList;

/**
 * Contains observable list of devices
 */

public class DeviceContainer {
    private static final DeviceContainer instance = new DeviceContainer();
    private ObservableArrayList<Device> deviceList;

    public static DeviceContainer getInstance() {
        return instance;
    }

    private DeviceContainer() {
        deviceList = new ObservableArrayList<>();
    }

    public void addToDeviceList(Device device){
        deviceList.add(device);
        System.out.println(deviceList.size());
    }

    public ObservableArrayList<Device> getDeviceList(){
        return deviceList;
    }
}
