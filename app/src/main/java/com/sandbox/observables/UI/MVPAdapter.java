package com.sandbox.observables.UI;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableList;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sandbox.observables.Data.DataPoint;
import com.sandbox.observables.R;

/**
 * Adapter for List
 */

public class MVPAdapter extends RecyclerView.Adapter<MVPAdapter.MVPViewHolder> {
    private ObservableList<DataPoint> dataPointList;

    public MVPAdapter(ObservableList<DataPoint> dataPoints){
        this.dataPointList = dataPoints;
        dataPointList.addOnListChangedCallback(new ObservableList.OnListChangedCallback<ObservableList<DataPoint>>() {
            @Override
            public void onChanged(ObservableList<DataPoint> dataPoints) {
                notifyDataSetChanged();
            }

            @Override
            public void onItemRangeChanged(ObservableList<DataPoint> dataPoints, int i, int i1) {
                notifyItemRangeChanged(i, i1);
            }

            @Override
            public void onItemRangeInserted(ObservableList<DataPoint> dataPoints, int i, int i1) {
                notifyItemRangeInserted(i, i1);
            }

            @Override
            public void onItemRangeMoved(ObservableList<DataPoint> dataPoints, int i, int i1, int i2) {
                notifyDataSetChanged();
            }

            @Override
            public void onItemRangeRemoved(ObservableList<DataPoint> dataPoints, int i, int i1) {
                notifyItemRangeRemoved(i, i1);
            }
        });
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
            binding.getRoot().setOnClickListener(clickListener);
            this.binding = binding;
        }

        public void bind(DataPoint dataPoint){
            binding.setVariable(com.sandbox.observables.BR.dataPoint, dataPoint);
            binding.executePendingBindings();
        }

        private View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getAdapterPosition();
                Toast.makeText(binding.getRoot().getContext(), dataPointList.get(position).getName(), Toast.LENGTH_LONG).show();
            }
        };
    }
}
