package com.sandbox.observables.Data;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Data for MVP activity
 */

public class DataPoint extends BaseObservable {
    private String name;
    private int color;
    private String value;

    public DataPoint(String name, int color, String value){
        this.name = name;
        this.color = color;
        this.value = value;
    }

    @Bindable
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(com.sandbox.observables.BR.name);
    }

    @Bindable
    public int getColor() {
        return color;
    }
    public void setColor(int color) {
        this.color = color;
        notifyPropertyChanged(com.sandbox.observables.BR.color);
    }

    @Bindable
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
        notifyPropertyChanged(com.sandbox.observables.BR.value);
    }
}
