package com.example.brapp1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class TestReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        String str = "브로드 캐스트 리시버가 동작하였습니다.";
        Toast t1 = Toast.makeText(context, str, Toast.LENGTH_SHORT);
        t1.show();
        
    }
}
