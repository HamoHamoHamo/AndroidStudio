package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    // 뷰의 주소값을 담을 참조 변수 선언
    TextView text1;


    // Activity 생성될때 자동 호출
    // 화면 회전 발생했을때 자동 호출
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("test","onCreate 호출");

        // id 속성이 text2인 뷰의 주소 값을 얻어온다
        text1 = (TextView)findViewById(R.id.text2);
        //새로운 문자열을 설정
        text1.setText("새로운 문자열");

    }

    @Override
    //onCreate 메서드 호출 이후에 자동으로 호출
    //Activity가 정지상태가 되었다가 활동상태로 돌아올 떄 호출
    protected void onStart() {
        super.onStart();

        Log.d("test","onStart 호출");
    }


    //onStart 메서디가 호출된 이후에 자동으로 호출
    // Activity 일시 정지 되엇다가 다시 돌아올떄 호출
    @Override
    protected void onResume(){
        super.onResume();

        Log.d("test","onResume 호출");

    }

    // Activity 정지상태 되었다가 활동 상태로 돌아갈 때 onStart메서드 전에 호출
    @Override
    protected void onRestart(){
        super.onRestart();

        Log.d("test","onRestart 호출");
    }

    // Activity가 일시 정지 상태일때 호출
    // 화면상에서 완전히 사라지거나 현재 화면위에 작은 팝업창 같은것 나타날때 호출
    @Override
    protected void onPause() {
        super.onPause();

        Log.d("test","onPause 호출");
    }

    //Activity가 화면에서 사라질떄 호출
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("test","onStop 호출");
    }

    //현재 액티비티의 수행이 완전히 종료되어 메모리상에서 제거될때 호출
    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("test","onDestroy 호출");
    }
}