package com.lyl.yinglai.actionhometest;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getActionBar();
//        //设置是否显示应用程序图标
//        actionBar.setDisplayShowHomeEnabled(true);
//        //将应用程序图标设置为可点击的按钮
        actionBar.setHomeButtonEnabled(false);
//        //将应用程序图标设置为可点击的按钮，并在图标上添加向左的箭头
//        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        //状态R.menu.context对应的菜单，并添加打menu中
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //选项菜单的菜单项被单击后的回调方法
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.isCheckable()) {
            item.setChecked(true);
        }
        //判断单击的是哪个菜单项，并有针对性地做出响应
        switch (item.getItemId()) {
            case android.R.id.home:
                //创建启动FirstActivity的Intent
                Intent intent = new Intent(this, FirstActivity.class);
                //添加额外的Flag,将Activity栈中处于FirstActivity之上的Activity弹出
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                //启动intent对应的Activity
                startActivity(intent);
                break;
        }
        return true;
    }
}
