package com.yarolegovich.slidingrootnav.sample.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.yarolegovich.slidingrootnav.sample.R;

public class FilterActivity extends AppCompatActivity {
String [] egypt={"القاهرة", "الجيزة","المنبا","السويس","الأقصر","الاسكندرية","بورسعيد","دمياط","أسوان","القليوبية","بنى سويف","الاسماعيلية","" +
            "سوهاج","أسيوط","البحر الأحمر","البحيرة","الدقهلية","الغربية","الفيوم","قنا","كفر الشيخ","مطروح","المنوفيه","الوادى الجديد","" +
            "6 من أكنوبر","شمال سيناء","جنوب سيناء","حلوان","الشارقية"};
String [] saudia={"الرياض","مكة المكرمو","المدينة المنورة","القصيم","الشرقية","عسير","تبوك","حائل","الحدود الشمالية","جازان","نجران","" +
        "الباحة","الجوف"};
String [] emarat={"دبي","أبوظبي","الشارقة","العين","رأس الخيمة","عجمان","الفجيرة","أم القيوين","خورفكان","دبا الحصن"};
String [] bahren={"العاصمة","المحرق","الشمالية","الجنوبية"};
String [] aman={"الداخلية","الظاهرة","شمال الباطنة","جنوب الباطنة","البريمى","الوسطى","شمال الشرقية","جنوب الشرقية","ظفار","مسقط","مسندم"};
String []qatar={"الريان","الدوحة","الخور","الوكرة","الشمال","أم صلال"};
String []kuwait={"العاصمة","الجهراء","الفراونية","حولى","مبارك الكبير"};
Spinner spn,spncontry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
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
