package com.example.clairity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;

public class MainActivity extends AppCompatActivity {

    Button submit;
    Button clear;
    Button memory;
    public static ArrayList<ArrayList<String>> MainList= new ArrayList<ArrayList<String>>();
    static int num = 0;
    static String text;
    static String date;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit = findViewById(R.id.Submit);

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                text =  ((EditText) findViewById(R.id.dream)).getText().toString();
                date = ((EditText) findViewById(R.id.Date)).getText().toString();

                ArrayList<String> list = new ArrayList<String>();
                String log = num +"";
                list.add(log);
                num++;
                list.add(text);
                list.add(date);
                MainList.add(list);
                list = new ArrayList<String>();

                // Call Python script
                Python py = Python.getInstance();
                PyObject apicall = py.getModule("api_call");
                try {
                    PyObject call = apicall.callAttrThrows("main", text);
                } catch (Throwable e) {
                    e.printStackTrace();
                }
                
                // Change activity
                Intent intent_one = new Intent (MainActivity.this,SecondActivity.class);
                Context context = getApplicationContext();
                CharSequence msg = "Please take a screenshot:)";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context,msg,duration);
                toast.show();
                startActivity(intent_one);
            }
        });
        memory = findViewById(R.id.Memory);

        memory.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick( View view){


                Intent intent_one = new Intent (MainActivity.this,ThirdActivity.class);

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