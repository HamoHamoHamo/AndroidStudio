package com.example.tread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import javax.xml.transform.sax.TransformerHandler;


public class MainActivity extends AppCompatActivity {

    TextView text1, text2;
    //쓰래드 동작 여부를 컨트롤할 변수
    Boolean isRunning = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView)findViewById(R.id.textView);
        text2 = (TextView)findViewById(R.id.textView2);
        // 100 ms 마다 현재 시간을 가져와서 출력한다.
/*
        while(true){
            SystemClock.sleep(100);
            long now = System.currentTimeMillis();
            text2.setText("무한루프 : " + now);

        }
        */
        //오래 걸리는 작업 처리를 위해 쓰래드를 발생시킨다.
        isRunning = true;
        ThreadClass thread = new ThreadClass();
        thread.start();
    }

    public void btnMethod(View view){
        //현재 시간 값을 ms로 가져온다.
        long now = System.currentTimeMillis();
        //출력한다.
        text1.setText("버튼 클릭 : " + now);
    }

    //쓰래드 클래스
    class ThreadClass extends Thread{
        @Override
        public void run() {
            while(isRunning){
                SystemClock.sleep(100);
                long now = System.currentTimeMillis();
                Log.d("test","스래드 : " + now);
                text2.setText("쓰래드 : " + now);
            }

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //쓰래드 종료를 위해 false 값을 넣어준다.
        isRunning = false;
    }
}