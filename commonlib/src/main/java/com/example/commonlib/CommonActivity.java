package com.example.commonlib;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.commonlib.utils.RoutePath;

@Route(path = RoutePath.PATH_COMMON)
public class CommonActivity extends AppCompatActivity {

    @Autowired
    public long key2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);
        TextView tv_common = findViewById(R.id.tv_common);
    }
}
