package com.lyl.yinglai.ratingbartest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = (ImageView) findViewById(R.id.image);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.rating);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            //当星级评分条的评分发生改变时触发该方法
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                //动态改变图片的透明度，其中255是星级评分条的最大值
                //5个星星就代表最大值255
                image.setImageAlpha((int) (rating * 255 / 5));
            }
        });
    }
}
