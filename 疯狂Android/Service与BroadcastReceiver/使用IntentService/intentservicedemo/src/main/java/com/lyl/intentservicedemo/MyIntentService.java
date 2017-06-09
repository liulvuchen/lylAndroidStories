package com.lyl.intentservicedemo;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

/**
 * describe IntentService会使用单独的线程来完成该耗时操作
 * authors liuyaolin
 * createTime 2017/6/9 16:35
 */

public class MyIntentService extends IntentService {

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     */
    public MyIntentService() {
        super("MyIntentService");
    }

    //IntentService会使用单独的线程来执行该方法的代码
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        //该方法可以执行任何耗时任务，比如下载文件等，此处只是让线程暂停20s
        long endTime=System.currentTimeMillis()+20*1000;
        System.out.println("onStartCommand");
        while (System.currentTimeMillis()<endTime){
            synchronized (this){
                try {
                    wait(endTime-System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("------耗时任务执行完成------");
    }
}
