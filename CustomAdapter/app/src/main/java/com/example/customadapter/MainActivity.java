package com.example.customadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    // 리스트 항목에 설정한 문자열 배열
    String [] data = {"데이터1","데이터2","데이터3","데이터4","데이터5","데이터6"};


    ListView list1;
    TextView text1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list1 = (ListView)findViewById(R.id.list1);
        text1 = (TextView)findViewById(R.id.textView2);

        //어뎁터를 셋팅해준다.
        ListAdapter adapter = new ListAdapter();
        list1.setAdapter(adapter);



    }

    class ListAdapter extends BaseAdapter{

        BtnListener listener = new BtnListener();

        @Override
        //리스트뷰의 항목 개수를 반환하는 메서드
        public int getCount() {
            return data.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            // 재사용 가능한 뷰가 없다면 뷰를 만들어준다
            if(view == null){
                LayoutInflater inflater = getLayoutInflater();
                view = inflater.inflate(R.layout.row, null);
            }
            // 뷰를 구성한다.
            TextView sub_text = (TextView)view.findViewById(R.id.textView);
            Button sub_btn1 = (Button)view.findViewById(R.id.button);
            Button sub_btn2 = (Button)view.findViewById(R.id.button2);

            sub_btn1.setOnClickListener(listener);
            sub_btn2.setOnClickListener(listener);

            //뷰에 인덱스 값을 저장한다.
            sub_btn1.setTag(i);
            sub_btn2.setTag(i);

            sub_text.setText(data[i]);
            // 뷰를 반환한다.
            return view;
        }
    }

    //항목에 배치된 버튼에 셋팅할 리스너
    class BtnListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            //버튼의 아이디를 추출한다.
            int id = view.getId();

            //리스트의 인덱스 값을 추출한다.
            int position = (Integer)view.getTag();

            switch (id){
                case R.id.button:
                    text1.setText("첫번째 버튼 누름 : " + position);
                    break;
                case R.id.button2:
                    text1.setText("두번쨰 버튼 누름 : " + position);
                    break;
            }
        }
    }

}