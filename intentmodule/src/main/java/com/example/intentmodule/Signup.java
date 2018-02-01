package com.example.intentmodule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Signup extends AppCompatActivity implements View.OnClickListener {

    private String TAG= Signup.class.getSimpleName();
    private EditText editTextName;
    private EditText editTextPhoneno;
    private EditText editTextPassword;
    private EditText editTextAddress;
    private EditText editTextPaincode;
    private EditText editTextUsername;
    private Button buttonClear;
    private Button buttonSubmit;

    String name,Address,pnincode,pass,username,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Log.e(TAG, "onCreate: ");
        initContol();
    }
    private void initContol() {

        editTextName=findViewById(R.id.editTextName);
        editTextPhoneno=findViewById(R.id.editTextPhoneno);
        editTextAddress=findViewById(R.id.editTextAddress);
        editTextPaincode=findViewById(R.id.editTextPaincode);
        editTextPassword=findViewById(R.id.editTextPassword);
        editTextUsername=findViewById(R.id.editTextUsername);
        buttonClear=findViewById(R.id.buttonClear);
        buttonSubmit=findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {



        switch (v.getId())
        {
            case R.id.buttonSubmit:
                getvalue();
                submitdata();
                break;

            case R.id.buttonClear:
                cleardata();
                break;
        }
    }



    private void submitdata() {

        Log.e(TAG, "submitdata: ");
        getvalue();
        Intent intent=new Intent(Signup.this,LoginActivity.class);
        intent.putExtra("Mynaeme",name);
        intent.putExtra("Myusername",username);
        intent.putExtra("Mypassword",pass);
        intent.putExtra("Mypincode",pnincode);
        intent.putExtra("Myaddress",Address);
        intent.putExtra("Myphoneno",phone);

        startActivity(intent);
    }



    private void cleardata() {

        Log.e(TAG, "cleardata: ");
        editTextAddress.setText("");
        editTextName.setText("");
        editTextPaincode.setText("");
        editTextPassword.setText("");
        editTextPhoneno.setText("");
        editTextUsername.setText("");
        editTextName.requestFocus();


    }

    private void getvalue() {

         name= editTextName.getText().toString();
         Address=editTextAddress.getText().toString();
         pnincode=editTextPaincode.getText().toString();
         pass=editTextPassword.getText().toString();
         username=editTextUsername.getText().toString();
         phone=editTextPhoneno.getText().toString();

    }
}
