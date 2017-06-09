package com.lyl.firstservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2016/11/8.
 */

public class FirstService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    //Service被创建时回调该方法
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("tttt","Service is Created");
    }

    //Service被启动时回调该方法
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("tttt","Service is Started");
        return START_STICKY;
    }

    //Service被关闭之前回调该方法
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("tttt","Service is Destroyed");
    }
}
