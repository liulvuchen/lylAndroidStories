package com.lyl.yinglai.quickcontactbadgetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.QuickContactBadge;

public class MainActivity extends AppCompatActivity {
    private QuickContactBadge badge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取QuickContactBadge组件
        badge= (QuickContactBadge) findViewById(R.id.badge);
        //将QuickContactBadge组件与特定电话号码对应的联系人建立关联
        badge.assignContactFromPhone("020-88888888",false);
    }
}
