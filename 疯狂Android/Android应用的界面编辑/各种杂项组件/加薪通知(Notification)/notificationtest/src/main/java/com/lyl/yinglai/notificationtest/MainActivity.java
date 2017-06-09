package com.lyl.yinglai.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    static final int NOTIFICATION_ID = 0x123;
    NotificationManager nm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取系统的NotificationManager服务
        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        ((Button) findViewById(R.id.btn1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send(null);
            }
        });
        ((Button) findViewById(R.id.btn2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                del(null);
            }
        });
    }

    //为发送通知的按钮的点击事件定义事件处理方法
    public void send(View source) {
        //创建一个启动其他Activity的Intent
        Intent intent = new Intent(MainActivity.this, OtherActivity.class);
        //intent英文意思是意图，pending表示即将发生或来临的事情。PendingIntent这个类用于处理即将发生的事情。
        PendingIntent pi = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
        Notification notify = new Notification.Builder(this)
                //设置打开该通知，该通知自动消息
                .setAutoCancel(true)
                //设置显示在状态栏的通知提示信息
                .setTicker("有新消息")
                //设置通知图标
                .setSmallIcon(R.drawable.bill)
                //设置通知内容的标题
                .setContentTitle("一条新通知")
                //设置通知内容
                .setContentText("恭喜您，您加薪了，工资增加20%！")
                //设置使用系统默认的声音、默认的LED灯
                .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS)
                //设置通知的自定义声音
//                .setSound(Uri.parse("android.resource://org.crazyit.ui/"+R.raw.msg));
                .setWhen(System.currentTimeMillis())
                //设置通知将要启动程序的Intent
                .setContentIntent(pi)
                .build();
        /*
         * //设置自定义声音
         * setSound(Uri.parse("file:///sdcard/click.mp3"));
         * //设置自定义振动
         * setVibrate(new long[]{0,50,100,150});
         */
        //发送通知
        nm.notify(NOTIFICATION_ID, notify);
    }

    //为删除通知的按钮的点击事件定义事件处理方法
    public void del(View v) {
        //取消通知
        nm.cancel(NOTIFICATION_ID);
    }

}
