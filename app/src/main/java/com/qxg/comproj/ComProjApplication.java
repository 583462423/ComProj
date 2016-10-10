package com.qxg.comproj;

import android.app.Application;

import com.qxg.comproj.injector.component.ApplicationComponent;
import com.qxg.comproj.injector.component.DaggerApplicationComponent;
import com.qxg.comproj.injector.module.ApplicationModule;

/**
 * Created by Qking on 2016/10/9.
 */

public class ComProjApplication extends Application {

    ApplicationComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }

    public ApplicationComponent getComponent(){
        return appComponent;
    }
}
