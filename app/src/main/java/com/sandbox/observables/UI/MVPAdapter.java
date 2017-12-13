package com.sandbox.observables.UI;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.sandbox.observables.Data.DataPoint;
import com.sandbox.observables.R;

import java.util.List;

/**
 * Adapter for List
 */

public class MVPAdapter extends RecyclerView.Adapter<MVPAdapter.MVPViewHolder> {
    private List<DataPoint> dataPointList;

    public MVPAdapter(List<DataPoint> dataPointList){
        this.dataPointList = dataPointList;
    }

    @Override
    public MVPViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_mvp, parent, false);
        return new MVPViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(MVPAdapter.MVPViewHolder holder, int position) {
        final DataPoint dataPoint = dataPointList.get(position);
        holder.bind(dataPoint);
    }

    @Override
    public int getItemCount() {
        return dataPointList.size();
    }

    public class MVPViewHolder extends RecyclerView.ViewHolder {
        private final ViewDataBinding binding;

        public MVPViewHolder(final ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(DataPoint dataPoint){
            binding.setVariable(com.sandbox.observables.BR.dataPoint, dataPoint);
            binding.executePendingBindings();
        }
    }
}
