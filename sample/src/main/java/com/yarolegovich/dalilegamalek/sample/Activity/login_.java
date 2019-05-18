package com.yarolegovich.dalilegamalek.sample.Activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.yarolegovich.dalilegamalek.sample.SampleActivity;
import com.yarolegovich.dalilegamalek.sample.model.Apiclient_home;
import com.yarolegovich.dalilegamalek.sample.model.apiinterface_home;
import com.yarolegovich.dalilegamalek.sample.model.contact_home;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login_ {
    private List<contact_home> contactList;
    private apiinterface_home apiinterface;
    private SharedPreferences sharedpref;
    private SharedPreferences.Editor edt;
    ProgressDialog progressDialog;
    public void fetchInfo(final Context context, String phone,String password){
        sharedpref = context.getSharedPreferences("ManoAd", Context.MODE_PRIVATE);
        edt = sharedpref.edit();

        progressDialog = ProgressDialog.show(context,"جاري تسجيل الدخول","Please wait...",false,false);
        progressDialog.show();
        apiinterface= Apiclient_home.getapiClient().create(apiinterface_home.class);
        Call<List<contact_home>> call= apiinterface.getcontacts_login(phone,password);
        call.enqueue(new Callback<List<contact_home>>() {
            @Override
            public void onResponse(Call<List<contact_home>> call, Response<List<contact_home>> response) {
                contactList = response.body();
                progressDialog.dismiss();
              try{
                AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(context);
                dlgAlert.setMessage("تم تسجيل الدخول بنجاح");
                dlgAlert.setTitle("دللي جمالك");
                dlgAlert.setPositiveButton("OK", null);
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();
                  edt.putInt("id",contactList.get(0).getId());
                  edt.putString("name",contactList.get(0).getName());
                  edt.putString("phone",contactList.get(0).getPhone());
                  edt.putString("address",contactList.get(0).getAddress());
                  edt.putString("password",contactList.get(0).getPassword());
                  edt.putInt("points",contactList.get(0).getPoints());
                  edt.putString("email",contactList.get(0).getEmail());
                  edt.putString("image",contactList.get(0).getImage());
                  edt.putString("age", String.valueOf(contactList.get(0).getDate()));
                  edt.putString("remember","yes");
                  edt.apply();
                context.startActivity(new Intent(context, SampleActivity.class));}
                catch (Exception e){

                }
            }

            @Override
            public void onFailure(Call<List<contact_home>> call, Throwable t) {
                Toast.makeText(context,t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

}
