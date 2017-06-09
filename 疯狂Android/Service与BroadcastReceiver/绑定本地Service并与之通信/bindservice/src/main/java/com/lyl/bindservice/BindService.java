package com.lyl.bindservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2016/11/8.
 */

public class BindService extends Service {
    private int count;
    private boolean quit;
    //定义onBinder方法所返回的对象
    private MyBinder binder=new MyBinder();
    //通过继承Binder来实现IBinder类
    public class MyBinder extends Binder{
        public int getCount(){
            //获取Service的运行状态:count
            return count;
        }
    }

    //必须实现的方法，绑定该Service时回调该方法
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("tttt","Service is Binded");
        //返回IBinder对象
        return binder;
    }

    //Service被创建时回调该方法
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("tttt","Service is Created");
        new Thread(){
            @Override
            public void run() {
                super.run();
                while (!quit){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count++;
                }
            }
        }.start();
    }

    //Service被断开连接时回调该方法
    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("tttt","Service is Unbinded");
        return true;
    }

    //Service被关闭之前回调该方法
    @Override
    public void onDestroy() {
        super.onDestroy();
        this.quit=true;
        Log.i("tttt","Service is Destroyed");
    }
}
