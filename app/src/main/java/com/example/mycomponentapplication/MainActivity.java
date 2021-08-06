package com.example.mycomponentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv_component = findViewById(R.id.tv_component);
        tv_component.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.tv_component) {
            ARouter.getInstance().build("/chat/test")
                    .withLong("key1", 666L)
                    .withString("key3", "888")
                    .navigation();
        }
    }
}