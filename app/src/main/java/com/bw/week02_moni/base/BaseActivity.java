package com.bw.week02_moni.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 时间 :2019/12/7  8:40
 * 作者 :苗恒
 * 功能 :
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView{
    public  P presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayoutid());
        presenter=initPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        }
        initView();
        initData();
    }

    protected abstract P initPresenter();

    protected abstract int bindLayoutid();

    protected abstract void initData();

    protected abstract void initView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.disAttach();
    }
}
