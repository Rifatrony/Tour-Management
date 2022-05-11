package com.example.torumanagement.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.torumanagement.Adapter.CostDetailsAdapter;
import com.example.torumanagement.Model.AddCostModel;
import com.example.torumanagement.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CostDetailsActivity extends AppCompatActivity implements View.OnClickListener{

    AppCompatImageView imageBack;
    FloatingActionButton addCostFloatingButton;
    RecyclerView costDetailsRecyclerView;

    CostDetailsAdapter adapter;
    ArrayList<AddCostModel> costModelList = new ArrayList<>();

    DatabaseReference dbCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cost_details);

        initialization();
        setListener();



        dbCost = FirebaseDatabase.getInstance().getReference("User").child("Cost Details");

        costDetailsRecyclerView.setHasFixedSize(true);
        costDetailsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new CostDetailsAdapter(this,costModelList);
        costDetailsRecyclerView.setAdapter(adapter);
        dbCost.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot data : snapshot.getChildren()){
                    AddCostModel obj = data.getValue(AddCostModel.class);
                    costModelList.add(obj);
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        //fetchData();

    }

    private void setListener() {
        addCostFloatingButton.setOnClickListener(this);
        imageBack.setOnClickListener(this);
    }

    private void initialization(){
        addCostFloatingButton = findViewById(R.id.addCostFloatingButton);
        imageBack = findViewById(R.id.imageBack);
        costDetailsRecyclerView = findViewById(R.id.costDetailsRecyclerView);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageBack:
                onBackPressed();
                break;

            case R.id.addCostFloatingButton:
                startActivity(new Intent(getApplicationContext(),CostActivity.class));
        }
    }

    private void fetchData(){



    }
}