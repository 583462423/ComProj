package com.qxg.comproj.view.login;

import com.qxg.comproj.view.IView;

/**
 * Created by Qking on 2016/10/9.
 */

public interface ILoginView extends IView{
    public void clearUser();
    public void clearPwd();
    public void showMsg(String msg);
}
