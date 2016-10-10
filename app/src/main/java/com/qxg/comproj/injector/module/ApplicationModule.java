package com.qxg.comproj.injector.module;

import android.app.Application;
import android.content.Context;

import com.qxg.comproj.Config;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Qking on 2016/10/9.
 */
@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application){
        mApplication = application;
    }

    @Provides
    @Singleton
    Context provideContext(){
        return mApplication.getApplicationContext();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(Config.SERVER_ADDRESS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
