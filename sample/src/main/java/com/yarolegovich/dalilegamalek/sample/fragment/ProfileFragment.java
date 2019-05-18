package com.yarolegovich.dalilegamalek.sample.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yarolegovich.dalilegamalek.sample.R;

import me.anwarshahriar.calligrapher.Calligrapher;


/**
 * Created by yarolegovich on 25.03.2017.
 */

public class ProfileFragment extends Fragment {

    private static final String EXTRA_TEXT = "text";
    private SharedPreferences sharedpref;
    String name,age,address,phone,image,mail;
    TextView date,point,order,named,email,pho,add,idt,datet,pointt;
    ImageView images;
    int id,points;
Typeface myTypeface;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_profile_page, container, false);
        inisialize(view);
        myTypeface = Typeface.createFromAsset(getActivity().getAssets(), "Droid.ttf");
        Calligrapher calligrapher = new Calligrapher(getActivity());
        calligrapher.setFont(getActivity(), "Droid.ttf", true);
        sharedpref= getActivity().getSharedPreferences("ManoAd", Context.MODE_PRIVATE);
        id=sharedpref.getInt("id",0);
        name=sharedpref.getString("name","");
        address=sharedpref.getString("address","");
        phone=sharedpref.getString("phone","");
        image=sharedpref.getString("image","");
        points=sharedpref.getInt("points",0);
        age=sharedpref.getString("age","");
        mail=sharedpref.getString("email","");
        Glide.with(this).load(image).error(R.drawable.circlelogo).into(images);

        email.setText(mail);
        email.setTypeface(myTypeface);
        date.setText(age);
        date.setTypeface(myTypeface);
        named.setText(name);
        named.setTypeface(myTypeface);
        point.setText(points+"");
        point.setTypeface(myTypeface);
        pho.setText(phone);
        pho.setTypeface(myTypeface);
        add.setText(address);
        add.setTypeface(myTypeface);
        order.setText(id+"");
        order.setTypeface(myTypeface);
        idt.setText("رقم المستخدم");
        idt.setTypeface(myTypeface);
        pointt.setText("النقاط");
        pointt.setTypeface(myTypeface);
        datet.setText("تاريخ الميلاد");
        datet.setTypeface(myTypeface);
        return view;
    }
    public void inisialize(View view){
        date=view.findViewById(R.id.age);
        point=view.findViewById(R.id.point);
        order=view.findViewById(R.id.order);
        images=view.findViewById(R.id.img);
        named=view.findViewById(R.id.name);
        email=view.findViewById(R.id.email);
        pho=view.findViewById(R.id.phone);
        add=view.findViewById(R.id.address);
        datet=view.findViewById(R.id.aget);
        pointt=view.findViewById(R.id.pointt);
        idt=view.findViewById(R.id.ordert);

    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

    }
}
