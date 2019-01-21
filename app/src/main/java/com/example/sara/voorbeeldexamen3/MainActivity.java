package com.example.sara.voorbeeldexamen3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Long starttime= 0l;
    private Long endtime=0l;
    private Long differenz=0l;
    private int clicked = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void CountClicks(View view){
        clicked++;
        if(clicked == 1){
            starttime = System.currentTimeMillis();
        }
        if(clicked == 2){
            endtime = System.currentTimeMillis();
            differenz= (endtime-starttime);

        }
    }

    public void BerekenTijd(View view){
        TextView textView = (TextView) findViewById(R.id.txtScore);
        textView.setText(Long.toString(differenz)+ " ms");

        Intent i = new Intent(this, ListHighScore.class);
        i.putExtra("score", differenz);
        startActivity(i);
    }
}
