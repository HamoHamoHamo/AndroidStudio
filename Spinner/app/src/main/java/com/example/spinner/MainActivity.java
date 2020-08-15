package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //스피너 구성을 위한 문자열 배열
    String [] data1 = {"스피너1","스피너2","스피너3","스피너4","스피너5"};

    Spinner spin1;
    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spin1 = (Spinner)findViewById(R.id.spinner);
        text1 = (TextView)findViewById(R.id.textView);

        //어뎁터를 생성한다.
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,data1);
        //드롭다운으로 나타나는 항목 리스트의 뷰
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //어뎁터를 스피너에 적용한다.
        spin1.setAdapter(adapter1);

        SpinnerLIstener listener = new SpinnerLIstener();
        spin1.setOnItemSelectedListener(listener);

    }

    public void btnMethod(View view){
        //현재 스피너에 선택되어 있는 항목의 인덱스 값을 추출한다.
        int index = spin1.getSelectedItemPosition();
        text1.setText("선택된 항목 : " + data1[index]);
    }

    class SpinnerLIstener implements AdapterView.OnItemSelectedListener{
        @Override
        // 사용자가 항목을 선택했을 때 호출되는 메서드
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            text1.setText(data1[i]);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }

}