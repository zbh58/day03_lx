package com.example.day03_lx.presenter;

import com.example.day03_lx.base.BasePresenter;
import com.example.day03_lx.contract.MainContract;
import com.example.day03_lx.model.MainModel;
import com.example.day03_lx.model.data.NewsBean;
import com.example.day03_lx.utils.INetCallBack;

public class MainPresenter extends BasePresenter implements MainContract.IMainPresenter {
    private MainContract.IMainView iMainView;
    private MainContract.IMainModel iMainModel;

    public MainPresenter(MainContract.IMainView iMainView) {
        this.iMainView = iMainView;
        this.iMainModel =new MainModel(this);
    }

    @Override
    public void login(String url) {
        iMainModel.getLoginData(url, new INetCallBack<NewsBean>() {
            @Override
            public void onSuccess(NewsBean newsBean) {
                iMainView.loginRelt(newsBean);
            }

            @Override
            public void onFail(String err) {
                iMainView.tips(err);
            }
        });
    }
}
