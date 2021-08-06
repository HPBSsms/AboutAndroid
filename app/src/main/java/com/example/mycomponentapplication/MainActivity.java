package com.example.mycomponentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.home.HomeExportService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Autowired(name = "/home/HomeService")
    public HomeExportService baseService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ARouter.getInstance().inject(this);

        TextView tv_component = findViewById(R.id.tv_component);
        TextView tv_service = findViewById(R.id.tv_service);
        tv_component.setOnClickListener(this);
        tv_service.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.tv_component) {
            //跳转到ChatActivity
            ARouter.getInstance().build("/chat/test")
                    .withLong("key1", 666L)
                    .withString("key3", "888")
                    .navigation();
        } else if (view.getId() == R.id.tv_service) {
            Toast.makeText(MainActivity.this, baseService == null ? "NULL" : baseService.sayHello("Smith"), Toast.LENGTH_SHORT).show();
        }
    }
}