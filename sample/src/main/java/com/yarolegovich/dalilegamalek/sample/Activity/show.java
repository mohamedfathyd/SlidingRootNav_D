package com.yarolegovich.dalilegamalek.sample.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yarolegovich.dalilegamalek.sample.R;

import me.anwarshahriar.calligrapher.Calligrapher;

public class show extends AppCompatActivity {
    Intent intent;
    String name,image,address,city,country,price,details,phone,category;
    int id,point,likes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "Droid.ttf", true);
        intent=getIntent();
        name=intent.getStringExtra("name");
        address=intent.getStringExtra("address");
        image=intent.getStringExtra("image");
        city=intent.getStringExtra("city");

        country=intent.getStringExtra("country");
        price=intent.getStringExtra("price");
        details=intent.getStringExtra("details");
        phone=intent.getStringExtra("phone");
        category=intent.getStringExtra("category");
        id=intent.getIntExtra("id",0);
        point=intent.getIntExtra("point",0);
        likes=intent.getIntExtra("likes",0);
    }
}
