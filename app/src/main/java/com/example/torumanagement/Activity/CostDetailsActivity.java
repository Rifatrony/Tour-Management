package com.example.torumanagement.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.torumanagement.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CostDetailsActivity extends AppCompatActivity implements View.OnClickListener{

    AppCompatImageView imageBack;
    FloatingActionButton addCostFloatingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cost_details);

        initialization();
        setListener();

        addCostFloatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CostActivity.class));
            }
        });

    }

    private void setListener() {
        addCostFloatingButton.setOnClickListener(this);
        imageBack.setOnClickListener(this);
    }

    private void initialization(){
        addCostFloatingButton = findViewById(R.id.addCostFloatingButton);
        imageBack = findViewById(R.id.imageBack);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageBack:
                onBackPressed();
                break;

            case R.id.addCostFloatingButton:
                startActivity(new Intent(getApplicationContext(), AddMoneyActivity.class));
        }
    }
}