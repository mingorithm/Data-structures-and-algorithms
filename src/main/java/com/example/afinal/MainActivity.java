package com.example.afinal;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
    }

    public void exitbutton(View v){
        System.exit(0);
    }


    public void studybutton(View v){

        Intent intent=new Intent(getApplicationContext(), wordstudyActivity.class);
        startActivity(intent);
        finish();
    }

    public void quizbtn(View v){
        Intent intent=new Intent(getApplicationContext(), QuizActivity.class);
        startActivity(intent);
        finish();
    }
}