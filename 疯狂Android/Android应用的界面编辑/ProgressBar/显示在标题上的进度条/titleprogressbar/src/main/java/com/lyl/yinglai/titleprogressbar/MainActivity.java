package com.lyl.yinglai.titleprogressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置窗口特征:启用显示进度的进度条
        requestWindowFeature(Window.FEATURE_PROGRESS);
        //设置窗口特征:启用不显示进度的进度条
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_main);
        Button btn1= (Button) findViewById(R.id.btn1_xianshi);
        Button btn2= (Button) findViewById(R.id.btn2_yingchang);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"!!",Toast.LENGTH_SHORT).show();
                //显示不带进度的进度条
                setProgressBarIndeterminateVisibility(true);
                //显示带进度的进度条
                setProgressBarVisibility(true);
                //设置进度条的进度
                setProgress(4500);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //隐藏不带进度的进度条
                setProgressBarIndeterminateVisibility(false);
                //隐藏带进度的进度条
                setProgressBarVisibility(false);
            }
        });
    }
}
