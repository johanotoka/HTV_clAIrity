package com.example.clairity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FourthActivity extends AppCompatActivity {
    String date3 = ThirdActivity.getDate2();
    Button back2;
    int dt;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        back2 = findViewById(R.id.Back);
        for(int i=0;i<MainActivity.MainList.size();i++){
            if(MainActivity.MainList.get(i).get(2).equals(date3)){
                dt=i;
            }

        }

        back2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick( View view){


                Intent intent_one = new Intent (FourthActivity.this,MainActivity.class);

                startActivity(intent_one);
            }
        });


         TextView theTextView3 = (TextView) findViewById(R.id.Date4);
        TextView theTextView4 = (TextView) findViewById(R.id.textView6);
        theTextView4.setText(MainActivity.MainList.get(dt).get(1));
        theTextView3.setText("Date: \n"+date3);
    }
}