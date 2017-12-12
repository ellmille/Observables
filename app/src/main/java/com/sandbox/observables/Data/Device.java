package com.sandbox.observables.Data;

/**
 * Device object
 */

public class Device {
    private String name;
    private int id;

    public Device(String name, int id){
        this.name = name;
        this.id = id;
        DeviceContainer.getInstance().addToDeviceList(this);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
