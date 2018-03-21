package com.forever.blrweather;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * @author LuoXuLiang
 * @copyright: 2018/3/21 Forver
 * @priject BlrWeather
 * @description: Activity基类
 * @date: 2018/3/21 21:24
 */


public class BaseAcitvity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        ButterKnife.bind(this);
    }
}
