package com.example.intentmodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class success extends AppCompatActivity {

    private TextView textView2;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        intcontrol();

        getvaluefromintent();
    }

    private void getvaluefromintent() {

       String name=getIntent().getExtras().getString("Myname");
       String user=getIntent().getExtras().getString("Myusername");

       textView.setText(name);
       textView2.setText(user);
    }

    private void intcontrol() {

        textView=findViewById(R.id.textView);
        textView2=findViewById(R.id.textView2);
    }
}
