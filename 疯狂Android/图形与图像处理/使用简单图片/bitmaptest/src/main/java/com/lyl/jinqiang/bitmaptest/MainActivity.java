package com.lyl.jinqiang.bitmaptest;

import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    String[] images = null;
    AssetManager assets = null;
    int currentImg = 0;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = (ImageView) findViewById(R.id.image);
        try {
            assets = getAssets();
            //获取/assets/目录下的所有文件
            images = assets.list("");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取next按钮
        final Button next = (Button) findViewById(R.id.next);
        //为next按钮绑定事件监听器,该监听器将会查看下一张图片
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //如果发生数组越界
                if (currentImg >= images.length) {
                    currentImg = 0;
                }
                //找到下一张图片文件
                while (!images[currentImg].endsWith(".png") && !images[currentImg].endsWith(".jpg") && !images[currentImg].endsWith(".gif")) {
                    currentImg++;
                    //如果已发生数组越界
                    if (currentImg >= images.length) {
                        currentImg = 0;
                    }
                }
                InputStream assetFile = null;
                try {
                    assetFile = assets.open(images[currentImg++]);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                BitmapDrawable bitmapDrawable = (BitmapDrawable) image.getDrawable();
                if (bitmapDrawable != null && !bitmapDrawable.getBitmap().isRecycled()) {
                    bitmapDrawable.getBitmap().recycle();
                }
                //改变ImageView显示的图片
                image.setImageBitmap(BitmapFactory.decodeStream(assetFile));
            }
        });
    }
}
