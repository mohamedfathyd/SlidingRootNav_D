package com.yarolegovich.dalilegamalek.sample.Activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.text.InputType;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.yarolegovich.dalilegamalek.sample.R;
import com.yarolegovich.dalilegamalek.sample.model.Apiclient_home;
import com.yarolegovich.dalilegamalek.sample.model.apiinterface_home;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import me.anwarshahriar.calligrapher.Calligrapher;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Regestration_activity extends AppCompatActivity {
    TextInputLayout textInputLayoutname,textInputLayoutaddress,textInputLayoutphone,textInputLayoutcountry,textInputLayoutage,
            textInputLayoutpassword,textInputLayoutconfirmpassword,textInputLayoutr;
    EditText textInputEditTextname,textInputEditTextaddress,textInputEditTextphone,textInputEditTextcountry,textInputEditTextage,
            textInputEditTextpassword,textInputEditTextconfirmpassword,textInputEditTextr,textInputEditTextmail;
    AppCompatButton regesiter;
    TextView openlogin;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
   Call<ResponseBody> call = null;
    String code,mVerificationId;
    ProgressDialog progressDialog;
    ImageView profile;
    ProgressDialog progressDialog1;
    //   login_ login_;
    String codee =null;
  private FirebaseAuth mAuth;
      private apiinterface_home apiinterface;
    Bitmap bitmap;
    private  static final int IMAGE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regestration_activity);
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "Droid.ttf", true);


  inisialize();

        openlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   startActivity(new Intent(Registration.this,LoginActivity.class));
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectImage();
            }
        });
        regesiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regesiter.setClickable(false);
                if (textInputEditTextaddress.getText().toString().equals("") || textInputEditTextaddress.getText().toString() == null) {

                    textInputLayoutaddress.setError("أدخل البريد الألكترونى");

                } else if (textInputEditTextname.getText().toString().equals("") || textInputEditTextname.getText().toString() == null) {

                    textInputLayoutname.setError("أدخل اسم المستخدم");

                } else if (textInputEditTextphone.getText().toString().equals("") || textInputEditTextphone.getText().toString() == null) {

                    textInputLayoutphone.setError("أدخل رقم الموبيل");

                } else if (textInputEditTextpassword.getText().toString().equals("") || textInputEditTextpassword.getText().toString() == null) {

                    textInputLayoutpassword.setError("أدخل كلمة المرور");

                } else if (textInputEditTextconfirmpassword.getText().toString().equals("") || textInputEditTextconfirmpassword.getText().toString() == null) {

                    textInputLayoutconfirmpassword.setError("أدخل  تأكيد كلمة المرور");

                } else if (!textInputEditTextconfirmpassword.getText().toString().equals(textInputEditTextpassword.getText().toString())) {
                    textInputLayoutconfirmpassword.setError("كلمة تأكيد مختلفة");
                } else {
                    String phone="+2"+textInputEditTextphone.getText().toString();
                    //  Toast.makeText(Registration.this,"a",Toast.LENGTH_LONG).show();
                    PhoneAuthProvider.getInstance().verifyPhoneNumber(
                            phone,        // Phone number to verify
                            60,                 // Timeout duration
                            TimeUnit.SECONDS,   // Unit of timeout
                            Regestration_activity.this,               // Activity (for callback binding)
                            mCallbacks);

                    progressDialog1 = ProgressDialog.show(Regestration_activity.this, "انتظر قليلا للتاكد من صحة البيانات", "Please wait...", false, false);
                    progressDialog1.show();

                    // fetchInfo();
                }
            }
        });
        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(PhoneAuthCredential credential) {

            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                // This callback is invoked in an invalid request for verification is made,
                // for instance if the the phone number format is not valid.


                if (e instanceof FirebaseAuthInvalidCredentialsException) {
                    // Invalid request
                    // ...
                } else if (e instanceof FirebaseTooManyRequestsException) {
                    // The SMS quota for the project has been exceeded
                    // ...
                }

                // Show a message and update the UI
                // ...
            }

            @Override
            public void onCodeSent(final String verificationId,
                                   PhoneAuthProvider.ForceResendingToken token) {
                // The SMS verification code has been sent to the provided phone number, we
                // now need to ask the user to enter the code and then construct a credential
                // by combining the code with a verification ID.
                progressDialog1.dismiss();
                AlertDialog.Builder builder = new AlertDialog.Builder(Regestration_activity.this);
                builder.setTitle("أدخل كود الذى وصلك فى رسالة نصية :");

// Set up the input
                final EditText input = new EditText(Regestration_activity.this);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                builder.setView(input);

// Set up the buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        code = input.getText().toString();
                        mVerificationId = verificationId;
                        verifyVerificationCode(code);

                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();


                // Save verification ID and resending token so we can use them later

                // ...
            }
        };

    }

    private void verifyVerificationCode(String code) {
        //creating the credential
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, code);

        //signing the user
        signInWithPhoneAuthCredential(credential);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(Regestration_activity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            fetchInfo();
                        } else {

                            //verification unsuccessful.. display an error message
                            Toast.makeText(Regestration_activity.this,"كود التاكيد خاطئ",Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }
    public void fetchInfo() {
        progressDialog = ProgressDialog.show(Regestration_activity.this, "جاري انشاء الحساب", "Please wait...", false, false);
        progressDialog.show();
        String image = convertToString();
        String phone="+2"+textInputEditTextphone.getText().toString();
        int x= Integer.parseInt(textInputEditTextr.getText().toString());
        if(textInputEditTextr.getText().toString().equals("")){
            x=0;
        }
        apiinterface = Apiclient_home.getapiClient().create(apiinterface_home.class);
        Call<ResponseBody> call = apiinterface.getcontacts(textInputEditTextname.getText().toString(),
                textInputEditTextpassword.getText().toString(), textInputEditTextaddress.getText().toString()
                ,phone,textInputEditTextage.getText().toString(),textInputEditTextmail.getText().toString(),
               image);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                progressDialog.dismiss();

                AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Regestration_activity.this);
                dlgAlert.setMessage("تم أنشاء حساب جديد بنجاح");
                dlgAlert.setTitle("دللي جمالك");
                dlgAlert.setPositiveButton("OK", null);
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();
              login_  login_=new login_();
                String phone="+2"+textInputEditTextphone.getText().toString();
                login_.fetchInfo(Regestration_activity.this,phone,textInputEditTextpassword.getText().toString());
                finish();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(Regestration_activity.this, t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void inisialize() {

        textInputEditTextname =  findViewById(R.id.input_name);
        textInputEditTextphone =  findViewById(R.id.input_mobile);
        textInputEditTextaddress =  findViewById(R.id.input_address);
        textInputEditTextmail= findViewById(R.id.input_email);
        textInputEditTextpassword =  findViewById(R.id.input_password);
        textInputEditTextage =  findViewById(R.id.intent_data);
        textInputEditTextconfirmpassword =  findViewById(R.id.input_reEnterPassword);
        regesiter = (AppCompatButton) findViewById(R.id.btn_signup);
        profile=findViewById(R.id.image);
        openlogin =  findViewById(R.id.link_login);
        mAuth = FirebaseAuth.getInstance();

    }
    private void selectImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, IMAGE);
    }
    private String convertToString()
    {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,70,byteArrayOutputStream);
        byte[] imgByte = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(imgByte, Base64.DEFAULT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== IMAGE && resultCode==RESULT_OK && data!=null)
        {
            Uri path = data.getData();

            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),path);
                profile.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}