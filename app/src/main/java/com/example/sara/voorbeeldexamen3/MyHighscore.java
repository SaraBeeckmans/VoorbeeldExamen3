package com.example.sara.voorbeeldexamen3;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MyHighscore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_highscore);

        Bundle b = getIntent().getExtras();
        long score = b.getLong("score");

        TextView textView = (TextView) findViewById(R.id.txtScore);
        textView.setText(Long.toString(score)+ " ms");

    }

    public void sendSMS(View v)
    {
        Bundle b = getIntent().getExtras();
        long score = b.getLong("score");

        Uri uri = Uri.parse("smsto:12346556");
        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
        it.putExtra("sms_body", "Highscore is "+Long.toString(score)+ " ms" );
        startActivity(it);
    }
}
