package com.qxg.comproj.injector.component;

import android.content.Context;

import com.qxg.comproj.injector.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by Qking on 2016/10/9.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    Context getContext();
    Retrofit getRetrofit();
}
