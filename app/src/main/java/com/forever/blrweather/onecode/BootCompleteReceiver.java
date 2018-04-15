package com.forever.blrweather.onecode;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * 静态注册广播   实现开机启动
 */
public class BootCompleteReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Boot Complete",Toast.LENGTH_SHORT).show();
    }


    //1.new-->other-->Broadcast Receiver
    //2.广播接收器里面打印   Boot Complete
    //3.AndroidManifest
    // <!--添加静态广播权限-->
    //    <uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED"/>
    /**
     * --静态注册广播--
     <receiver
     android:name=".onecode.BootCompleteReceiver"
     android:enabled="true"
     android:exported="true">
     <intent-filter>
     <action android:name="android.intent.action.BOOT_COMPLETED"/>
     </intent-filter>
     </receiver>
     */
}
