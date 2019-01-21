package com.example.sara.voorbeeldexamen3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListHighScore extends AppCompatActivity {

    ListView SimpleList;
    public static final UserHighscore[] HIGH_SCORES = new UserHighscore[] {
            new UserHighscore("LGI", 2L),
            new UserHighscore("RTH", 5L),
            new UserHighscore("JDR", 11L),
            new UserHighscore("KVE", 45L),
            new UserHighscore("WST", 76L),
            new UserHighscore("JFR", 103L),
            new UserHighscore("KOV", 502L)
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_high_score);

        Bundle b = getIntent().getExtras();
        long score = b.getLong("score");

//        TextView textView = (TextView) findViewById(R.id.txtHighScore);
//        textView.setText(Long.toString(score)+ " ms");

        ArrayList<Map<String, String>> list = buildData();
//        String[] from = { "username", "score" };
//        int[] to = { android.R.id.text1, android.R.id.text2 };
        String[] from = { "fullLine" };
        int[] to = { android.R.id.text1 };

         SimpleList= (ListView) findViewById(R.id.List);
            ArrayList<Map<String,String>> arrayList = new ArrayList<>();

        SimpleAdapter adapter = new SimpleAdapter(this, list,
                android.R.layout.simple_list_item_2, from,to);


        SimpleList.setAdapter(adapter);

    }
    private ArrayList<Map<String, String>> buildData() {
        ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
        for (int i =0; i<7; i++){

            list.add(putData(HIGH_SCORES[i].getUsername(), Long.toString(HIGH_SCORES[i].getScore()),HIGH_SCORES[i].getFullLine()));
        }
        return list;
    }

    private HashMap<String, String> putData(String username, String score, String fullLine) {
        HashMap<String, String> item = new HashMap<String, String>();
        item.put("username", username);
        item.put("score", score);
        item.put("fullLine", fullLine);
        return item;
    }
}
