package com.example.mycomponentapplication;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化阿里巴巴路由框架
        if (BuildConfig.DEBUG) {
            // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog(); // 打印日志
            ARouter.openDebug();// 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)}
        }
        //官方建议在Application里面进行初始化(使用该注解路径至少两级)
        ARouter.init(this);
    }
}
