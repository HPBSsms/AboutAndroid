package com.example.home;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.commonlib.utils.RoutePath;

@Route(path = RoutePath.PATH_HOME_SERVICE, name = "测试服务")
public class HomeService implements HomeExportService {
    @Override
    public String sayHello(String s) {
        return "HomeService say Hello to " + s;
    }

    @Override
    public void init(Context context) {

    }
}
