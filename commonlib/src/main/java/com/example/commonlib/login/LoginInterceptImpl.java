package com.example.commonlib.login;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.blankj.utilcode.util.SPUtils;
import com.example.commonlib.utils.RoutePath;

@Interceptor(name = "login", priority = 6)
public class LoginInterceptImpl implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        String path = postcard.getPath();
//        boolean isLogin = false;
        boolean isLogin = SPUtils.getInstance().getBoolean(RoutePath.SP_IS_LOGIN, false);
        if (isLogin) {
            //已登录不拦截
            callback.onContinue(postcard);
        } else {
            //如果没有登录，进行拦截
            switch (path) {
                // 不需要登录的直接进入这个页面
                case RoutePath.PATH_LOGIN:
                    callback.onContinue(postcard);
                    break;
                // 需要登录的直接拦截下来
                default:
                    callback.onInterrupt(null);
                    break;
            }
        }
    }

    @Override
    public void init(Context context) {
        Log.i("Component==", "init: 初始化成功");
    }
}
