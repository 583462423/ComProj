package com.qxg.comproj.view.login.Impl;

import android.widget.Button;
import android.widget.RelativeLayout;

import com.qxg.comproj.R;
import com.qxg.comproj.presenter.BasePresenter;
import com.qxg.comproj.view.BaseActivity;
import com.qxg.comproj.view.login.ILoginView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity implements ILoginView {


    @BindView(R.id.aaa)
    Button aaa;
    @BindView(R.id.activity_login)
    RelativeLayout activityLogin;

    @Override
    public int setContentView() {
        return R.layout.activity_login;
    }

    @Override
    public void attachView() {

    }

    @Override
    public void initInjector() {
        ButterKnife.bind(this);
    }

    @Override
    public BasePresenter getPresenter() {
        return null;
    }

    @Override
    public void clearUser() {

    }

    @Override
    public void clearPwd() {

    }

    @Override
    public void showMsg(String msg) {

    }

}
