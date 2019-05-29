package com.yarolegovich.dalilegamalek.sample.Activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.yarolegovich.dalilegamalek.sample.model.Apiclient_home;
import com.yarolegovich.dalilegamalek.sample.model.apiinterface_home;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Like {

    Call<ResponseBody> call = null;
    private apiinterface_home apiinterface;
    SharedPreferences sharedpref;
    public void fetchInfo(final Context context,int annonce_id) {
        sharedpref = context.getSharedPreferences("ManoAd", Context.MODE_PRIVATE);
        int user_id=sharedpref.getInt("id",0);
        apiinterface = Apiclient_home.getapiClient().create(apiinterface_home.class);
        Call<ResponseBody> call = apiinterface.getcontacts_like(user_id,annonce_id);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                Toast.makeText(context,"أعجبنى هذا ....",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
