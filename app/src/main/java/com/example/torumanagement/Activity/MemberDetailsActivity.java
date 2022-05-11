package com.example.torumanagement.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.torumanagement.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MemberDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatImageView imageBack;
    FloatingActionButton addMemberFloatingButton;
    RecyclerView memberRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);
        initialization();
        setListener();
    }

    private void initialization(){

        addMemberFloatingButton = findViewById(R.id.addMemberFloatingButton);
        memberRecyclerView = findViewById(R.id.memberRecyclerView);
        imageBack = findViewById(R.id.imageBack);

    }
    private void setListener(){
        imageBack.setOnClickListener(this);
        addMemberFloatingButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageBack:
                onBackPressed();
                break;
            case R.id.addMemberFloatingButton:
                Toast.makeText(MemberDetailsActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), AddMemberActivity.class));
                break;

        }
    }
}