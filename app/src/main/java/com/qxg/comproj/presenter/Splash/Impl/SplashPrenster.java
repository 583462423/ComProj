package com.qxg.comproj.presenter.Splash.Impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;

import com.qxg.comproj.presenter.BasePresenter;
import com.qxg.comproj.presenter.Splash.ISplashPrenster;
import com.qxg.comproj.retrofit.service.PicService;
import com.qxg.comproj.view.IView;
import com.qxg.comproj.view.Splash.ISplashView;

import java.io.InputStream;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Qking on 2016/10/9.
 */

public class SplashPrenster extends BasePresenter implements ISplashPrenster {

    ISplashView iSplashView;
    Retrofit retrofit;
    Handler handler;
    Runnable r;

    @Inject
    public SplashPrenster(Retrofit retrofit){
        this.retrofit = retrofit;
        handler = new Handler();
        r = new Runnable() {
            @Override
            public void run() {
                stepOut();
            }
        };
    }

    @Override
    public void getAndSetPic() {
        //取得图片并设置图片
        //这里待改进，取得图片后可以存储到本地文件中，或者直接使用glide
        Call<ResponseBody> call =  retrofit.create(PicService.class).downloadPic();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                InputStream in = response.body().byteStream();
                Bitmap bitmap = BitmapFactory.decodeStream(in);
                iSplashView.setPic(bitmap);
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    @Override
    public void stepOut() {
        //将三秒后自动跳转的处理删除
        handler.removeCallbacks(r);

        //首先判断本机是否已经登录过并且记住了密码
        if(false){
            iSplashView.toHome();
        }else{
            iSplashView.toLogin();
        }
    }

    @Override
    public void afterCreate() {
        handler.postDelayed(r,3000);
        getAndSetPic();
    }

    @Override
    public void attachView(IView iView) {
        iSplashView = (ISplashView) iView;
    }
}
