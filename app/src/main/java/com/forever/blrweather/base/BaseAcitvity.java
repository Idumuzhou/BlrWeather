package com.forever.blrweather.base;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.forever.blrweather.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author LuoXuLiang
 * @copyright: 2018/3/21 Forver
 * @priject BlrWeather
 * @description: Activity基类
 * @date: 2018/3/21 21:24
 */


public abstract class BaseAcitvity extends AppCompatActivity {
    private Unbinder mUnbinder = null;
    protected Toolbar mToolbar;
    protected TextView mTvToolbarTitle;
    protected ImageView mToolbarRightIcon;
    protected TextView toolbarRightTv;
    protected View divide_line;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onCreateView(savedInstanceState);
        mUnbinder = ButterKnife.bind(this);

    }

    private void onCreateView(Bundle savedInstanceState){
        if (getContentViewLayoutId()!=0) {
            setContentView(getContentViewLayoutId());
            mUnbinder = ButterKnife.bind(this);
            initVariables();
            initViews();
            initToolbar();
        }else {
            throw new IllegalArgumentException("You must set a layoutID for activity first!");
        }
        onSavedInstanceInit(savedInstanceState);
    }

    /**
     * 初始化Toolbar
     */
    protected void initToolbar() {
        if (shouldUseBaseToolbar()) {
            mToolbar = ButterKnife.findById(this, R.id.tb);
            mTvToolbarTitle = ButterKnife.findById(this, R.id.toolbarTitle);
            mToolbarRightIcon = ButterKnife.findById(this, R.id.toolbarRightIcon);
            toolbarRightTv = ButterKnife.findById(this, R.id.toolbarRightTv);
            divide_line = ButterKnife.findById(this, R.id.toolbar_divide);
            setSupportActionBar(mToolbar);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("");
            mTvToolbarTitle.setText(getToolbarTitleText());
            mTvToolbarTitle.setTextColor(getToolbarTitleTextColor());
            mToolbar.setBackgroundResource(getToolbarBackground());
            if (getToolbarNavIcon() == 0) {
                mToolbar.setNavigationIcon(null);
                mToolbar.setNavigationOnClickListener(null);
            } else {
                mToolbar.setNavigationIcon(getToolbarNavIcon());
                mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            onBackPressed();
                        } catch (IllegalStateException ex) {
                            ex.printStackTrace();
                        }
                    }
                });
            }
            if (getToolbarRightIcon() != 0) {
                mToolbarRightIcon.setVisibility(View.VISIBLE);
                mToolbarRightIcon.setImageResource(getToolbarRightIcon());
            } else {
                mToolbarRightIcon.setVisibility(View.GONE);
            }
            if (!getToolbarRightTv().equals("")) {
                toolbarRightTv.setVisibility(View.VISIBLE);
                toolbarRightTv.setText(getToolbarRightTv());
                toolbarRightTv.setTextColor(getToolbarRightTvColor());
            } else {
                toolbarRightTv.setVisibility(View.GONE);
            }
        }
    }

    /**
     *  初始化View
     */
    protected abstract void initViews();

    /**
     * 初始化和Bundle无关的变量
     */
    protected abstract void initVariables();

    /**
     * 现场还原初始化
     *
     * @param savedInstanceState
     */
    protected void onSavedInstanceInit(Bundle savedInstanceState) {

    }

    public TextView getmTvToolbarTitle() {
        return mTvToolbarTitle;
    }

    /**
     * 是否使用默认添加的toolbar
     *
     * @return
     */
    protected boolean shouldUseBaseToolbar() {
        return true;
    }

    /**
     * 配置Toolbar的标题
     * 默认为空
     *
     * @return
     */
    protected String getToolbarTitleText() {
        return "";
    }

    /**
     * 配置Toolbar标题字体颜色
     * 默认黑色
     *
     * @return
     */
    protected int getToolbarTitleTextColor() {
        return Color.parseColor("#ffffff");
    }

    /**
     * 配置Toolbar NavigationIcon
     *
     * @return
     */
    protected int getToolbarNavIcon() {
        return R.mipmap.icon_back;
    }

    /**
     * 配置Toolbar 右边的icon
     *
     * @return
     */
    protected int getToolbarRightIcon() {
        return 0;
    }

    /**
     * 配置Toolbar 右边的tv
     *
     * @return
     */
    protected String getToolbarRightTv() {
        return "";
    }

    /**
     * 配置Toolbar 右边的tv
     *
     * @return
     */
    protected int getToolbarRightTvColor() {
        return Color.parseColor("#FFFFFF");
    }

    /**
     * 配置Toolbar 背景
     * 默认白色
     *
     * @return
     */
    protected int getToolbarBackground() {
        return 0;
    }

    /**
     * startActivity
     *
     * @param clazz
     */
    protected void readyGo(Class<?> clazz) {
//        String className = this.getClass().getSimpleName();
//        if (MCache.isLogin() || className.equals("AboutActivity") || className.equals("RateActivity")) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
//        } else {
//            Intent intent = new Intent(this, LoginActivity.class);
//            startActivity(intent);
//        }
    }

    /**
     * startActivity with bundle
     *
     * @param clazz
     * @param bundle
     */
    protected void readyGo(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * startActivity then finish
     *
     * @param clazz
     */
    protected void readyGoThenKill(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
        finish();
    }

    /**
     * startActivity with bundle then finish
     *
     * @param clazz
     * @param bundle
     */
    protected void readyGoThenKill(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        finish();
    }

    /**
     * startActivityForResult
     *
     * @param clazz
     * @param requestCode
     */
    protected void readyGoForResult(Class<?> clazz, int requestCode) {
        Intent intent = new Intent(this, clazz);
        startActivityForResult(intent, requestCode);
    }

    /**
     * startActivityForResult with bundle
     *
     * @param clazz
     * @param requestCode
     * @param bundle
     */
    protected void readyGoForResult(Class<?> clazz, int requestCode, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    /**
     * 绑定Layout
     */
    protected abstract int getContentViewLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != mUnbinder) {
            mUnbinder.unbind();
        }
    }
}
