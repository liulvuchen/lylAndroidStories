package com.lyl.intentservicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * describe 在onStartCommand方法中使用线程暂停的方法模拟了耗时任务
 * 由于普通的Service的执行会阻塞主线程，因此启动该线程将会导致程序出现ANR异常
 * authors liuyaolin
 * createTime 2017/6/9 16:28
 */

public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //该方法内执行耗时任务可能导致ANR(Application Not Responding)异常
        long endTime = System.currentTimeMillis() + 20 * 1000;
        System.out.println("onStart");
        while (System.currentTimeMillis() < endTime) {
            synchronized (this) {
                try {
                    wait(endTime - System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("------耗时任务执行完成------");
        return START_STICKY;
    }
}
