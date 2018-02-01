package com.example.intentresultsetmethod;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private EditText firstname;
    private Button buttonsubmit;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;

        initControl();

    }

    private void initControl() {
        Log.e(TAG, "initControl: ");
        firstname = findViewById(R.id.editTextFirstName);
        buttonsubmit = findViewById(R.id.buttonSubmit);
        buttonsubmit.setOnClickListener(this);

    }

    @Override

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonSubmit:
                if (validation()) {
                    Log.e(TAG, "validation: true");

                    goToSecondActivity();
                }
                break;
        }
    }

    private boolean validation() {
        Log.e(TAG, "validation: ");
        if (firstname.getText().toString().isEmpty()) {
            firstname.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    private void goToSecondActivity() {
        Log.e(TAG, "goToSecondActivity: ");
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("FirstName", firstname.getText().toString());
        startActivityForResult(intent, 123);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e(TAG, "onActivityResult: first main ");
            if (requestCode == 123 && resultCode == 129 && data != null) {

                firstname.setText(firstname.getText().toString() + data.getStringExtra("LastName") );

        }
        else if (requestCode==123 && resultCode==555 && data!=null)
            {
                firstname.setText("Your Fist Name is ' "+data.getStringExtra("FirstName")+ " ' Last Name is ' " + data.getStringExtra("LastName") + " ' City is ' " + data.getStringExtra("city"));
            }
    }
}
