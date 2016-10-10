package com.qxg.comproj.presenter;

import com.qxg.comproj.view.IView;

/**
 * Created by Qking on 2016/10/10.
 * 该类是所有Presenter的基类
 */

public abstract class BasePresenter {

    public void afterCreate(){

    }

    public abstract void attachView(IView iView);
}
