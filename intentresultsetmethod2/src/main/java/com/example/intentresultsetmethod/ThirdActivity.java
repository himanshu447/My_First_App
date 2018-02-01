package com.example.intentresultsetmethod;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {

    Context context;
    private TextView firstlastname;
    private EditText city;
    private Button buttonsubmit;
    private String TAG = ThirdActivity.class.getSimpleName();
    private String firstname, lastname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        context = ThirdActivity.this;
        intiControl();
        dispalyDataFromFrist2Activity();
        Log.e(TAG, "onCreate:" + getIntent().getStringExtra("FirstName"));
    }

    private void dispalyDataFromFrist2Activity() {
        Intent intent = new Intent();
        firstname = getIntent().getStringExtra("FirstName");
        lastname = getIntent().getStringExtra("LastName");
        firstlastname.setText("Hello " + firstname + lastname);
    }

    private void intiControl() {
        firstlastname = findViewById(R.id.textViewFirstLastName);
        city = findViewById(R.id.editTextCity);
        buttonsubmit = findViewById(R.id.buttonSubmit);
        buttonsubmit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (Validation()) {

            goToFirstActivity();
        }
    }

    private void goToFirstActivity() {
        Log.e(TAG, "goToFirstActivity: ");
        Intent intent = new Intent();
        intent.putExtra("FirstName", firstname);
        intent.putExtra("LastName", lastname);
        intent.putExtra("city", city.getText().toString());
        setResult(678, intent);
        finish();
    }

    private boolean Validation() {
        if (city.getText().toString().isEmpty()) {
            Toast.makeText(context, "This is an Error", Toast.LENGTH_SHORT).show();
            return false;
        } else
            return true;
    }
}
