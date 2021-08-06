package com.example.chat;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/chat/test")
public class ChatActivity extends AppCompatActivity {

    @Autowired
    public String key3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ARouter.getInstance().inject(this);
        Toast.makeText(this, key3, Toast.LENGTH_SHORT).show();
        TextView tv_chat = findViewById(R.id.tv_chat);
    }
}
