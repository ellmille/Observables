package com.sandbox.observables.UI;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.sandbox.observables.BR;
import com.sandbox.observables.Data.DataPointContainer;
import com.sandbox.observables.R;

/**
 * Adapter for recycler view in {@link com.sandbox.observables.ListViewActivity}
 */

public class DataListViewAdapter extends RecyclerView.Adapter<DataListViewAdapter.ViewHolder> {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_data, parent, false);
        return new ViewHolder(viewDataBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ViewDataBinding viewDataBinding = holder.getDataBinding();
        viewDataBinding.setVariable(BR.dataPoint, DataPointContainer.getInstance().getDataPointList().get(position));
    }

    @Override
    public int getItemCount() {
        return (DataPointContainer.getInstance().getDataPointList() != null ? DataPointContainer.getInstance().getDataPointList().size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ViewDataBinding dataBinding;

        public ViewHolder(ViewDataBinding viewDataBinding){
            super(viewDataBinding.getRoot());
            this.dataBinding = viewDataBinding;
            this.dataBinding.executePendingBindings();
        }

        public ViewDataBinding getDataBinding(){
            return dataBinding;
        }
    }
}
