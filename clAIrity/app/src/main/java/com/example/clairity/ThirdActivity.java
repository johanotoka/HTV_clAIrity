package com.example.clairity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {
 Button finder;
 static String date2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        finder = findViewById(R.id.Finder);

        finder.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick( View view){

                date2 = ((EditText) findViewById(R.id.Date2)).getText().toString();

                Intent intent_one = new Intent (ThirdActivity.this,FourthActivity.class);
                Context context = getApplicationContext();
                CharSequence msg = "Please take a screenshot:)";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context,msg,duration);
                toast.show();
                startActivity(intent_one);
            }
        });
    }
    public static String getDate2(){
        return date2;
    }
}