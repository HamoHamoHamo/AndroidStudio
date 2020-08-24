package com.example.permission;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.hardware.camera2.params.MandatoryStreamCombination;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView text1;
    //체크할 권한 목록
    String [] permission_list = {
            Manifest.permission.INTERNET,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.WRITE_CONTACTS,
            Manifest.permission.SEND_SMS,
            Manifest.permission.RECEIVE_SMS
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView)findViewById(R.id.textView);

        checkPermission();
    }

    //권한 체크 메서드
    public void checkPermission(){
        //현재 안드로이드 버전이 6.0미만이면 메서드를 종료한다.
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            return;
        }
        //각 권한의 허용 여부를 확인한다.
        for (String permission : permission_list){
            //권한 허용 여부를 확인한다.
            int chk = checkCallingOrSelfPermission(permission);
            //거부 상태라고 한다.
            if(chk == PackageManager.PERMISSION_DENIED){
                //사용자에게 권한 허용여부를 확인하는 창을 띄운다.
                requestPermissions(permission_list, 0);
            }
        }
    }

    //권환 확인 여부가 완료되면 호출되는 메서드
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        text1.setText("");

        //사용자가 권한 허용 여부를 확인한다.
        for(int i =0; i<grantResults.length; i++){
            if(grantResults[i]==PackageManager.PERMISSION_GRANTED) {
                text1.append(permissions[i] + " : 허용\n");
            }
            else{
                text1.append(permissions[i] + " : 거부\n");
            }

        }
    }
}