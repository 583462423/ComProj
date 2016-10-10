package com.qxg.comproj.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.qxg.comproj.injector.component.ActivityComponent;
import com.qxg.comproj.injector.component.DaggerActivityComponent;
import com.qxg.comproj.injector.module.ActivityModule;
import com.qxg.comproj.presenter.BasePresenter;

/**
 * Created by Qking on 2016/10/9.
 * 创建该BaseActivity的目的有是要放置配置信息，并且所有Activity共有的配置信息
 */

public abstract class BaseActivity extends AppCompatActivity {

    String tmp = "qxg";  //临时存放的值，以后想到再添加
    public ActivityComponent mActivityComponent;

    public abstract int setContentView();
    /**
     * 如果在onCreate完成创建后，需要其他额外的操作，可以重写该方法，不过需要在onCreate的最后调用该方法
     * 子类不需重写该方法，需要重写presenter的afterCreate()方法
     * 如果有些任务无法在presenter中完成，而必须在Activity中完成，那么可以重写该方法，重写的最后要记得调用super.afterCreate();
     */
    protected void afterCreate(){
        Log.i("afterCreate","afterCreate is running");
        BasePresenter bp = getPresenter();
        if(bp!=null) bp.afterCreate();
    }


    /**
     * 该方法是以便书写自己想要的额外操作，并在afterCreate()方法前
     */
    protected void custom(){
        Log.i("custome","custome() is running");
    }


    /**
     * 重写父类的onCreate方法，在该方法中调用initInjector，afterCreate等方法，在以后的activity代码中就不用书写这些
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layout = setContentView();
        setContentView(layout);

        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .build();
        initInjector();
        attachView();
        custom();
        afterCreate();
    }

    /**
     * 将Presenter与IView进行关联
     */
    public abstract void attachView();

    /**
     * 初始化inject，包括ButterKnife.如果项目自动生成的ButterKnife.bind(this)则迁移到此方法中
     */
    public abstract void initInjector();

    /**
     *  得到presenter，如果没有重写该方法，就不会调用afterCreate()。
     */
    public abstract BasePresenter getPresenter();

}
