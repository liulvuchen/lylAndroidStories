package com.lyl.jinqiang.animationdrawabletest;

import android.animation.AnimatorInflater;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2016/5/26.
 */
public class AnimatorTest extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        LinearLayout container = (LinearLayout) findViewById(R.id.container);
        //添加MyAnimationView组件
        container.addView(new MyAnimationView(this));
    }

    public class MyAnimationView extends View {

        public MyAnimationView(Context context) {
            super(context);
            //加载动画资源
            ObjectAnimator colorAnim = (ObjectAnimator) AnimatorInflater.loadAnimator(AnimatorTest.this, R.animator.color_anim);
            colorAnim.setEvaluator(new ArgbEvaluator());
//            //对该View本身应用属性动画
            colorAnim.setTarget(this);
            //开始指定动画
            colorAnim.start();
        }
    }
}
