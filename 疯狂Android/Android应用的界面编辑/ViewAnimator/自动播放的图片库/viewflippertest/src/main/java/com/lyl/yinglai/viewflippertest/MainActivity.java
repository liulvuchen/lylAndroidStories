package com.lyl.yinglai.viewflippertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewFlipper = (ViewFlipper) findViewById(R.id.details);
    }

    public void prev(View source) {
        viewFlipper.setInAnimation(this, R.anim.slide_in_right);
        viewFlipper.setOutAnimation(this, R.anim.slide_out_left);
        //显示上一个组件
        viewFlipper.showPrevious();
        //停止自动播放
        viewFlipper.stopFlipping();
    }

    public void next(View source) {
        viewFlipper.setInAnimation(this, R.anim.slide_in_right);
        viewFlipper.setOutAnimation(this, R.anim.slide_out_left);
        //显示下一个组件
        viewFlipper.showNext();
        //停止自动播放
        viewFlipper.stopFlipping();
    }

    public void auto(View source) {
        viewFlipper.setInAnimation(this, R.anim.slide_in_right);
        viewFlipper.setOutAnimation(this, R.anim.slide_out_left);
        //开始自动播放
        viewFlipper.startFlipping();
    }
}
