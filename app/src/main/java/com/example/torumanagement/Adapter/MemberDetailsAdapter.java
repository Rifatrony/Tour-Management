package com.example.torumanagement.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.torumanagement.Model.AddMemberModel;
import com.example.torumanagement.R;

import java.util.List;

public class MemberDetailsAdapter extends RecyclerView.Adapter<MemberDetailsAdapter.MemberViewHolder> {

    Context context;
    List<AddMemberModel> memberModelList;

    public MemberDetailsAdapter(Context context, List<AddMemberModel> memberModelList) {
        this.context = context;
        this.memberModelList = memberModelList;
    }

    @NonNull
    @Override
    public MemberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.member_sample_layout, parent, false);
        return new MemberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MemberViewHolder holder, int position) {
        AddMemberModel data = memberModelList.get(position);
        holder.name.setText(data.getName());
        holder.number.setText(data.getPhone_number());
        holder.amount.setText(data.getAmount());

    }

    @Override
    public int getItemCount() {
        return memberModelList.size();
    }

    public class MemberViewHolder extends RecyclerView.ViewHolder {

        TextView name, number, amount;

        public MemberViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.memberNameText);
            number = itemView.findViewById(R.id.memberNumberText);
            amount = itemView.findViewById(R.id.memberGivenAmountText);

        }
    }

}
