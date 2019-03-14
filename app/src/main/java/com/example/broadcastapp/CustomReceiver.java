package com.example.broadcastapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {
    static final String ACTION_CUSTOM_BROADCAST="com.example.broadcastapp.ACTION_CUSTOM_BROADCAST";

    public CustomReceiver(){

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction=intent.getAction();
        String message=null;
        switch (intentAction){
            case Intent.ACTION_POWER_CONNECTED:message="POWER CONNECTED";
            break;
            case  Intent.ACTION_POWER_DISCONNECTED:message="POWER DISCONNECTED";
            break;
            case ACTION_CUSTOM_BROADCAST:message="Custom Broadcast Received";
            break;
        }
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }
}
