package com.lyl.bindservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button bind, unbind, getServiceStatus;
    //保持所启动的Service的IBinder对象
    BindService.MyBinder binder;
    //定义一个ServiceConnection对象
    private ServiceConnection conn = new ServiceConnection() {
        //当该Activity与Service连接成功时回调该方法
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i("tttt", "----Service Connected----");
            binder = (BindService.MyBinder) service;
        }

        //当该Activity与Service断开连接时回调该方法
        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i("tttt", "----Service Disconnected----");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind = (Button) findViewById(R.id.bind);
        unbind = (Button) findViewById(R.id.unbind);
        getServiceStatus = (Button) findViewById(R.id.getServiceStatus);
        //创建启动Service的Intent
        final Intent intent = new Intent(this, BindService.class);
        bind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //绑定指定Service
                bindService(intent, conn, BIND_AUTO_CREATE);
            }
        });
        unbind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //解除绑定
                unbindService(conn);
            }
        });
        getServiceStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取并显示Service的count值
                Toast.makeText(MainActivity.this, "Service的count值为:" + binder.getCount(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
