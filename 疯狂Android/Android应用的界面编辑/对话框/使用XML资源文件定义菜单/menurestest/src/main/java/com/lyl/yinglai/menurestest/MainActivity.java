package com.lyl.yinglai.menurestest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView) findViewById(R.id.txt);
        //为文本框注册上下文菜单
        registerForContextMenu(txt);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflator = new MenuInflater(this);
        //装填R.menu.content对应的菜单，并添加到menu中
        inflator.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //创建上下文菜单时触发该方法
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflator = new MenuInflater(this);
        //装填R.menu.context对应的菜单，并添加到menu中
        inflator.inflate(R.menu.context, menu);
        menu.setHeaderTitle("请选择背景色");
        menu.setHeaderIcon(R.drawable.bill);
    }

    //上下文菜单中菜单项被单击时触发该方法
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //勾选该菜单项
        item.setChecked(true);
        switch (item.getItemId()) {
            case R.id.red:
                item.setChecked(true);
                txt.setBackgroundColor(Color.RED);
                break;
            case R.id.green:
                item.setChecked(true);
                txt.setBackgroundColor(Color.GREEN);
                break;
            case R.id.blue:
                item.setChecked(true);
                txt.setBackgroundColor(Color.BLUE);
                break;
        }
        return true;
    }

    //菜单项被单击后的回调方法

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.isCheckable()) {
            //勾选该菜单项
            item.setChecked(true);
        }
        //判断单击的是哪个菜单项，并有针对性地做出响应
        switch (item.getItemId()) {
            case R.id.font_10:
                txt.setTextSize(10 * 2);
                break;
            case R.id.font_12:
                txt.setTextSize(12 * 2);
                break;
            case R.id.font_14:
                txt.setTextSize(14 * 2);
                break;
            case R.id.font_16:
                txt.setTextSize(16 * 2);
                break;
            case R.id.font_18:
                txt.setTextSize(18 * 2);
                break;
            case R.id.red_font:
                txt.setTextColor(Color.RED);
                item.setChecked(true);
                break;
            case R.id.green_font:
                txt.setTextColor(Color.GREEN);
                item.setChecked(true);
                break;
            case R.id.blue_font:
                txt.setTextColor(Color.BLUE);
                item.setChecked(true);
                break;
            case R.id.plain_item:
                Toast.makeText(MainActivity.this, "您单击了普通菜单项", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
