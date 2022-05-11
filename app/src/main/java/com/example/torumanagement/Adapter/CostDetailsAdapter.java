package com.example.torumanagement.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.torumanagement.Model.AddCostModel;
import com.example.torumanagement.R;

import java.util.List;

public class CostDetailsAdapter extends RecyclerView.Adapter<CostDetailsAdapter.CostViewHolder> {

    Context context;
    List<AddCostModel> costModelList;

    public CostDetailsAdapter(Context context, List<AddCostModel> costModelList) {
        this.context = context;
        this.costModelList = costModelList;
    }

    @NonNull
    @Override
    public CostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cost_sample_layout, parent , false);
        return new CostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CostViewHolder holder, int position) {
        AddCostModel data = costModelList.get(position);
        holder.reason.setText(data.getReason());
        holder.date.setText(data.getDate());
        holder.amount.setText(data.getAmount());
    }

    @Override
    public int getItemCount() {
        return costModelList.size();
    }

    public class CostViewHolder extends RecyclerView.ViewHolder {

        TextView reason, date, amount;

        public CostViewHolder(@NonNull View itemView) {
            super(itemView);

            reason= itemView.findViewById(R.id.costReasonText);
            date= itemView.findViewById(R.id.costDateText);
            amount= itemView.findViewById(R.id.costAmountText);

        }
    }

}
