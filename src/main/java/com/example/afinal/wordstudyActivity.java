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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class wordstudyActivity extends AppCompatActivity {

    private TextToSpeech tts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wordstudy);

        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();

        ListView list;
        Spinner spinner=(Spinner)findViewById(R.id.spinner1);
        EditText editTextFilter1=(EditText) findViewById(R.id.editTextFilter1);


        list=(ListView) findViewById(R.id.list);

        ArrayList<String> list2=new ArrayList<>();
        list2.add("600점대");
        list2.add("700점대");
        list2.add("800점대 이상");

        ArrayAdapter spinnerAdapter=new ArrayAdapter(this,R.layout.
                support_simple_spinner_dropdown_item,list2);
        spinner.setAdapter(spinnerAdapter);




        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String text=spinner.getSelectedItem().toString();

                if(text.equals("700점대")){
                    spinner.setSelection(1);
                    Intent intent=new Intent(getApplicationContext(), wordstudyActivity2.class);
                    startActivity(intent);
                    finish();
                }else if(text.equals("800점대 이상")){
                    spinner.setSelection(2);
                    Intent intent=new Intent(getApplicationContext(), wordstudyActivity3.class);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        List<String> data=new ArrayList<>();

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,data);

        list.setAdapter(adapter);

        data.add("capacity )   용량, 수용력, 역할");
        data.add("assemble )   조립하다, (사람을) 모으다");
        data.add("utilize )   이용하다, 활용하다");
        data.add("precaution )   예방책");
        data.add("operate )   작동하다, 움직이다");
        data.add("fill )   채우다, 이행하다");
        data.add("hug )   (사람을)껴안다");
        data.add("carve )   조각하다");
        data.add("overdo )   지나치게 하다, 과장하다");
        data.add("ignorance )   무지, 무식");
        data.add("plate)   접시, 그릇");
        data.add("exchange )   교환, 주고받음, 맞바꿈");
        data.add("large-scale )    대규모의, 광범한");
        data.add("picture )   그림");
        data.add("challenging )    도전적인, 도전 의식을 북돋우는");
        data.add("dark )    어두운, 캄캄한");
        data.add("inhibit )    억제하다");
        data.add("artery )    동맥");
        data.add("connoisseur )    (예술품,음식,음악의) 감정가");
        data.add("oily )    기름기가 함유된, 기름기가 덮인");
        data.add("bespeak )    보여주다 ,시사하다");
        data.add("dive )    뛰어들다, 다이빙하다");
        data.add("control )    지배");


        adapter.notifyDataSetChanged();
        list.setTextFilterEnabled(true);

        editTextFilter1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                list.setFilterText(editTextFilter1.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                String filterText=editable.toString();
                if(filterText.length()>0){
                    list.setFilterText(filterText);


                }else{
                    list.clearTextFilter();
                }
            }
        });

        tts=new TextToSpeech(this,new TextToSpeech.OnInitListener(){

            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.SUCCESS){
                    int result=tts.setLanguage(Locale.ENGLISH);

                    if(result==TextToSpeech.LANG_MISSING_DATA || result==TextToSpeech.LANG_NOT_SUPPORTED){
                        Toast.makeText(wordstudyActivity.this,"이 언어는 지원하지 않습니다.",Toast.LENGTH_SHORT).show();
                    }else{
                        list.setEnabled(true);
                    }
                }
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                int check_position=list.getCheckedItemPosition();
                String vo=(String)adapterView.getAdapter().getItem(position);


                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
                    tts.speak(vo, TextToSpeech.QUEUE_FLUSH, null, null);
                }else{
                    tts.speak(vo,TextToSpeech.QUEUE_FLUSH,null);
                }
            }
        });



    }

    public void backbutton(View v){
        Intent intent=new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }
}