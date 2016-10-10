package com.qxg.comproj.injector.module;

import android.app.Activity;

import com.qxg.comproj.Config;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Qking on 2016/10/10.
 */

@Module
public class ActivityModule {

    private final Activity activity;

    public ActivityModule(Activity activity){
        this.activity = activity;
    }

    @Provides
    Retrofit provideNoConvertRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(Config.SERVER_ADDRESS)
                .build();
    }
}
