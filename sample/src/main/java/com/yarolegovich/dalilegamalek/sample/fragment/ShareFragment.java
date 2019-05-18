package com.yarolegovich.dalilegamalek.sample.fragment;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.yarolegovich.dalilegamalek.sample.Activity.FilterActivity;
import com.yarolegovich.dalilegamalek.sample.Activity.Regestration_activity;
import com.yarolegovich.dalilegamalek.sample.Activity.login_;
import com.yarolegovich.dalilegamalek.sample.R;
import com.yarolegovich.dalilegamalek.sample.model.Apiclient_home;
import com.yarolegovich.dalilegamalek.sample.model.apiinterface_home;

import me.anwarshahriar.calligrapher.Calligrapher;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by yarolegovich on 25.03.2017.
 */

public class ShareFragment extends Fragment {

    private static final String EXTRA_TEXT = "text";
    AppCompatButton a;
Typeface myTypeface;
EditText id,points;
int id_receive,id_send,point,mypoint;
    private SharedPreferences sharedpref;
    Call<ResponseBody> call = null;
    private apiinterface_home apiinterface;
    private SharedPreferences.Editor edt;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.sendfragment, container, false);
        Calligrapher calligrapher = new Calligrapher(getActivity());
        myTypeface = Typeface.createFromAsset(getActivity().getAssets(), "Droid.ttf");
        id=view.findViewById(R.id.id);
        points=view.findViewById(R.id.points);

        sharedpref= getActivity().getSharedPreferences("ManoAd", Context.MODE_PRIVATE);
        id_send=sharedpref.getInt("id",0);
        mypoint=sharedpref.getInt("points",0);
        edt = sharedpref.edit();


        calligrapher.setFont(getActivity(), "Droid.ttf", true);
        a=view.findViewById(R.id.btn_login);
        a.setTypeface(myTypeface);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id_receive= Integer.parseInt(id.getText().toString());
                point= Integer.parseInt(points.getText().toString());
                if(mypoint<point){
                    Toast.makeText(getActivity(), "رصيد نقاطك غير كافى" ,Toast.LENGTH_LONG).show();
                }
                else {
                    fetchInfo();
                }
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

    }
    public void fetchInfo() {

        apiinterface = Apiclient_home.getapiClient().create(apiinterface_home.class);
        Call<ResponseBody> call = apiinterface.getcontacts_send(id_send,id_receive,point);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                AlertDialog.Builder dlgAlert = new AlertDialog.Builder(getActivity());
                dlgAlert.setMessage("تم أرسال النقاط بنجاح");
                dlgAlert.setTitle("دللي جمالك");
                dlgAlert.setPositiveButton("OK", null);
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();
                edt.putInt("points",(mypoint-point));
                edt.apply();

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getActivity(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
