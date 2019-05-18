package com.yarolegovich.dalilegamalek.sample.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.yarolegovich.dalilegamalek.sample.R;

import me.anwarshahriar.calligrapher.Calligrapher;

public class FilterActivity extends AppCompatActivity {
String [] egypt={"القاهرة", "الجيزة","المنبا","السويس","الأقصر","الاسكندرية","بورسعيد","دمياط","أسوان","القليوبية","بنى سويف","الاسماعيلية","" +
            "سوهاج","أسيوط","البحر الأحمر","البحيرة","الدقهلية","الغربية","الفيوم","قنا","كفر الشيخ","مطروح","المنوفيه","الوادى الجديد","" +
            "6 من أكنوبر","شمال سيناء","جنوب سيناء","حلوان","الشارقية"};
String [] saudia={"الرياض","مكة المكرمة","المدينة المنورة","القصيم","الشرقية","عسير","تبوك","حائل","الحدود الشمالية","جازان","نجران","" +
        "الباحة","الجوف"};
String [] emarat={"دبي","أبوظبي","الشارقة","العين","رأس الخيمة","عجمان","الفجيرة","أم القيوين","خورفكان","دبا الحصن"};
String [] bahren={"العاصمة","المحرق","الشمالية","الجنوبية"};
String [] aman={"الداخلية","الظاهرة","شمال الباطنة","جنوب الباطنة","البريمى","الوسطى","شمال الشرقية","جنوب الشرقية","ظفار","مسقط","مسندم"};
String []qatar={"الريان","الدوحة","الخور","الوكرة","الشمال","أم صلال"};
String []kuwait={"العاصمة","الجهراء","الفراونية","حولى","مبارك الكبير"};
Spinner spn,spncontry;
    AppCompatButton search;
    Intent intent;
    int id;
    EditText fromm,too;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        intent=getIntent();
        id=intent.getIntExtra("id",0);
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "Droid.ttf", true);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_chevron_right_black_24dp);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }
        );
        search=findViewById(R.id.btn_login);
        fromm=findViewById(R.id.from);
        too=findViewById(R.id.to);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fromm.getText().toString()==null||fromm.getText().toString().equals("")||too.getText().toString()==null||too.getText().toString().equals("")){
                    String city=spn.getSelectedItem().toString();
                    int from= 0;
                    int to= 100000;
                    Intent intent=new Intent(FilterActivity.this,Filtter_data.class);
                    intent.putExtra("city",city);
                    intent.putExtra("from",from);
                    intent.putExtra("to",to);
                    intent.putExtra("id",id);
                    startActivity(intent);
                    finish();
                }
                else{
                String city=spn.getSelectedItem().toString();
                int from= Integer.parseInt(fromm.getText().toString());
                int to= Integer.parseInt(too.getText().toString());
                Intent intent=new Intent(FilterActivity.this,Filtter_data.class);
                intent.putExtra("city",city);
                intent.putExtra("from",from);
                intent.putExtra("to",to);
                intent.putExtra("id",id);
                startActivity(intent);
                finish();}
            }
        });
      spn=findViewById(R.id.spinsss);
        spncontry=findViewById(R.id.spin);
        spncontry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(spncontry.getSelectedItem().toString().equals("مصر")) {
                    ArrayAdapter<String> adpt_area = new ArrayAdapter<String>(FilterActivity.this,
                            android.R.layout.simple_spinner_dropdown_item, egypt);
                    spn.setAdapter(adpt_area);
                }
                else if(spncontry.getSelectedItem().toString().equals("السعودية")){
                    ArrayAdapter<String> adpt_area = new ArrayAdapter<String>(FilterActivity.this,
                            android.R.layout.simple_spinner_dropdown_item, saudia);
                    spn.setAdapter(adpt_area);
                }
                else if(spncontry.getSelectedItem().toString().equals("الأمارات")){
                    ArrayAdapter<String> adpt_area = new ArrayAdapter<String>(FilterActivity.this,
                            android.R.layout.simple_spinner_dropdown_item, emarat);
                    spn.setAdapter(adpt_area);
                }
                else if(spncontry.getSelectedItem().toString().equals("الكويت")){
                    ArrayAdapter<String> adpt_area = new ArrayAdapter<String>(FilterActivity.this,
                            android.R.layout.simple_spinner_dropdown_item, kuwait);
                    spn.setAdapter(adpt_area);
                }
                else if(spncontry.getSelectedItem().toString().equals("عمان")){
                    ArrayAdapter<String> adpt_area = new ArrayAdapter<String>(FilterActivity.this,
                            android.R.layout.simple_spinner_dropdown_item, aman);
                    spn.setAdapter(adpt_area);
                }
                else if(spncontry.getSelectedItem().toString().equals("قطر")){
                    ArrayAdapter<String> adpt_area = new ArrayAdapter<String>(FilterActivity.this,
                            android.R.layout.simple_spinner_dropdown_item, qatar);
                    spn.setAdapter(adpt_area);
                }
                else if(spncontry.getSelectedItem().toString().equals("البحرين")){
                    ArrayAdapter<String> adpt_area = new ArrayAdapter<String>(FilterActivity.this,
                            android.R.layout.simple_spinner_dropdown_item, bahren);
                    spn.setAdapter(adpt_area);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
      
    }
}
