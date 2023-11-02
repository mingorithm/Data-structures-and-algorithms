package com.example.afinal;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();




    }

    public void loginbutton(View v){


        String uuid,uupw;
        EditText Uid=(EditText) findViewById(R.id.Uid);
        EditText Upw=(EditText) findViewById(R.id.Upw);
        uuid=Uid.getText().toString();
        uupw=Upw.getText().toString();

        if(uuid.equals("admin") && uupw.equals("12345"))
        {
            Intent intent=new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
        else{
            Intent intent=new Intent(getApplicationContext(), PWfailedActivity.class);
            startActivity(intent);
            finish();
        }


    }


}