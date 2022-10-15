package com.example.clairity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button submit;
    Button clear;

    static String text;
    static String date;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit = findViewById(R.id.Submit);

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick( View view){
             text =  ((EditText) findViewById(R.id.dream)).getText().toString();
                date = ((EditText) findViewById(R.id.Date)).getText().toString();

                Intent intent_one = new Intent (MainActivity.this,SecondActivity.class);

                startActivity(intent_one);
            }
        });



        clear = findViewById(R.id.Clear);

        clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick( View view){
                ((EditText)findViewById(R.id.dream)).setText("");
                ((EditText)findViewById(R.id.Date)).setText("");
            }
        });

    }
    public static String getText(){
        return text;
    }
    public static String getDate(){
        return date;
    }

}