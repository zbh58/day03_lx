package com.example.day03_lx.model;

import com.example.day03_lx.contract.MainContract;
import com.example.day03_lx.model.data.NewsBean;
import com.example.day03_lx.utils.INetCallBack;
import com.example.day03_lx.utils.RetrofitUtils;

public class MainModel implements MainContract.IMainModel {
    private MainContract.IMainPresenter presenter;

    public MainModel(MainContract.IMainPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public <T> void getLoginData(String url, INetCallBack<T> callBack) {
        RetrofitUtils.getInstance().get(url, new INetCallBack<NewsBean>() {
            @Override
            public void onSuccess(NewsBean newsBean) {
                callBack.onSuccess((T)newsBean);
            }

            @Override
            public void onFail(String err) {
                callBack.onFail(err);
            }
        });
    }
}
