package com.example.day03_lx.utils;

public interface INetCallBack<T> {
    public void onSuccess(T t);
    public void onFail(String err);
}
