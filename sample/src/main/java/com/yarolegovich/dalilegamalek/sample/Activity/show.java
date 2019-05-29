package com.yarolegovich.dalilegamalek.sample.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yarolegovich.dalilegamalek.sample.R;

import me.anwarshahriar.calligrapher.Calligrapher;

public class show extends AppCompatActivity {
    Intent intent;
    String name,image,address,city,country,details,phone,category;
    Double price;
    int id,point,likes;
    Like likeclass;
    ImageView img,likee;
    TextView namee,offer,pricee,like,addresss,phonee,detailss,countryy,cityy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        this.setTitle("");
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
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "Droid.ttf", true);
        intent=getIntent();
        Initialize();
        name=intent.getStringExtra("name");
        address=intent.getStringExtra("address");
        image=intent.getStringExtra("image");
        city=intent.getStringExtra("city");

        country=intent.getStringExtra("country");
        price=intent.getDoubleExtra("price",0);
        details=intent.getStringExtra("details");
        phone=intent.getStringExtra("phone");
        category=intent.getStringExtra("category");
        id=intent.getIntExtra("id",0);
        point=intent.getIntExtra("point",0);
        likes=intent.getIntExtra("likes",0);
        namee.setText(name);
        addresss.setText(address);
        phonee.setText(phone);
        pricee.setText(price+"");
        offer.setText(point+"");
        Glide.with(this).load(image).error(R.drawable.circlelogo).into(img);
        detailss.setText(details);
        like.setText(likes+"");
       countryy.setText("البلد :"+ country);
      cityy.setText("المدينة :"+city);
      likee.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              likeclass=new Like();
              likeclass.fetchInfo(show.this,id);
          }
      });
    }
    public void Initialize(){
        img=findViewById(R.id.img);
        namee=findViewById(R.id.name);
        phonee=findViewById(R.id.phone);
        pricee=findViewById(R.id.price);
        offer=findViewById(R.id.offer);
        like=findViewById(R.id.likes);
        likee=findViewById(R.id.like);
        detailss=findViewById(R.id.details);
        addresss=findViewById(R.id.address);
        countryy=findViewById(R.id.country);
      cityy=findViewById(R.id.city);
    }
}
