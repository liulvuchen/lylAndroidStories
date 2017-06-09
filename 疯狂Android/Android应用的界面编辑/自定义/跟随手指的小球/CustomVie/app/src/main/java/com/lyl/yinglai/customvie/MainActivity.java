package com.lyl.yinglai.customvie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取布局文件中的RelativeLayout容器
        RelativeLayout root= (RelativeLayout) findViewById(R.id.root);
        //创建DrawView组件
        final DrawView draw=new DrawView(this);
        //设置自定义组件的最小宽度、高度
//        draw.setMinimumWidth(300);
//        draw.setMinimumHeight(500);
        //把自定义的圆，添加到布局内
        root.addView(draw);
    }
}
