package com.example.intentmodule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private String TAG = LoginActivity.class.getSimpleName();
    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonClear;
    private Button buttonSubmit;
    private TextView textViewSignUp;
    String name, pass, userNameforintent, Passwordforintent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        Log.e(TAG, "onCreate: ");
        intiControl();

    }

    private void intiControl() {

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonClear = findViewById(R.id.buttonClear);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        textViewSignUp = findViewById(R.id.textViewSignUp);


        buttonSubmit.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
        textViewSignUp.setOnClickListener(this);


      /*  buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e(TAG, "onClick: this is clear ");

                cleardata();
            }
        });*/

        /*buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e(TAG, "onClick: this is submit ");
                getValue();
            }
        });*/

        /*textViewSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e(TAG, "onClick: this is for Sign Up" );
            }
        });*/

    }

    void getValue() {
        Log.e(TAG, "getValue: ");
        name = editTextUsername.getText().toString();
        pass = editTextPassword.getText().toString();

        Log.e(TAG, "getValue: name is " + name + "   pass is " + pass);
    }

    private void cleardata() {

        Log.e(TAG, "cleardata: ");
        editTextPassword.setText("");
        editTextUsername.setText("");
        editTextUsername.requestFocus();
//        InputMethodManager imm = (InputMethodManager) getSystemService(getApplicationContext().INPUT_METHOD_SERVICE);
//        imm.showSoftInput(editTextUsername, InputMethodManager.RESULT_HIDDEN);

    }

    @Override
    public void onClick(View v) {

        Log.e(TAG, "onClick: ");

        switch (v.getId()) {
            case R.id.buttonClear:
                cleardata();
                break;

            case R.id.buttonSubmit:


                getValue();
                matchdata();
                break;

            case R.id.textViewSignUp:
                gotosignup();
                break;
        }
    }


    private void matchdata() {
        if (getIntent().getExtras() != null) {
            userNameforintent = getIntent().getExtras().getString("Myusername");
            Passwordforintent = getIntent().getExtras().getString("Mypassword");
            if (name.equals(userNameforintent) && pass.equals(Passwordforintent)) {
                Log.e(TAG, "matchdata: this is if ");
                Toast.makeText(getApplicationContext(), "Succesfully login", Toast.LENGTH_SHORT).show();
            } else {
                Log.e(TAG, "matchdata: this is elese");
                Toast.makeText(getApplicationContext(), "Wrong information ", Toast.LENGTH_SHORT).show();
            }
        }
    }



    private void gotosignup() {

        Intent intent = new Intent(LoginActivity.this, Signup.class);
        Log.e(TAG, "gotosignup: ");

        startActivityForResult(intent, 30);
    }
}
