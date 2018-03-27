package com.forever.blrweather.ui;

import android.view.View;

import com.forever.blrweather.R;
import com.forever.blrweather.base.BaseAcitvity;
import com.forever.blrweather.onecode.BroadcastReceiverActivity;

import butterknife.OnClick;

/**
 *  * @copyright: 2017 
 *  * @priject BlrWeather
 *  * @author LuoXuLiang
 *  * @description:  description 
 *  * @date: 2018/3/12 上午10:44
 *  
 */

public class MainActivity extends BaseAcitvity {


    @Override
    protected void initViews() {

    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected boolean shouldUseBaseToolbar() {
        return false;
    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_main;
    }


    @OnClick({R.id.tv_one_code})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_one_code:  //第一行代码
                readyGo(BroadcastReceiverActivity.class);
                break;
        }
    }
}
