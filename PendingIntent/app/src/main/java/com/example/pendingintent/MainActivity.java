package com.example.pendingintent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn1Method(View view){
        NotificationCompat.Builder builder = getNotificationBuilder("pending", "pending intent");
        builder.setContentTitle("notification 1");
        builder.setContentText("알림 메시지 1입니다.");
        builder.setSmallIcon(android.R.drawable.ic_menu_camera);
        builder.setAutoCancel(true);

        //메시지를 터치하면 실행될 Activity 정보를 관리할 객체를 생성한다.
        Intent intent1 = new Intent(this, Test1Activity.class);
        //실행될 Activity에 전달할 데이터를 셋팅한다.
        intent1.putExtra("data1", "문자열 데이터1");
        intent1.putExtra("data2", 100);

        //추가 액션을 설정한다.
        Intent intent2 = new Intent(this, Test2Activity.class);
        PendingIntent pending2 = PendingIntent.getActivity(this, 100, intent2, PendingIntent.FLAG_UPDATE_CURRENT);
        //액션 생성을 위한 빌더 객체 생성
        NotificationCompat.Action.Builder builder2 = new NotificationCompat.Action.Builder(android.R.drawable.ic_menu_compass,"Action 1", pending2);
        NotificationCompat.Action action2 = builder2.build();
        builder.addAction(action2);

        //Intent 객체를 관리할 PendingIntent 객체를 생성하여 셋팅한다.
        PendingIntent pending1 = PendingIntent.getActivity(this, 10, intent1, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pending1);

        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.notify(10, notification);

    }
    public void btn2Method(View view){
        NotificationCompat.Builder builder = getNotificationBuilder("pending", "pending intent");
        builder.setContentTitle("notification 2");
        builder.setContentText("알림 메시지 2입니다.");
        builder.setSmallIcon(android.R.drawable.ic_menu_camera);
        builder.setAutoCancel(true);

        //메시지를 터치하면 실행될 Activity 정보를 관리할 객체를 생성한다.
        Intent intent1 = new Intent(this, Test2Activity.class);

        //Intent 객체를 관리할 PendingIntent 객체를 생성하여 셋팅한다.
        PendingIntent pending1 = PendingIntent.getActivity(this, 10, intent1, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pending1);

        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.notify(20, notification);

    }


    public NotificationCompat.Builder getNotificationBuilder(String id, String name){
        NotificationCompat.Builder builder = null;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            NotificationChannel channel = new NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH);
            channel.enableLights(true);
            channel.setLightColor(Color.RED);
            channel.enableVibration(true);
            manager.createNotificationChannel(channel);

            builder = new NotificationCompat.Builder(this, id);
        }
        else {
            builder = new NotificationCompat.Builder(this);
        }
        return builder;
    }
}