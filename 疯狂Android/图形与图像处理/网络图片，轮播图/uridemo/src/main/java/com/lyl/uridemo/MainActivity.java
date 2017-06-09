package com.lyl.uridemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ImageCycleView imageCyclView;
    private ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initViewOper();
    }

    private void initData() {
        list = new ArrayList<String>();
        list.add("http://img.ugirls.com/uploads/cooperate/baidu/20160408jzx2.jpg");
        list.add("http://pic1.ooopic.com/uploadfilepic/sheji/2010-01-15/OOOPIC_1982zpwang407_2010011582d1a0a490670dec.jpg");
        list.add("http://img3.imgtn.bdimg.com/it/u=1293564423,1549491162&fm=206&gp=0.jpg");
    }
    private void initViewOper() {

        StartCarousel(list);
    }
    private void initView() {
        imageCyclView = (ImageCycleView)findViewById(R.id.imageCycleView);
    }
    /**
     * 启动轮播的方法  参数是Url的路径集合  在获取完URL之后就调用该方法
     */
    public void StartCarousel( ArrayList<String> mImageUrl){
        /**
         * 设置监听器 和图片路径
         */
        imageCyclView.setImageResources(mImageUrl, mAdCycleViewListener);
    }
    private ImageCycleView.ImageCycleViewListener mAdCycleViewListener = new ImageCycleView.ImageCycleViewListener() {
        @Override
        public void onImageClick(int position, View imageView) {
        }
        @Override
        public void displayImage(String imageURL, ImageView imageView) {
            Picasso.with(MainActivity.this).load(imageURL).into(imageView);
        }
    };


}
