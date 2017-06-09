package com.lyl.yinglai.progressbartest;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    //该程序模拟填充长度为100的数组
//    private int[] data = new int[100];
    private int hasData = 0;
    //记录ProgressBar的完成进度
    private int status = 0;
    private ProgressBar bar, bar2;
    //创建一个负责更新的进度的Handler
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            //表明消息是由该程序发送的
            if (msg.what == 0x111) {
                bar.setProgress(status);
                bar2.setProgress(status);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bar = (ProgressBar) findViewById(R.id.bar);
        bar2 = (ProgressBar) findViewById(R.id.bar2);
        //启动线程来执行任务
        new Thread() {
            @Override
            public void run() {
                while (status < 100) {
                    //获取耗时操作的完成百分比
                    status = doWork();
                    //发送消息
                    mHandler.sendEmptyMessage(0x111);
                }
            }
        }.start();
    }

    //模拟一个耗时的操作
    public int doWork() {
        //为数组元素赋值
//        data[hasData++] = (int) (Math.random() * 100);
        hasData++;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return hasData;
    }
}
