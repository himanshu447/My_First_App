package com.example.beardman.my_first_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public String TAG = MainActivity.class.getSimpleName();
    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button Clear;
    private Button Submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG, "onCreate: this is oncreate");

        initControl();
    }

   public void initControl()
    {
        Log.e(TAG, "initControl: init view" );
        editTextUsername=findViewById(R.id.editTextUsername);
        editTextPassword=findViewById(R.id.editTextPassword);
        Submit=findViewById(R.id.buttonSubmit);
        Clear=findViewById(R.id.buttonClear);


            Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e(TAG, "onClick: this is clear log");
                cleartext();
            }
        });

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e(TAG, "onClick: this is submit log");
                getvalue();
            }
        });

    }

    void getvalue()
    {
        Log.e(TAG, "getvalue: ");
        String username=editTextUsername.getText().toString();
        String pass=editTextPassword.getText().toString();
        Log.e(TAG, "getvalue: the username is " + username + "this the password is" + pass);
    }

    void cleartext()
    {
        Log.e(TAG, "cleartext: ");
        editTextUsername.setText("");
        editTextPassword.setText("")
        ;

    }






    @Override
    protected void onStop() {
        super.onStop();

        Log.e(TAG, "onStop: this is onStop ");

//        Toast.makeText(getApplicationContext(),"this is onstop",Toast.LENGTH_SHORT ).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.e(TAG, "onRestart: this is onRestart  ");

   //   Toast.makeText(getApplicationContext(), "this is onrestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.e(TAG, "onStart:  this is onstart ");

      //  Toast.makeText(getApplicationContext(), "this is onstart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.e(TAG, "onPause: this is onpause ");


        //Toast.makeText(getApplicationContext(), "this is onpause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {

        Log.e(TAG, "onDestroy: this is ondestory");

        //Toast.makeText(getApplicationContext(), "this is ondestory", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }


}
