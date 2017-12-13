package com.sandbox.observables.Data;

import android.databinding.ObservableArrayList;

/**
 * Holds Data Points
 */

public class DataPointContainer {
    private static final DataPointContainer instance = new DataPointContainer();
    private ObservableArrayList<DataPoint> dataPointList;

    public static DataPointContainer getInstance() {
        return instance;
    }

    private DataPointContainer() {
        dataPointList = new ObservableArrayList<>();
    }

    public void addToPointToList(DataPoint data){
        dataPointList.add(data);
        System.out.println(dataPointList.size());
    }

    public ObservableArrayList<DataPoint> getDataPointList(){
        return dataPointList;
    }
}
