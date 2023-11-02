package com.example.afinal;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class QuizActivity2 extends AppCompatActivity {


    private TextToSpeech textToSpeech2;
    private TextView tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);

        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();

        String msg="정답입니다!!";
        Button btn1=(Button) findViewById(R.id.option5);
        Button btn2=(Button) findViewById(R.id.option6);
        Button btn3=(Button) findViewById(R.id.option7);
        Button btn4=(Button) findViewById(R.id.option8);
        Button btn5=(Button) findViewById(R.id.nextbutton6);
        TextView textView11=findViewById(R.id.timer2);
        tv2=findViewById(R.id.question2);

        CountDownTimer countDownTimer=new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long milliUntilFinished) {
                int num=(int) (milliUntilFinished/1000);
                textView11.setText("남은 시간:"+Integer.toString(num+1)+"초");
            }

            @Override
            public void onFinish() {
                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(getApplicationContext(),"시간안에 문제를 풀지 못했습니다.",Toast.LENGTH_SHORT).show();
            }
        }.start();

        textToSpeech2=new TextToSpeech(this,new TextToSpeech.OnInitListener(){

            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.SUCCESS){
                    int result=textToSpeech2.setLanguage(Locale.ENGLISH);

                    if(result==TextToSpeech.LANG_MISSING_DATA || result==TextToSpeech.LANG_NOT_SUPPORTED){
                        Toast.makeText(QuizActivity2.this,"이 언어는 지원하지 않습니다.",Toast.LENGTH_SHORT).show();
                    }else{
                        tv2.setEnabled(true);
                    }
                }
            }
        });



        btn1.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btn1.setBackgroundColor(Color.parseColor("#CCE1FF"));
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btn1.setBackgroundColor(Color.parseColor("#64CD3C"));
                    Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
                    btn5.setEnabled(true);
                    countDownTimer.cancel();
                }
                return false;
            }


        });

        btn2.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btn2.setBackgroundColor(Color.parseColor("#CCE1FF"));
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btn2.setBackgroundColor(Color.parseColor("#FF3232"));
                }
                return false;
            }


        });

        btn4.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btn4.setBackgroundColor(Color.parseColor("#CCE1FF"));
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btn4.setBackgroundColor(Color.parseColor("#FF3232"));
                }
                return false;
            }


        });

        btn3.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btn3.setBackgroundColor(Color.parseColor("#CCE1FF"));
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btn3.setBackgroundColor(Color.parseColor("#FF3232"));
                }
                return false;
            }


        });

    }

    public void quest2(View v){
        String text=tv2.getText().toString();
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
            textToSpeech2.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
        }else{
            textToSpeech2.speak(text,TextToSpeech.QUEUE_FLUSH,null);
        }
    }

    public void backbutton3(View v){
        Intent intent=new Intent(getApplicationContext(), QuizActivity.class);
        startActivity(intent);
        finish();
    }

    public void nextbutton3(View v){
        Intent intent=new Intent(getApplicationContext(), QuizAcitivity3.class);
        startActivity(intent);
        finish();

    }
}