package com.yarolegovich.slidingrootnav.sample.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.TextView;

import com.yarolegovich.slidingrootnav.sample.R;
import com.yarolegovich.slidingrootnav.sample.SampleActivity;

import me.anwarshahriar.calligrapher.Calligrapher;

public class Login_activity extends AppCompatActivity {

    AppCompatTextView Naccount;
    AppCompatButton login;
    TextView newaccount;
    TextInputEditText textInputEditTextphone,textInputEditTextpassword;
    TextInputLayout textInputLayoutphone,textInputLayoutpassword;
    // private List<contact_userinfo> contactList;
    //  private apiinterface_home apiinterface;
    private SharedPreferences sharedpref;
    private SharedPreferences.Editor edt;
    ProgressDialog progressDialog;
    String codee;

    //  login__ login__;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "Droid.ttf", true);

        newaccount=findViewById(R.id.link_signup);
        login=findViewById(R.id.btn_login);
        newaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login_activity.this,Regestration_activity.class));
            }

        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login_activity.this, SampleActivity.class));
            }
        });

    }}
     /*   login__=new login__();
        textInputLayoutphone=(TextInputLayout)findViewById(R.id.textInputLayoutphone);
        textInputLayoutpassword=(TextInputLayout)findViewById(R.id.textInputLayoutPassword);
        textInputEditTextphone=(TextInputEditText)findViewById(R.id.textInputEditTextphone);




        sharedpref = getSharedPreferences("ManoAd", Context.MODE_PRIVATE);
        edt = sharedpref.edit();

        if(sharedpref.getString("remember","").trim().equals("yes")){
            login__.fetchInfo(this,sharedpref.getString("phone","").trim(),sharedpref.getString("password","").trim());

            startActivity(new Intent(LoginActivity.this,MainActivity.class));
            finish();
        }
        textInputEditTextpassword=(TextInputEditText)findViewById(R.id.textInputEditTextPassword);
        Naccount=(AppCompatTextView)findViewById(R.id.textViewLinkRegister);
        Naccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,Registration.class));
            }
        });
        login=(AppCompatButton)findViewById(R.id.appCompatButtonLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchInfo();
            }
        });
    }
    public void fetchInfo(){
        progressDialog = ProgressDialog.show(LoginActivity.this,"جاري تسجيل الدخول","Please wait...",false,false);
        progressDialog.show();
        String phone="+2"+textInputEditTextphone.getText().toString();
        apiinterface= Apiclient_home.getapiClient().create(apiinterface_home.class);
        Call<List<contact_userinfo>> call= apiinterface.getcontacts_login(phone,
                textInputEditTextpassword.getText().toString());
        call.enqueue(new Callback<List<contact_userinfo>>() {
            @Override
            public void onResponse(Call<List<contact_userinfo>> call, Response<List<contact_userinfo>> response) {
                if(response.isSuccessful()){

                    contactList = response.body();
                    try {
                        progressDialog.dismiss();
                        edt.putInt("id",contactList.get(0).getId());
                        edt.putString("name",contactList.get(0).getName());
                        edt.putString("phone",contactList.get(0).getPhone());
                        edt.putString("address",contactList.get(0).getmaddress());
                        edt.putString("password",contactList.get(0).getPassword());
                        edt.putString("points",contactList.get(0).getPoints());
                        edt.putString("country",contactList.get(0).getCountry());
                        edt.putString("age", String.valueOf(contactList.get(0).getAge()));
                        edt.putString("remember","yes");
                        edt.apply();
                        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(LoginActivity.this);
                        dlgAlert.setMessage("تم تسجيل الدخول بنجاح");
                        dlgAlert.setTitle("ManoAd");
                        dlgAlert.setPositiveButton("OK", null);
                        dlgAlert.setCancelable(true);
                        dlgAlert.create().show();
                        startActivity(new Intent(LoginActivity.this,MainActivity.class));}
                    catch (Exception e){
                        Toast.makeText(LoginActivity.this,"هناك خطأ فى الهاتف او الرقم السري /",Toast.LENGTH_LONG).show();

                        progressDialog.dismiss();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<contact_userinfo>> call, Throwable t) {
                Toast.makeText(LoginActivity.this,"هناك خطأ فى الهاتف او الرقم السري",Toast.LENGTH_LONG).show();

                progressDialog.dismiss();
            }
        });
    }
}
*/