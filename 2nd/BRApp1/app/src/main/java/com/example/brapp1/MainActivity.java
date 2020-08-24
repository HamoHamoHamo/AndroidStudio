package com.example.brapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //브로드캐스트 리시버 객체의 주소 값을 담을 참조 변수
    TestReceiver br;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //안드로이드 8.0 이상이면 암시적 인텐트를 코드로 등록한다.
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            br = new TestReceiver();
            IntentFilter filter = new IntentFilter("com.example.testbr");
            registerReceiver(br,filter);

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            if (br !=null){
                unregisterReceiver(br);
                br = null;
            }
        }
    }
}