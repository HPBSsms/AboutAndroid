package com.example.mycomponentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.example.commonlib.utils.RoutePath;
import com.example.home.HomeExportService;
import com.example.commonlib.login.LoginNavigationCallbackImpl;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Autowired(name = RoutePath.PATH_HOME_SERVICE)
    public HomeExportService baseService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ARouter.getInstance().inject(this);

        TextView tv_component = findViewById(R.id.tv_component);
        TextView tv_service = findViewById(R.id.tv_service);
        TextView tv_login_intercept = findViewById(R.id.tv_login_intercept);
        TextView tv_exit = findViewById(R.id.tv_exit);
        tv_component.setOnClickListener(this);
        tv_service.setOnClickListener(this);
        tv_login_intercept.setOnClickListener(this);
        tv_exit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.tv_component) {
            //跳转到ChatActivity
            ARouter.getInstance().build(RoutePath.PATH_CHAT)
                    .withLong("key1", 666L)
                    .withString("key3", "888")
                    .navigation();
        } else if (view.getId() == R.id.tv_service) {
            Toast.makeText(MainActivity.this, baseService == null ? "NULL" : baseService.sayHello("Smith"), Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.tv_login_intercept) {
            ARouter.getInstance().build(RoutePath.PATH_COMMON).withString("msg", "123").navigation(this, new LoginNavigationCallbackImpl());
        } else if (view.getId() == R.id.tv_exit) {
            ToastUtils.showShort("退出登录成功");
            SPUtils.getInstance().remove(RoutePath.SP_IS_LOGIN);
        }
    }
}