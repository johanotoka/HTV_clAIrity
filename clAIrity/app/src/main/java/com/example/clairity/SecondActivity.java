package com.example.clairity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
   String text = MainActivity.getText();
    String date = MainActivity.getDate();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView theTextView = (TextView) findViewById(R.id.textView2);
        theTextView.setText(text);
        TextView theTextView2 = (TextView) findViewById(R.id.textView3);
        theTextView2.setText("Date: \n"+date);
    }
}