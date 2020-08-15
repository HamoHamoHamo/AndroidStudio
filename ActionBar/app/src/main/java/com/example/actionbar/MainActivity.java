package com.example.actionbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView text1, text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView)findViewById(R.id.textView);
        text2 = (TextView)findViewById(R.id.textView2);

    }

    //옵션 메뉴 구성을 위해 호출하는 메서드


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        //검색 뷰가 설정되어 있는 메뉴 항목 객체를 추출한다.
        MenuItem search_item = menu.findItem(R.id.item5);
        //액션뷰로 설정된 뷰를 추출한다.
        androidx.appcompat.widget.SearchView search_view = (SearchView) search_item.getActionView();

        // 안내 문구 설정
        search_view.setQueryHint("검색어를 입력해주세요");
        //서치뷰에 리스너를 설정한다.
        SearchViewListener listener = new SearchViewListener();
        search_view.setOnQueryTextListener(listener);

        return true;
    }
    //서치 뷰의 리스너를 설정한다.
    class SearchViewListener implements SearchView.OnQueryTextListener{
        @Override
        //서치 뷰의 문자열이 변경될때 마다 호출되는 메서드
        public boolean onQueryTextChange(String newText) {
            text1.setText(newText);
            return false;
        }

        @Override
        //키보드의 엔터 키를 누르면 호출되는 메서드
        public boolean onQueryTextSubmit(String query) {
            text2.setText(query);
            return false;
        }
    }

    //옵션 메뉴의 항목을 터치하면 호출되는 메서드
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //사용자가 선택한 메뉴 항목의 아이디를 추출한다.
        int id = item.getItemId();

        switch(id){
            case R.id.item1:
                text1.setText("메뉴 1을 선택했습니다.");
                break;
            case R.id.item2:
                text1.setText("메뉴 2을 선택했습니다.");
                break;
            case R.id.item3:
                text1.setText("메뉴 3을 선택했습니다.");
                break;
            case R.id.item4:
                text1.setText("메뉴 4을 선택했습니다.");
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}