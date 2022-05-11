package com.example.torumanagement.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.torumanagement.R;

public class AddMoneyActivity extends AppCompatActivity implements View.OnClickListener {

    Spinner nameSpinner;
    EditText addAmount;
    AppCompatButton saveMoneyBtn;
    AppCompatImageView imageBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_money);

        initialization();
        setListener();

    }

    private void initialization(){
        nameSpinner = findViewById(R.id.nameSpinner);
        addAmount = findViewById(R.id.addAmount);
        saveMoneyBtn = findViewById(R.id.saveMoneyBtn);
        imageBack = findViewById(R.id.imageBack);
    }

    private void setListener(){
        imageBack.setOnClickListener(this);
        saveMoneyBtn.setOnClickListener(this);
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
            case R.id.saveMoneyBtn:
                finish();
                showToast("Saved");
                break;
        }
    }
}