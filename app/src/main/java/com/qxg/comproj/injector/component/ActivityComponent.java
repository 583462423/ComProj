package com.qxg.comproj.injector.component;

import com.qxg.comproj.injector.module.ActivityModule;
import com.qxg.comproj.view.Splash.Impl.SplashActivity;

import dagger.Component;

/**
 * Created by Qking on 2016/10/10.
 */

@Component(modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(SplashActivity activity);
}
