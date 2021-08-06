package com.example.mycomponentapplication;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //官方建议在Application里面进行初始化(使用该注解路径至少两级)
        ARouter.init(this);
    }
}
