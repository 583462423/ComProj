package com.qxg.comproj.view.home.Impl;

import android.os.Bundle;

import com.qxg.comproj.R;
import com.qxg.comproj.presenter.BasePresenter;
import com.qxg.comproj.view.BaseActivity;
import com.qxg.comproj.view.home.IHomeView;

public class HomeActivity extends BaseActivity implements IHomeView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    public int setContentView() {
        return R.layout.activity_home;
    }

    @Override
    public void attachView() {

    }

    @Override
    public void initInjector() {

    }

    @Override
    public BasePresenter getPresenter() {
        return null;
    }
}
