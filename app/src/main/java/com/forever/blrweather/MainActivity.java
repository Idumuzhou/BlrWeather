package com.forever.blrweather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;

public class MainActivity extends BaseAcitvity {
    @BindView(R.id.tv_one_code)
    TextView tv_one_code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }



}
