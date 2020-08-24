package com.example.app1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1;

    final int SECOND_ACTIVITY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = (TextView)findViewById(R.id.textView);
    }

    public void btnMethod(View view){
        //다른 애플리케이션의 이름을 셋팅한 intent 객체를 생성한다.
        Intent intent = new Intent("com.test.second");

        intent.putExtra("data1", 100);
        intent.putExtra("data2", 11.11);

        startActivityForResult(intent, SECOND_ACTIVITY);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == SECOND_ACTIVITY){
            if(resultCode == RESULT_OK){
                int value1 = data.getIntExtra("value1", 0);
                double value2 = data.getDoubleExtra("value2", 0.0);

                text1.append("\n" + "value1 : " + value1 + "\n");
                text1.append("value2 : " + value2);
            }
        }
    }
}