package com.example.listdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    //기본 리스트 다이얼로그 구성을 위한 문자열 배열
    String [] data1 = {"항목1","항목2","항목3","항목4","항목5","항목6","항목7","항목8",};

    //커스텀 리스트 다이얼로그 구성을 위한 데이터 배열
    String [] data2 = {"토고", "프랑스", "스위스", "스페인", "일본", "독일", "브라질", "대한민국"};
    int [] data3 = {
            R.drawable.image1,R.drawable.image2,R.drawable.image2,R.drawable.image4,
            R.drawable.image5,R.drawable.image6,R.drawable.image7,R.drawable.image8
    };

    TextView text1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = (TextView)findViewById(R.id.textView);

    }

    public void btn1Method(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("리스트 다이얼로그");
        builder.setNegativeButton("취소", null);
        // 리스트 다이얼로그 구성을 위한 문자열 배열을 설정한다.
        Dialog1Listener listener = new Dialog1Listener();
        builder.setItems(data1, listener);
        builder.show();
    }

    class Dialog1Listener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            text1.setText("기본 리스트 다이얼로그 : " + data1[i]);
        }
    }

    public void btn2Method(View view){
        //리스트뷰 구성을 위해 필요한 데이터를 ArrayList에 담는다
        ArrayList<HashMap<String , Object>> list = new ArrayList<HashMap<String,Object>>();

        for(int i = 0; i<data2.length; i++){
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("data2", data2[i]);
            map.put("data3",data3[i]);

            list.add(map);
        }
        String [] keys = {"data2", "data3"};
        int [] ids = {R.id.textView2, R.id.imageView};

        SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.row, keys, ids);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("커스텀 리스트 다이얼로그");

        Dialog2Listener listener = new Dialog2Listener();

        builder.setAdapter(adapter,listener);
        builder.setNegativeButton("취소", null);
        builder.show();

    }

    class Dialog2Listener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            text1.setText("커스텀 리스트 다이얼로그 : " + data2[i]);
        }
    }

}