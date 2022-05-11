package com.example.torumanagement.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.torumanagement.R;

public class CostActivity extends AppCompatActivity implements View.OnClickListener {
    AppCompatImageView imageBack;
    AppCompatButton addCostBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cost);

        initialization();
        setListener();

    }

    private void initialization() {
        imageBack = findViewById(R.id.imageBack);
        addCostBtn = findViewById(R.id.addCostBtn);
    }

    private void setListener(){
        imageBack.setOnClickListener(this);
        addCostBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageBack:
                onBackPressed();
                break;
            case R.id.addCostBtn:
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
                finish();
                break;

        }
    }
}