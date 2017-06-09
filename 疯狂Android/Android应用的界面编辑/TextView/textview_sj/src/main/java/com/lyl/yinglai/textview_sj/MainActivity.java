package com.lyl.yinglai.textview_sj;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mButton;
    private CirclePercentView mCirclePercentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCirclePercentView = (CirclePercentView) findViewById(R.id.circleView);
        mButton = (Button) findViewById(R.id.button);
        mCirclePercentView.setPercent(50+1);
        mCirclePercentView.setSmallColor(0xffb3f699);
        int a_1=ShuanSu(51);
        mCirclePercentView.setBaiFenBi(a_1);
        mCirclePercentView.setPercent(20+1);
        mCirclePercentView.setSmallColor(0xffffff00);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                int n = (int) (Math.random() * 100);
                mCirclePercentView.setPercent(50+1);
                mCirclePercentView.setSmallColor(0xffb3f699);
                int a_1=ShuanSu(51);
                mCirclePercentView.setBaiFenBi(a_1);
                mCirclePercentView.setPercent(20+1);
                mCirclePercentView.setSmallColor(0xffffff00);
            }
        });
    }

    public int ShuanSu(int num){
        int score=(int)(num*54/225*3.6);
        return score;
    }

}
