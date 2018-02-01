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

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private String TAG = SecondActivity.class.getSimpleName();
    private Button ButtonSubmit;
    private EditText LastName;
    private TextView dispalyname;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initControl();
        dispalyDataFromFirstActivity();


        context = SecondActivity.this;
    }

    private void initControl() {
        Log.e(TAG, "initControl: ");
        LastName = findViewById(R.id.editTextLastName);
        ButtonSubmit = findViewById(R.id.buttonSubmit);
        dispalyname = findViewById(R.id.textViewFirstName);
        ButtonSubmit.setOnClickListener(this);
    }

    private void dispalyDataFromFirstActivity() {
        Log.e(TAG, "dispalyDataFromFirstActivity: ");
        Intent intent = new Intent(SecondActivity.this, MainActivity.class);
        Log.e(TAG, "dispalyDataFromFirstActivity: ");
        dispalyname.setText(getIntent().getStringExtra("FirstName"));
    }

    @Override
    public void onClick(View v) {

        Log.e(TAG, "onClick: ");
        if (validation()) {
            goToThirdActivity();
        }
    }

    private void goToThirdActivity() {
        Intent intent=new Intent(SecondActivity.this,ThirdActivity.class);

        intent.putExtra("LastName",LastName.getText().toString());
        intent.putExtra("FirstName",dispalyname.getText().toString());
        startActivityForResult(intent,587);
//       startActivity(intent);
        //        setResult(129,intent);
      // finish();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e(TAG, "onActivityReenter: Second activity ");
        if(resultCode==678 && requestCode==587 && data!=null)
        {
            Log.e(TAG, "onActivityResult:under if"+data.getStringExtra("FirstName") + data.getStringExtra("LastName") + data.getStringExtra("city"));

            Intent intent=new Intent();
            intent.putExtra("FirstName",data.getStringExtra("FirstName"));
            intent.putExtra("LastName",data.getStringExtra("LastName"));
            intent.putExtra("city",data.getStringExtra("city"));
            setResult(555,intent);
            finish();
        }

    }


    private boolean validation() {
        Log.e(TAG, "validation: ");
        if (LastName.getText().toString().isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
            return false;
        }
        else
            return true;
    }
}
