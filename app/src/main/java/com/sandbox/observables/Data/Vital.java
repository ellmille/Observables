package com.sandbox.observables.Data;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Represents an object that the application wants to have observed.
 */


public class Vital extends BaseObservable {
    private String name;
    private int value;
    private int dsn;
    private int priority = 0;

    public Vital(int value, int dsn, String name){
        this.value = value;
        this.dsn = dsn;
        this.name = name;
    }
    @Bindable
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        notifyPropertyChanged(com.sandbox.observables.BR.value);
    }

    public int getDsn() {
        return dsn;
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
    public int getPriority(){
        return priority;
    }
    public void setPriority(){
        if(value > 0){
            this.priority = 1;
        }else if(value < 0){
            this.priority = 0;
        }else{
            this.priority = 2;
        }
        notifyPropertyChanged(com.sandbox.observables.BR.priority);
    }
}
