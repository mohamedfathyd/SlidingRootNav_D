package com.yarolegovich.dalilegamalek.sample.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.yarolegovich.dalilegamalek.sample.Adapter.RecyclerAdapter;
import com.yarolegovich.dalilegamalek.sample.R;
import com.yarolegovich.dalilegamalek.sample.model.Apiclient_home;
import com.yarolegovich.dalilegamalek.sample.model.apiinterface_home;
import com.yarolegovich.dalilegamalek.sample.model.contact_order;

import java.util.List;

import me.anwarshahriar.calligrapher.Calligrapher;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class List_activity extends AppCompatActivity {
    TextView title;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter recyclerAdapter;
    private List<contact_order> contactList;
    private apiinterface_home apiinterface;
    ProgressBar progressBar;

    TextView textView;
    private SharedPreferences sharedpref;
    Typeface myTypeface;
    Intent intent;
    int secondry_id;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_activity);
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "Droid.ttf", true);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        intent=getIntent();
        secondry_id=intent.getIntExtra("id",0);
        name=intent.getStringExtra("name");
        this.setTitle("name");
        recyclerView=(RecyclerView)findViewById(R.id.review);
        progressBar=(ProgressBar)findViewById(R.id.progressBar_subject);
        progressBar.setVisibility(View.VISIBLE);
        this.setTitle("");
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_arrow_left_black_24dp);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }
        );

        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        fetchInfo();

    }
    public void fetchInfo(){
        apiinterface= Apiclient_home.getapiClient().create(apiinterface_home.class);
        Call<List<contact_order>> call = apiinterface.getcontacts_second(secondry_id);
        call.enqueue(new Callback<List<contact_order>>() {
            @Override
            public void onResponse(Call<List<contact_order>> call, Response<List<contact_order>> response) {
                contactList = response.body();
                progressBar.setVisibility(View.GONE);
                if (contactList.isEmpty() || contactList.equals(null)) {

                } else {    // realm.beginTransaction();


                    recyclerAdapter=new RecyclerAdapter(List_activity.this,contactList);
                    recyclerView.setAdapter(recyclerAdapter);
                }

            }

            @Override
            public void onFailure(Call<List<contact_order>> call, Throwable t) {

            }
        });
    }
}
