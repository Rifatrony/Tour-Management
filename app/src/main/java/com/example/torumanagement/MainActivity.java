package com.example.torumanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.torumanagement.Activity.AmountDetailsActivity;
import com.example.torumanagement.Activity.CostDetailsActivity;
import com.example.torumanagement.Activity.MemberDetailsActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CardView cardView1, cardView2, cardView3, cardView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization();
        setListener();

    }

    private void initialization(){
        cardView1 = findViewById(R.id.card1);
        cardView2 = findViewById(R.id.card2);
        cardView3 = findViewById(R.id.card3);
        cardView4 = findViewById(R.id.card4);
    }

    private void setListener(){
        cardView1.setOnClickListener(this);
        cardView2.setOnClickListener(this);
        cardView3.setOnClickListener(this);
        cardView4.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.card1:
                startActivity(new Intent(getApplicationContext(), MemberDetailsActivity.class));
                break;

            case R.id.card2:
                startActivity(new Intent(getApplicationContext(), AmountDetailsActivity.class));
                break;

            case R.id.card3:
                startActivity(new Intent(getApplicationContext(), CostDetailsActivity.class));
                break;

            case R.id.card4:
                startActivity(new Intent(getApplicationContext(), MemberDetailsActivity.class));
                break;
        }
    }
}