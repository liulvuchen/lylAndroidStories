package com.lyl.jinqiang.handlertest;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    //定义周期性显示的图片ID
    int[] imageIds = new int[]{
            R.drawable.balance,
            R.drawable.btn_guan,
            R.drawable.btn_kai,
            R.drawable.buy,
            R.drawable.colorreddot
    };
    int currentImageId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView show = (ImageView) findViewById(R.id.show);
        final Handler myHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                //如果该消息是本程序所发送的
                if (msg.what == 0x1233) {
                    //动态地修改所显示的图片
                    show.setImageResource(imageIds[currentImageId++ % imageIds.length]);
                }
            }
        };
        //定义一个计时器，让该计时器周期性地执行指定任务
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                //发送空消息
                myHandler.sendEmptyMessage(0x1233);
            }
        }, 0, 1200);
    }
}
