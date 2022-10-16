package com.example.clairity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class SecondActivity extends AppCompatActivity {
   String text = MainActivity.getText();
    String date = MainActivity.getDate();
    Button back;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        back = findViewById(R.id.Return);
        File imgfile = new File("/data/data/com.example.clairity/filesimage.jpg");
        if(imgfile.exists()){
            Bitmap myBitmap = BitmapFactory.decodeFile(imgfile.getAbsolutePath());
            ImageView myImage = (ImageView) findViewById(R.id.imageView2);
            myImage.setImageBitmap(myBitmap);
        }

        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick( View view){


                Intent intent_one = new Intent (SecondActivity.this,MainActivity.class);

                startActivity(intent_one);
            }
        });

        TextView theTextView = (TextView) findViewById(R.id.textView2);
        theTextView.setText(text);
        TextView theTextView2 = (TextView) findViewById(R.id.textView3);
        theTextView2.setText("Date: \n"+date);
    }
}