package com.example.torumanagement.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.torumanagement.Model.AddCostModel;
import com.example.torumanagement.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CostActivity extends AppCompatActivity implements View.OnClickListener {
    AppCompatImageView imageBack;
    AppCompatButton addCostBtn;

    DatabaseReference dbCost;
    String uid, reason, date, amount;

    EditText costDateEditText,reasonEditText,costAmountEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cost);

        initialization();
        setListener();

        dbCost = FirebaseDatabase.getInstance().getReference("User").child("Cost Details");

    }

    private void initialization() {
        imageBack = findViewById(R.id.imageBack);
        addCostBtn = findViewById(R.id.addCostBtn);

        costDateEditText = findViewById(R.id.costDate);
        reasonEditText = findViewById(R.id.reason);
        costAmountEditText = findViewById(R.id.costAmount);
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
                addCost();
                finish();
                break;

        }
    }

    private void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void addCost() {

        uid = dbCost.push().getKey();

        reason = reasonEditText.getText().toString().trim();
        date = costDateEditText.getText().toString().trim();
        amount = costAmountEditText.getText().toString().trim();

        AddCostModel data = new AddCostModel(reason, date, amount, uid);

        dbCost.child(uid).setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                showToast("Cost Added");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                showToast(e.getMessage());
            }
        });
    }
}