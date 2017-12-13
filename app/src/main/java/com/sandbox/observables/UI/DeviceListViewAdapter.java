package com.sandbox.observables.UI;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.sandbox.observables.Data.DeviceContainer;
import com.sandbox.observables.R;

/**
 * Adapter for recycler view
 */

public class DeviceListViewAdapter extends RecyclerView.Adapter<DeviceListViewAdapter.ViewHolder> {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_device, parent, false);
        return new ViewHolder(viewDataBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ViewDataBinding viewDataBinding = holder.getDataBinding();
        viewDataBinding.setVariable(com.sandbox.observables.BR.device, DeviceContainer.getInstance().getDeviceList().get(position));
    }

    @Override
    public int getItemCount() {
        return (DeviceContainer.getInstance().getDeviceList() != null ? DeviceContainer.getInstance().getDeviceList().size() : 0);
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
