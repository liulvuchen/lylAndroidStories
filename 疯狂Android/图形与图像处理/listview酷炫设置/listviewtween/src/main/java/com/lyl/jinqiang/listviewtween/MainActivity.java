package com.lyl.jinqiang.listviewtween;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取ListView组件
        ListView list = (ListView) findViewById(R.id.list);
        WindowManager windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        //获取屏幕的宽和高
        display.getMetrics(metrics);
        //设置对ListView组件应用动画
        list.setAnimation(new MyAnimation(metrics.xdpi / 2, metrics.ydpi / 2, 3500));
    }
}
