package com.example.displayhandler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1, text2;
    //쓰래드의 무한 루프를 종료하기 위한 변수

    boolean isRunning = false;
    // 일반 쓰래드에서 요청한 화면처리용 핸들러
    DisplayHandler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView)findViewById(R.id.textView);
        text2 = (TextView)findViewById(R.id.textView2);

        handler = new DisplayHandler();

                                                    // 오랜 시간이 걸리는 작업을 가정한다.
                                            //        while(true){
                                            //            SystemClock.sleep(100);
                                            //            long now = System.currentTimeMillis();
                                            //            text2.setText("오래 걸리는 작업 : " + now);
                                            //
                                            //        }
        isRunning = true;
        ThreadClass thread = new ThreadClass();
        thread.start();
    }

    public void btnMethod(View view){
        long now = System.currentTimeMillis();
        text1.setText("버튼 클릭 : " + now);
    }

    class ThreadClass extends Thread{
        @Override
        public void run() {
            int a1 = 10;
            int a2 = 20;
            while(isRunning){
                SystemClock.sleep(100);
                long now = System.currentTimeMillis();
                Log.d("teset", "오래 걸리는 작업 : " + now);
                // 안드로이드7버전 이하에서 튕김
                //text2.setText("오래 걸리는 작업 : " + now);
                SystemClock.sleep(100);
                handler.sendEmptyMessage(0);
                SystemClock.sleep(100);
                handler.sendEmptyMessage(1);
                //핸들러 요청을 할 떄 화면 처리를 위한 데이터를 전달한다.
                SystemClock.sleep(100);
                Message msg = new Message();
                msg.what = 2;
                msg.arg1 = ++a1;    //정수값
                msg.arg2 = ++a2;    //정수값
                msg.obj = now;

                handler.sendMessage(msg);

            }
        }
    }

    class DisplayHandler extends Handler{
        //개발자가 발생시킨 쓰래드에서 화면에 관련된 처리를 하기 위해 작업을 요청하면
        // 자동으로 호출되는 매서드(메인 쓰레드)

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            //what 값으로 분기한다.
            switch (msg.what){
                case 0:
                    text2.setText("핸들러 작업1");
                    break;
                case 1:
                    text2.setText("핸들러 작업2");
                    break;
                case 2:
                    text2.setText(msg.arg1 + "," + msg.arg2 + "," + msg.obj);
            }

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isRunning=false;
    }
}