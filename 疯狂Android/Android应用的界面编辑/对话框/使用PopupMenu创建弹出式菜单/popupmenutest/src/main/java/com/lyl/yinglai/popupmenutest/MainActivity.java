package com.lyl.yinglai.popupmenutest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    PopupMenu popup = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button) findViewById(R.id.btn1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPopupButtonClick(findViewById(R.id.btn1));
            }
        });
    }

    public void onPopupButtonClick(View button) {
        //创建PopupMenu对象
        popup = new PopupMenu(this, button);
        //将R.menu.popup_menu菜单资源加载到popup菜单中
        getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
        //为popup菜单的菜单项单击事件绑定事件监听器
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.exit:
                        //隐藏该对话框
                        popup.dismiss();
                        break;
                    default:
                        //使用Toast显示用户单击的菜单项
                        Toast.makeText(MainActivity.this, "您单击了【" + item.getTitle() + "】菜单项", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
        popup.show();
    }
}
