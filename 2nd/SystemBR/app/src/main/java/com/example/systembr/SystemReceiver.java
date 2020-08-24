package com.example.systembr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SystemReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //안드로이드 OS가 리시버를 찾기 위해 사용했던 이름을 추출한다.
        String action = intent.getAction();
        //리시버의 이름으로 분기한다.

        switch (action){
            case "android.intent.action.BOOT_COMPLETED":
                Toast t1= Toast.makeText(context, "부팅완료", Toast.LENGTH_SHORT);
                t1.show();
                break;
            case "android.provider.Telephony.SMS_RECEIVED":

                //문자 메시지 정보를 가지고 있는 객체를 추출한다.
                Bundle bundle = intent.getExtras();
                if (bundle !=null){
                    //번들에서 문자 메시지 정보 객체를 추출한다.
                    Object [] obj = (Object [])bundle.get("pdus");
                    //문자 메시지 정보 객체를 이용해 SmsMessage 객체를 생성한다.
                    SmsMessage [] msg = new SmsMessage[obj.length];
                    for(int i = 0; i<obj.length; i++){
                        msg[i] = SmsMessage.createFromPdu((byte[])obj[i]);
                    }
                    //문자 메시지 정보를 추출한다.
                    for(SmsMessage a1 : msg){
                        String number = a1.getOriginatingAddress();
                        String str = a1.getMessageBody();
                        String a2 = number + ": " + str;
                        Toast t2 = Toast.makeText(context, a2, Toast.LENGTH_SHORT);
                        t2.show();

                    }
                }
        }
    }
}
