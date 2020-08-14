package com.example.customlistview1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    String [] data = {
            "데이터1", "데이터2", "데이터3", "데이터4", "데이터5", "데이터6"
    };

    ListView list1;
    TextView text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //뷰의 주소 값을 받아온다.
        list1 = (ListView)findViewById(R.id.list1);
        text2 = (TextView)findViewById(R.id.textView);

        //어뎁터를 생성한다.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.row, R.id.textView, data);
        //어뎁터를 리스트 뷰에 셋팅한다.
        list1.setAdapter(adapter);
        //문자열 하나만 셋팅할 경우에는 ArrayAdapter를 사용한다.

        //리스너 셋팅
        ListListener listener = new ListListener();
        list1.setOnItemClickListener(listener);

    }
    //리스트뷰의 리스너
    class ListListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            text2.setText(data[i]);
        }
    }
}