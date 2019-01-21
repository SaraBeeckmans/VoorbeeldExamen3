package com.example.sara.voorbeeldexamen3;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
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

    //notificaties
    private static final String PRIMARY_CHANNEL_ID = "primary_notification_channel";
    private NotificationManager mNotifyManager;
    private static final int NOTIFICATION_ID = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        createNotificationChannel();

    }

    public void CountClicks(View view){
        clicked++;
        if(clicked == 1){
            starttime = System.currentTimeMillis();
        }
        if(clicked == 2){
            endtime = System.currentTimeMillis();
            differenz= (endtime-starttime);
            sendNotification();
            clicked=0;

        }
    }

    public void BerekenTijd(View view){
        TextView textView = (TextView) findViewById(R.id.txtScore);
        textView.setText(Long.toString(differenz)+ " ms");

        Intent i = new Intent(this, MyHighscore.class);
        i.putExtra("score", differenz);
        startActivity(i);
    }

    public void onclick(View view){
        Intent i = new Intent(this, ListHighScore.class);
        startActivity(i);
    }

    public void createNotificationChannel()
    {
        mNotifyManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >=
                android.os.Build.VERSION_CODES.O) {
            // Create a NotificationChannel
            NotificationChannel notificationChannel = new NotificationChannel(PRIMARY_CHANNEL_ID,
                    "Mascot Notification", NotificationManager
                    .IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription("Notification");
            mNotifyManager.createNotificationChannel(notificationChannel);
        }
    }

    private NotificationCompat.Builder getNotificationBuilder(){

        NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(this, PRIMARY_CHANNEL_ID)
                .setContentTitle("New score")
                .setContentText("Je nieuwe score is: "+ Long.toString(differenz)+ " ms")
                .setSmallIcon(R.drawable.ic_launcher_foreground);
        return notifyBuilder;

    }

    public void sendNotification() {
        getNotificationBuilder();
        NotificationCompat.Builder notifyBuilder = getNotificationBuilder();
        mNotifyManager.notify(NOTIFICATION_ID, notifyBuilder.build());
    }

}
