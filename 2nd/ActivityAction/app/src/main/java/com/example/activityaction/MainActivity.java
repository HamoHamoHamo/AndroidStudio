package com.example.activityaction;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //승인 받을 권한 목록
    String [] permission_list = {
            Manifest.permission.CALL_PHONE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkPermission();
    }

    public void btn1Method (View view){
        //구글 지도를 통해 보여줄 위도와 경도를 셋팅한다.
        Uri uri = Uri.parse("geo:37.243243,131,861601");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }

    public void btn2Method(View view){
        //브라우저를 통해 보여줄 페이지의 주소를 셋팅한다.
        Uri uri = Uri.parse("http://developer.android.com");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void btn3Method(View view){
        //전화번호를 셋팅한다.
        Uri uri = Uri.parse("tel:00000000");
        Intent intent = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(intent);
    }

    public void btn4Method(View view){
        //권한 확인 여부를 체크한다.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int chk = checkCallingOrSelfPermission(Manifest.permission.CALL_PHONE);
            if(chk == PackageManager.PERMISSION_DENIED){
                return;
            }
        }

        Uri uri = Uri.parse("tel:00000");
        Intent intent = new Intent(Intent.ACTION_CALL, uri);
        startActivity(intent);
    }

    //권한 체크
    public void checkPermission(){
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            return;
        }
        for (String permission : permission_list){
            int chk = checkCallingOrSelfPermission(permission);
            if (chk == PackageManager.PERMISSION_DENIED){
                requestPermissions(permission_list,0);
                break;
            }
        }
    }

}