package com.forever.blrweather;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
/**
 *  * @copyright: 2017 
 *  * @priject BlrWeather
 *  * @author LuoXuLiang
 *  * @description:  description 
 *  * @date: 2018/3/12 上午10:44
 *  
 */

public class MainActivity extends BaseAcitvity {
    @BindView(R.id.tv_one_code)
    TextView tv_one_code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

tv_one_code.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

    }
});

    }



}
