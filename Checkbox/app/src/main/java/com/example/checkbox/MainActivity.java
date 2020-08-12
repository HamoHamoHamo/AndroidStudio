package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView text1;
    CheckBox check1, check2, check3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView)findViewById(R.id.textView);
        check1 = (CheckBox)findViewById(R.id.checkBox);
        check2 = (CheckBox)findViewById(R.id.checkBox2);
        check3 = (CheckBox)findViewById(R.id.checkBox3);

        //체크박스에 리스너를 설정한다.
        CheckBoxListener listener = new CheckBoxListener();
        check1.setOnCheckedChangeListener(listener);
        check2.setOnCheckedChangeListener(listener);
        check3.setOnCheckedChangeListener(listener);
    }

    //첫 번쨰 버튼을 누르면 호출되는 메서드
    //체크 상태값 파악

    public void btn1Method(View view){
        text1.setText("");

        //체크 상태에 따라 필요한 처리를 해준다.
        boolean a1 = check1.isChecked();
        boolean a2 = check2.isChecked();
        boolean a3 = check3.isChecked();

        if(a1 == true){
            text1.append("첫 번째 체크 박스 체크 ㅇ\n");
        }
        if(a2 == true){
            text1.append("두 번째 체크 박스 체크 ㅇ\n");
        }
        if(a3 == true){
            text1.append("세 번째 체크 박스 체크 ㅇ\n");
        }

    }

    //두 번째 버튼과 연결된 메서드
    //모든 체크박스의 상태를 체크로 설정
    public void btn2Method(View view){
        check1.setChecked(true);
        check2.setChecked(true);
        check3.setChecked(true);
    }

    // 세 번쨰 버튼과 연결된 메서드
    // 모든 체크박스의 상태를 체크 해제

    public void btn3Method(View view){
        check1.setChecked(false);
        check2.setChecked(false);
        check3.setChecked(false);
    }

    //네 번쨰 버튼과 연결된 메서드
    // 모든 체크박스 상태 반전
    public void btn4Method(View view){
        check1.toggle();
        check2.toggle();
        check3.toggle();
    }

    //체크박스 체크상태 변경되면 반응하는 리스너
    class CheckBoxListener implements CompoundButton.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            //체크 상태가 변경된 체크박스의 id를 가져온다.
            int id = compoundButton.getId();
            //아이디 값으로 분기
            switch (id){
                case R.id.checkBox:
                    if(b==true){
                        text1.setText("첫 번쨰 체크 박스 체크");
                    }
                    else{
                        text1.setText("첫 번째 체크 박스 해제");
                    }
                    break;
                case R.id.checkBox2:
                    if(b==true){
                        text1.setText("두 번쨰 체크 박스 체크");
                    }
                    else{
                        text1.setText("두 번째 체크 박스 해제");
                    }
                break;
                case R.id.checkBox3:
                    if(b==true){
                        text1.setText("세 번쨰 체크 박스 체크");
                    }
                    else{
                        text1.setText("세 번째 체크 박스 헤제");
                    }

                    break;
            }

        }
    }

}