package com.example.popupmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView)findViewById(R.id.textView);

    }

    public void btnMethod(View view){
        //PopupMenu 객체를 생성한다.
        PopupMenu pop = new PopupMenu(this, text1);
        //PopupMenu의 메뉴를 관리하는 객체를 추출한다.
        Menu menu = pop.getMenu();
        //메뉴를 구성한다.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.popup_menu, menu);
        //팝업 메뉴의 리스너를 설정한다.
        PopupListener listener = new PopupListener();
        pop.setOnMenuItemClickListener(listener);

        //메뉴를 나타나게 한다.
        pop.show();
    }

    class PopupListener implements PopupMenu.OnMenuItemClickListener{
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            //사용자가 선택한 메뉴의 id값을 추출한다.
            int id = menuItem.getItemId();

            switch (id){
                case R.id.item1:
                    text1.setText("메뉴 1을 선택했습니다.");
                    break;
                case R.id.item2:
                    text1.setText("메뉴 2을 선택했습니다.");
                    break;
                case R.id.item3:
                    text1.setText("메뉴 3을 선택했습니다.");
                    break;
            }


            return false;
        }
    }

}