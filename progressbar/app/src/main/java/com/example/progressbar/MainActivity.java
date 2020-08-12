package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1;
    Button button1, button2, button3, button4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView)findViewById(R.id.textView);
        button1= (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);

        BtnListener1 listener1 = new BtnListener1();
        BtnListener2 listener2 = new BtnListener2();
        BtnListener34 listener34 = new BtnListener34();

        button1.setOnClickListener(listener1);
        button2.setOnClickListener(listener2);
        button3.setOnClickListener(listener34);
        button4.setOnClickListener(listener34);

    }

    //첫번쨰 버튼과 연결된 리스너
    class BtnListener1 implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            text1.setText("첫 번째 버튼");
        }
    }
    //두번쨰 버튼과 연결된 리스너
    class BtnListener2 implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            text1.setText("두번째 버튼 누름");
        }
    }
    //  네번째, 세번쨰 버튼과 연결된 리스너
    class BtnListener34 implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            //이벤트가 발생된 뷰의 ID값을 추출한다.
            int id= view.getId();
            // id로 분기한다.
            switch (id){
                case R.id.button3 :
                    text1.setText("세번째 버튼 누름");
                    break;
                case R.id.button4 :
                    text1.setText("네번째 버튼 누름");
                    break;

            }

        }
    }

    //다섯 번쨰 버튼을 누르면 호출되는 메서드
    public void btn5Method(View view){
        text1.setText("다섯번째 버튼 누름");
    }
    //여섯 번쨰 버튼을 누르면 호출되는 메서드
    public void btn6Method(View view){
        text1.setText("여섯번째 버튼 누름");
    }
    // 일곱, 여덟 번쨰 버튼 누르면 호출되는 메서드
    public void btn78Method(View view){
        //아이디 값 추출
        int id = view.getId();
        switch(id) {
            case R.id.button7:
                text1.setText("일곱번째 버튼 누름");
                break;
            case R.id.button8:
                text1.setText("여덟번째 버튼 누름");
                break;
        }

    }



}