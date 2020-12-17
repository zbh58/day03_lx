package com.example.day03_lx;

import android.util.Log;

import com.example.day03_lx.base.BaseActivity;
import com.example.day03_lx.contract.MainContract;
import com.example.day03_lx.model.data.NewsBean;
import com.example.day03_lx.presenter.MainPresenter;
import com.example.day03_lx.utils.URLConstant;

import java.util.ArrayList;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.IMainView {

    private ArrayList<NewsBean.NewsDTO> newslist = new ArrayList<>();
    @Override
    protected void initData() {
        presenter.login(URLConstant.baseurl2);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected MainPresenter getPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public <T> void loginRelt(T t) {
        NewsBean newsBean= (NewsBean) t;
        newslist.clear();
        newslist.addAll(newsBean.getNews());
        for (int i = 0; i < newslist.size(); i++) {
            Log.e("TAG", "loginRelt: "+newslist.get(i).getImageUrl());
            Log.e("TAG", "loginRelt: "+newslist.get(i).getContent());
            Log.e("TAG", "loginRelt: "+newslist.get(i).getTile());
        }
    }

    @Override
    public void tips(String string) {
        Log.e("TAG","tips:"+string);
    }
}