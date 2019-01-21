package com.example.sara.voorbeeldexamen3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MyHighscore extends AppCompatActivity {

    private Long Highscore = Long.MAX_VALUE;
    private String filename ="highscore.txt";
    private long score = 0L;


    // private ImageButton btn = null;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_highscore);

        LeesHighscore();
        Bundle b = getIntent().getExtras();
        score = b.getLong("score");

        if(IsNieuweHighscore() == true)
            SchrijfHighscore();

        TextView textView = (TextView) findViewById(R.id.txtScore);
        textView.setText(Long.toString(score)+ " ms");

        //image button
//        Object o = findViewById(R.id.btnImage);
//        btn = (ImageButton) findViewById(R.id.imageButton);
//        btn.setOnClickListener(imgButtonHandler);


    }

//    View.OnClickListener imgButtonHandler = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            btn.setImageResource(R.drawable.dog);
//        }
//    };

    public void sendSMS(View v)
    {


        Uri uri = Uri.parse("smsto:12346556");
        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
        it.putExtra("sms_body", "Highscore is "+Long.toString(score)+ " ms" );
        startActivity(it);
    }

    private void LeesHighscore(){
        FileInputStream fileInputStream;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            fileInputStream = openFileInput(filename);

            int len;
            while ((len = fileInputStream.read()) != -1) {
                stringBuffer.append((char)len);
            }
            Highscore = Long.parseLong(stringBuffer.toString());
            fileInputStream.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    private void SchrijfHighscore(){
        FileOutputStream outputStream;
        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);

            outputStream.write(Long.toString(Highscore).getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean IsNieuweHighscore() {
        if (score < Highscore) {
            Highscore = score;
            return true;
        }
        else
            return false;
    }

}

