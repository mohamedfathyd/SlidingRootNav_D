package com.yarolegovich.dalilegamalek.sample.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.yarolegovich.dalilegamalek.sample.Adapter.RecyclerAdapter_first;
import com.yarolegovich.dalilegamalek.sample.Adapter.RecyclerAdapter_first_annonce;
import com.yarolegovich.dalilegamalek.sample.R;
import com.yarolegovich.dalilegamalek.sample.model.Apiclient_home;
import com.yarolegovich.dalilegamalek.sample.model.apiinterface_home;
import com.yarolegovich.dalilegamalek.sample.model.contact_annonce;
import com.yarolegovich.dalilegamalek.sample.model.contact_home;
import com.yarolegovich.dalilegamalek.sample.model.content_category;

import java.util.List;

import me.anwarshahriar.calligrapher.Calligrapher;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by yarolegovich on 25.03.2017.
 */

public class CenteredTextFragment extends Fragment {
    private RecyclerAdapter_first_annonce recyclerAdapter_annonce;
    private List<content_category> contactList;
    private List<contact_annonce> contactList_annonce;
    ProgressBar progressBar;
    private apiinterface_home apiinterface;
    int x=0;
    private RecyclerView recyclerView,recyclerView2;
    private RecyclerView.LayoutManager layoutManager1,layoutManager2;
    CountDownTimer countDownTimer;

    int y=0;
    private RecyclerAdapter_first recyclerAdapter;


    private static final String EXTRA_TEXT = "text";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.main_fragment, container, false);
        Calligrapher calligrapher = new Calligrapher(getActivity());
        calligrapher.setFont(getActivity(), "Droid.ttf", true);
        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerview);
        progressBar=(ProgressBar)view.findViewById(R.id.progressBar_subject);
        progressBar.setVisibility(View.VISIBLE);
        layoutManager1 = new GridLayoutManager(getActivity(), 3);
        recyclerView.setLayoutManager(layoutManager1);
        //recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, true));
        recyclerView.setHasFixedSize(true);
        recyclerView2=(RecyclerView)view.findViewById(R.id.recyclerview2);
        layoutManager2 = new GridLayoutManager(getActivity(), 3);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true));
        recyclerView2.setHasFixedSize(true);
        fetchInfo_annonce();
        fetchInfo();

        try {


            final int counter=100*5000;

            countDownTimer=   new CountDownTimer(counter, 5000) {

                public void onTick(long millisUntilFinished) {
                    // Toast.makeText(MainActivity.this , ""+(millisUntilFinished / 1000),Toast.LENGTH_LONG).show();
                    recyclerView2.smoothScrollToPosition(y);
                    y++;
                    if(y>x){
                        y=0;
                    }
                    //here you can have your logic to set text to edittext

                }

                public void onFinish() {

                }

            }.start();}
        catch (Exception e){}

        return view;
    }
    public void fetchInfo(){
        apiinterface= Apiclient_home.getapiClient().create(apiinterface_home.class);
        Call<List<content_category>> call = apiinterface.getcontacts_allfirst();
        call.enqueue(new Callback<List<content_category>>() {
            @Override
            public void onResponse(Call<List<content_category>> call, Response<List<content_category>> response) {
                try {
                    contactList = response.body();
                    progressBar.setVisibility(View.GONE);
                    if (!contactList.isEmpty() || contactList.equals(null)) {
                        recyclerAdapter = new RecyclerAdapter_first(getActivity(), contactList);
                        recyclerView.setAdapter(recyclerAdapter);
                    }
                }
                catch (Exception e){}

            }

            @Override
            public void onFailure(Call<List<content_category>> call, Throwable t) {

            }
        });
    }
    public void fetchInfo_annonce(){
        apiinterface= Apiclient_home.getapiClient().create(apiinterface_home.class);
        Call<List<contact_annonce>> call = apiinterface.getcontacts_annonce();
        call.enqueue(new Callback<List<contact_annonce>>() {
            @Override
            public void onResponse(Call<List<contact_annonce>> call, Response<List<contact_annonce>> response) {
                try{
                contactList_annonce = response.body();
                if(!contactList_annonce.isEmpty()|| contactList_annonce.equals(null)){
                    progressBar.setVisibility(View.GONE);
                    x=contactList_annonce.size();
                    recyclerAdapter_annonce=new RecyclerAdapter_first_annonce(getActivity(),contactList_annonce,recyclerView2);
                    recyclerView2.setAdapter(recyclerAdapter_annonce);}
                progressBar.setVisibility(View.GONE);}
                catch (Exception e){

                }
            }

            @Override
            public void onFailure(Call<List<contact_annonce>> call, Throwable t) {

            }
        });
    }
    public static CenteredTextFragment createFor(String text) {
        CenteredTextFragment fragment = new CenteredTextFragment();
        Bundle args = new Bundle();
        args.putString(EXTRA_TEXT, text);
        fragment.setArguments(args);
        return fragment;
    }
}
