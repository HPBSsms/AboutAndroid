package com.example.commonlib.login;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.example.commonlib.R;
import com.example.commonlib.utils.RoutePath;

@Route(path = RoutePath.PATH_LOGIN)
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @Autowired
    public String path;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.commonlib.R.layout.activity_login);
        //在baseActivity自动注入属性
        ARouter.getInstance().inject(this);
        TextView tv_login = findViewById(R.id.tv_login);
        tv_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.tv_login) {
            SPUtils.getInstance().put(RoutePath.SP_IS_LOGIN, true);

            ToastUtils.showShort("登录成功");
            if (!StringUtils.isEmpty(path)) {
                ARouter.getInstance().build(path)
                        .with(getIntent().getExtras())
                        .navigation();
            }
            finish();
        }
    }
}
