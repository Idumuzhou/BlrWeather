package com.forever.blrweather.onecode;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.forever.blrweather.R;
import com.forever.blrweather.base.BaseAcitvity;

/**
 * @author LuoXuLiang
 * @copyright: 2018/3/26 Forver
 * @priject BlrWeather
 * @description: 全局大喇叭--广播机制   --动态注册
 * @date: 2018/3/26 22:32
 */


public class BroadcastReceiverActivity extends BaseAcitvity {
    private IntentFilter intentFilter;
    private NetWorkChangeReceiver netWorkChangeReceiver;
    @Override
    protected void initViews() {
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        netWorkChangeReceiver = new NetWorkChangeReceiver();
        registerReceiver(netWorkChangeReceiver,intentFilter);  //广播注册
    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected String getToolbarTitleText() {
        return "广播";
    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_broadcast_receiver;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消注册
        unregisterReceiver(netWorkChangeReceiver);
    }

    /**
     * 内部类
     */
    class NetWorkChangeReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            //判断当前网络状态
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo !=null&&networkInfo.isAvailable()){
                Toast.makeText(BroadcastReceiverActivity.this,"network is Available",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(BroadcastReceiverActivity.this,"network is UnAvailable",Toast.LENGTH_SHORT).show();
            }

        }
    }
}
