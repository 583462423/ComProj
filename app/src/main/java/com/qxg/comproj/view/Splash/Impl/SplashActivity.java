package com.qxg.comproj.view.Splash.Impl;

import android.content.Intent;
import android.graphics.Bitmap;
import android.widget.Button;
import android.widget.ImageView;

import com.qxg.comproj.R;
import com.qxg.comproj.presenter.BasePresenter;
import com.qxg.comproj.presenter.Splash.Impl.SplashPrenster;
import com.qxg.comproj.view.BaseActivity;
import com.qxg.comproj.view.Splash.ISplashView;
import com.qxg.comproj.view.home.Impl.HomeActivity;
import com.qxg.comproj.view.login.Impl.LoginActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SplashActivity extends BaseActivity implements ISplashView{

    @BindView(R.id.splash_image)
    ImageView splashImage;
    @BindView(R.id.splash_step_out)
    Button splashStepOut;
    @Inject
    SplashPrenster splashPrenster;


    @OnClick(R.id.splash_step_out)
    public void click(){
        //如果点击了该按钮，则交给Presenter判断是否登录过，如果登录过就跳转主页，如果没有则跳转登录界面,并且要取消到handler的事件
        splashPrenster.stepOut();
    }

    @Override
    public void setPic(Bitmap bitmap) {
        //设置图片，并慢慢显示
        splashImage.setImageBitmap(bitmap);
        splashImage.animate().alpha(1).setDuration(2000);
    }

    @Override
    public void toHome() {
        //跳转至主页面
        this.finish();
        startActivity(new Intent(SplashActivity.this,HomeActivity.class));
    }

    @Override
    public void toLogin() {
        //跳转至登录页面
        this.finish();
        startActivity(new Intent(SplashActivity.this,LoginActivity.class));
    }

    @Override
    public int setContentView() {
        return R.layout.activity_splash;
    }

    @Override
    public void attachView() {
        splashPrenster.attachView(this);
    }

    @Override
    public void initInjector() {
        mActivityComponent.inject(this);
        ButterKnife.bind(this);
    }

    @Override
    public BasePresenter getPresenter() {
        return splashPrenster;
    }
}
