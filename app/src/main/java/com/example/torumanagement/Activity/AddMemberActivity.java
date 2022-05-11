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

import com.example.torumanagement.Model.AddMemberModel;
import com.example.torumanagement.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddMemberActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatButton saveMemberBtn;
    AppCompatImageView imageBack;

    DatabaseReference addMember;
    String uid;

    EditText memberNameEditText,memberNumberEditText,firstAmountEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);

        initialization();
        setListener();

        addMember = FirebaseDatabase.getInstance().getReference("User").child("Add Member");

    }

    private void initialization(){
        saveMemberBtn = findViewById(R.id.saveMemberBtn);
        imageBack = findViewById(R.id.imageBack);
        memberNameEditText = findViewById(R.id.memberName);
        memberNumberEditText = findViewById(R.id.memberNumber);
        firstAmountEditText = findViewById(R.id.firstAmount);
    }

    private  void setListener(){
        saveMemberBtn.setOnClickListener(this);
        imageBack.setOnClickListener(this);
    }
    private void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageBack:
                onBackPressed();
                break;
            case R.id.saveMemberBtn:
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
                insertMember();
                break;
        }
    }

    private void insertMember() {

        uid = addMember.push().getKey();

        String name = memberNameEditText.getText().toString().trim();
        String number = memberNumberEditText.getText().toString().trim();
        String amount = firstAmountEditText.getText().toString().trim();

        AddMemberModel data = new AddMemberModel(name, number, amount, uid);

        addMember.child(uid).setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                showToast("Member Added Successfully");

                memberNameEditText.setText("");
                memberNumberEditText.setText("");
                firstAmountEditText.setText("");

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                showToast(e.getMessage());
            }
        });

    }
}