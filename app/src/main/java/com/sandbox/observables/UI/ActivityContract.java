package com.sandbox.observables.UI;

import com.sandbox.observables.Data.DataPoint;

/**
 * Contract between the view and the presenter
 * Creates Presenter and View interfaces
 */

public interface ActivityContract {
    public interface Presenter{
        void onShowData(DataPoint dataPoint);
        void showList();
    }
    public interface View{
        void showData(DataPoint dataPoint);
    }
}
