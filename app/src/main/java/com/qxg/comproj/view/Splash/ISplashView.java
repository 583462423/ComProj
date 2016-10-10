package com.qxg.comproj.view.Splash;

import android.graphics.Bitmap;

import com.qxg.comproj.view.IView;

/**
 * Created by Qking on 2016/10/9.
 */

public interface ISplashView extends IView{
    public void setPic(Bitmap bitmap);
    public void toHome();
    public void toLogin();
}
