package com.example.torumanagement.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.torumanagement.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AmountDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatImageView imageBack;
    FloatingActionButton addMoneyFloatingButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amount_details);

        initialization();
        setListener();

    }

    private void initialization(){

        addMoneyFloatingButton = findViewById(R.id.addMoneyFloatingButton);
        imageBack = findViewById(R.id.imageBack);
    }

    private void setListener(){
        imageBack.setOnClickListener(this);
        addMoneyFloatingButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageBack:
                onBackPressed();
                break;

            case R.id.addMoneyFloatingButton:
                startActivity(new Intent(getApplicationContext(), AddMoneyActivity.class));
        }
    }
}