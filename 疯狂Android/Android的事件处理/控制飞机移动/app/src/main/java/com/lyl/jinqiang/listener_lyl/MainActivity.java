package com.lyl.jinqiang.listener_lyl;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {
    //定义飞机的移动速度
    private int speed = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉窗口标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //全屏显示
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //创建PlaneView组件
        final PlainView plainView = new PlainView(this);
        setContentView(plainView);
        plainView.setBackgroundResource(R.drawable.bill);
        //获取窗口管理器
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        //获取屏幕宽高
        display.getMetrics(metrics);
        //设置飞机的初始位置
        plainView.currentX = metrics.widthPixels / 2;
        plainView.currentY = metrics.heightPixels - 40;
        //为planeView组件的键盘事件绑定监听器
        plainView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //获取由哪个键触发的事件
                switch (event.getAction()) {
                    //控制飞机下移
                    case KeyEvent.ACTION_DOWN:
                        plainView.currentY += speed;
                        break;
                    //控制飞机下移
                    case KeyEvent.ACTION_UP:
                        plainView.currentY -= speed;
                        break;
                    //控制飞机左移:
                    case KeyEvent.KEYCODE_A:
                        plainView.currentX -= speed;
                        break;
                    //控制飞机右移
                    case KeyEvent.KEYCODE_D:
                        plainView.currentX += speed;
                        break;
                }
                //通知planeView组件重绘
                plainView.invalidate();
                return true;
            }
        });
    }
}
