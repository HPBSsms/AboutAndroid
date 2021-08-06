package com.example.home;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path = "/home/HomeService", name = "测试服务")
public class HomeService implements HomeExportService {
    @Override
    public String sayHello(String s) {
        return "HomeService say Hello to " + s;
    }

    @Override
    public void init(Context context) {

    }
}
