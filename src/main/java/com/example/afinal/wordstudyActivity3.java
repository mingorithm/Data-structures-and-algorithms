package com.example.afinal;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class wordstudyActivity3 extends AppCompatActivity {



    private TextToSpeech tts3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wordstudy3);

        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();


        EditText editTextFilter3=(EditText) findViewById(R.id.editTextFilter3);
        Spinner spinner3=(Spinner)findViewById(R.id.spinner3);
        ListView list6;
        list6=(ListView) findViewById(R.id.list6);

        List<String> data3=new ArrayList<>();

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,data3);

        ArrayList<String> list5=new ArrayList<>();
        list5.add("600점대");
        list5.add("700점대");
        list5.add("800점대 이상");

        ArrayAdapter spinnerAdapter=new ArrayAdapter(this,R.layout.
                support_simple_spinner_dropdown_item,list5);

        spinner3.setAdapter(spinnerAdapter);
        String text2=spinner3.getSelectedItem().toString();
        spinner3.setSelection(2);

        list6.setAdapter(adapter);

        data3.add("coalesce )   합체하다, 연합하다");
        data3.add("vindicate )   비난을 풀다, 옮음을 밝히다");
        data3.add("procrastinate )   미루다, 지연되다, 연기하다");
        data3.add("consolatroy )   위문의, 위안을 주는");
        data3.add("reconcile )   화해하다, 조화시키다");
        data3.add("versatile )   여러 방면에 능한, 만능의");
        data3.add("disavow )   ~의 책임을 부정하다");
        data3.add("repent)   뉘우치다, 후회하다");
        data3.add("eligible )   적격의");
        data3.add("act as )   ~로서의 역할을 하다");
        data3.add("come by )   ~에 잠깐 들르다");
        data3.add("inauguration )   개시, 개통");
        data3.add("bear in mind )    ~을 명심하다");
        data3.add("have yet to do )   아직 ~하지 못했다");
        data3.add("foothold )    (성공의)발판, 기판");
        data3.add("calibrate )    눈금을 매기다");
        data3.add("janitorial )    (건물)관리인의");
        data3.add("liaison )    (두 집단간의)연락 담당자");
        data3.add("proceedings )    회의록, 법적 절차");
        data3.add("resurfacing )    (도로)재포장");
        data3.add("unbeatable )    타의 추종을 불허하는");
        data3.add("reassure )    안심시키다");
        data3.add("artisan )    장인, 기능 보유자");

        adapter.notifyDataSetChanged();
        list6.setTextFilterEnabled(true);

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String text=spinner3.getSelectedItem().toString();

                if(text.equals("600점대")){
                    spinner3.setSelection(0);
                    Intent intent=new Intent(getApplicationContext(), wordstudyActivity.class);
                    startActivity(intent);
                    finish();
                }else if(text.equals("700점대")){
                    spinner3.setSelection(1);
                    Intent intent=new Intent(getApplicationContext(), wordstudyActivity2.class);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




        editTextFilter3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                list6.setFilterText(editTextFilter3.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                String filterText=editable.toString();
                if(filterText.length()>0){
                    list6.setFilterText(filterText);


                }else{
                    list6.clearTextFilter();
                }
            }
        });

        tts3=new TextToSpeech(this,new TextToSpeech.OnInitListener(){

            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.SUCCESS){
                    int result=tts3.setLanguage(Locale.ENGLISH);

                    if(result==TextToSpeech.LANG_MISSING_DATA || result==TextToSpeech.LANG_NOT_SUPPORTED){
                        Toast.makeText(wordstudyActivity3.this,"이 언어는 지원하지 않습니다.",Toast.LENGTH_SHORT).show();
                    }else{
                        list6.setEnabled(true);
                    }
                }
            }
        });

        list6.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                int check_position=list6.getCheckedItemPosition();
                String vo=(String)adapterView.getAdapter().getItem(position);


                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
                    tts3.speak(vo, TextToSpeech.QUEUE_FLUSH, null, null);
                }else{
                    tts3.speak(vo,TextToSpeech.QUEUE_FLUSH,null);
                }
            }
        });
    }

    public void backbutton9(View v){
        Intent intent=new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }
}