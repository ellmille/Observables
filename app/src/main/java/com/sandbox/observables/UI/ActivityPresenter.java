package com.sandbox.observables.UI;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

import com.sandbox.observables.Data.DataPoint;
import com.sandbox.observables.MVPListActivity;

/**
 * Presenter
 */

public class ActivityPresenter implements ActivityContract.Presenter {
    private ActivityContract.View view;
    private Context context;

    public ActivityPresenter(ActivityContract.View view, Context context){
        this.view = view;
        this.context = context;
    }

    @Override
    public void onShowData(DataPoint dataPoint) {
        view.showData(dataPoint);
    }

    @Override
    public void showList() {
        Intent intent = new Intent(context, MVPListActivity.class);
        context.startActivity(intent);
    }
}
