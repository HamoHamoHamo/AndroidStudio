package com.example.brapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnMethod(View view) {
        //명시적 인텐트
//        Intent intent = new Intent();
//        intent.setClassName("com.example.brapp1","com.example.brapp1.TestReceiver");
//        sendBroadcast(intent);

        // 암시적 인텐트
        Intent intent = new Intent("com.example.testbr");
        sendBroadcast(intent);
    }
}