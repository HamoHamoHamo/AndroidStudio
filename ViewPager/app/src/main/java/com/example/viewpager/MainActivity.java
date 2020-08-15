package com.example.viewpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager2 pager1;
    TextView text1;
    //ViewPager를 통해서 보여줄 View 객체를 가지고 있는 ArrayList
    ArrayList<View> viewList = new ArrayList<View>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView)findViewById(R.id.textView);
        pager1 = (ViewPager2)findViewById(R.id.pager);

        //View 객체를 생성하여 ArrayList에 담는다.
        LayoutInflater inflater = getLayoutInflater();
        View v1 = inflater.inflate(R.layout.view1,null);
        View v2 = inflater.inflate(R.layout.view2,null);
        View v3 = inflater.inflate(R.layout.view3,null);

        viewList.add(v1);
        viewList.add(v2);
        viewList.add(v3);

        CustomAdapter adapter = new CustomAdapter();
        pager1.setAdapter(adapter);


    }

    class CustomAdapter extends PagerAdapter{
        @Override
        // 뷰 페이저를 통해서 보여줄 항목의 개수
        public int getCount() {
            return viewList.size();
        }
        //뷰 페이저를 통해 보여줄 뷰 객체를 반환한다.


        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            //position 번째 뷰 객체를 뷰 페이저에 셋팅한다.
            pager1.addView(viewList.get(position));
            return viewList.get(position);
        }

        // InstantiateItem 메서드에서 반환한 뷰 객체를 사용할 것인가를 결정하는 메서드
        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }
        //뷰가 제거될 떄 호출되는 메서드


        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            pager1.removeView((View)object);
        }
    }

}