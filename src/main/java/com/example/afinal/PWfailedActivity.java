package com.example.afinal;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PWfailedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pwfailed);

        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();


    }

    public void returnbutton(View v){
        Intent intent=new Intent(getApplicationContext(), LoginActivity2.class);
        startActivity(intent);
        finish();
    }
}