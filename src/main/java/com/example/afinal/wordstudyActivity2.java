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

public class wordstudyActivity2 extends AppCompatActivity {


    private TextToSpeech tts2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wordstudy2);

        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();

        ListView list3;
        Spinner spinner2=(Spinner)findViewById(R.id.spinner2);
        list3=(ListView) findViewById(R.id.list3);
        EditText editTextFilter2=(EditText) findViewById(R.id.editTextFilter2);


        ArrayList<String> list4=new ArrayList<>();
        list4.add("600점대");
        list4.add("700점대");
        list4.add("800점대 이상");

        ArrayAdapter spinnerAdapter=new ArrayAdapter(this,R.layout.
                support_simple_spinner_dropdown_item,list4);
        spinner2.setAdapter(spinnerAdapter);
        String text=spinner2.getSelectedItem().toString();
        spinner2.setSelection(1);

        List<String> data2=new ArrayList<>();

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,data2);

        list3.setAdapter(adapter);

        data2.add("pervasive )   널리 퍼져 있는, 만연하는");
        data2.add("eradicate )   근절하다, 지우다, 많은 사람을 죽이다");
        data2.add("bombardment )   폭격, 공세");
        data2.add("prone )   경향이 있는");
        data2.add("civil )   시민의, 문명의");
        data2.add("foremost )   가장 중요한, 으뜸가는");
        data2.add("hover )   공중에 맴돌다, 배회하다");
        data2.add("economy )   절약,경제");
        data2.add("adhere )   들러붙다, 고수하다");
        data2.add("unprecedented )   전례가 없는, 공전의, 새로운");
        data2.add("ambiguous )   애매한, 두 가지로 해석할 수 있는");
        data2.add("commitment )   헌신");
        data2.add("insomnia )    불면증");
        data2.add("outstanding )   뛰어난,눈에 띄는");
        data2.add("ascribe )    탓으로 돌리다");
        data2.add("reconcile )    화해시키다, 조화시키다");
        data2.add("eclipse )    빛을 가리다, 실추시키다, 일식 월식");
        data2.add("perform )    이행하다, 공연하다");
        data2.add("illusion )    착각, 환상");
        data2.add("ingenious )    독창적인, 아주 영리한");
        data2.add("eccentric )    별난, 괴벽스러운, 별난 사람");
        data2.add("astute )    기민한, 눈치 빠른, 교활한");
        data2.add("spine )    척추");

        adapter.notifyDataSetChanged();

        list3.setTextFilterEnabled(true);




        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String text=spinner2.getSelectedItem().toString();

                if(text.equals("600점대")){
                    spinner2.setSelection(0);
                    Intent intent=new Intent(getApplicationContext(), wordstudyActivity.class);
                    startActivity(intent);
                    finish();
                }else if(text.equals("800점대 이상")){
                    spinner2.setSelection(2);
                    Intent intent=new Intent(getApplicationContext(), wordstudyActivity3.class);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




        editTextFilter2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                list3.setFilterText(editTextFilter2.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                String filterText=editable.toString();
                if(filterText.length()>0){
                    list3.setFilterText(filterText);


                }else{
                    list3.clearTextFilter();
                }
            }
        });

        tts2=new TextToSpeech(this,new TextToSpeech.OnInitListener(){

            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.SUCCESS){
                    int result=tts2.setLanguage(Locale.ENGLISH);

                    if(result==TextToSpeech.LANG_MISSING_DATA || result==TextToSpeech.LANG_NOT_SUPPORTED){
                        Toast.makeText(wordstudyActivity2.this,"이 언어는 지원하지 않습니다.",Toast.LENGTH_SHORT).show();
                    }else{
                        list3.setEnabled(true);
                    }
                }
            }
        });

        list3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                int check_position=list3.getCheckedItemPosition();
                String vo=(String)adapterView.getAdapter().getItem(position);


                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
                    tts2.speak(vo, TextToSpeech.QUEUE_FLUSH, null, null);
                }else{
                    tts2.speak(vo,TextToSpeech.QUEUE_FLUSH,null);
                }
            }
        });



    }

    public void backbutton8(View v){
        Intent intent=new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }
}