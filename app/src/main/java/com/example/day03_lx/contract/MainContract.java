package com.example.day03_lx.contract;

import com.example.day03_lx.utils.INetCallBack;

public class MainContract {
    public interface IMainModel{
        <T> void getLoginData(String url, INetCallBack<T> callBack);
    }
    public interface IMainPresenter{
        void login(String url);
    }
    public interface IMainView extends IBaseView {
        <T> void loginRelt(T t);
    }
}
