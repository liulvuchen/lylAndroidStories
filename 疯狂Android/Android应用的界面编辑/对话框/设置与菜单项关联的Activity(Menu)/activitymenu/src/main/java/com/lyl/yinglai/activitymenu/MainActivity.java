package com.lyl.yinglai.activitymenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //------------向menu中添加子菜单--------------------
        SubMenu prog=menu.addSubMenu("启动程序");
        //设置菜单头的图标
        prog.setHeaderIcon(R.drawable.bill);
        //设置菜单头的标题
        prog.setHeaderTitle("选中您要启动的程序");
        //添加菜单项
        MenuItem item=prog.add("查看Swift");
        //为菜单项设置关联的Activity
        item.setIntent(new Intent(this,OtherActivity.class));
        return super.onCreateOptionsMenu(menu);
    }
}
