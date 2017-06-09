package com.lyl.jinqiang.gesturezoom;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {
    //定义手势检测器实例
    GestureDetector detector;
    ImageView imageView;
    //初始化的图片资源
    Bitmap bitmap;
    //定义图片的宽、高
    int width, height;
    //记录当前的缩放比
    float currentScale = 1;
    //控制图片缩放的Matrix对象
    Matrix matrix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建手势检测器
        detector = new GestureDetector(this, this);
        imageView = (ImageView) findViewById(R.id.show);
        matrix = new Matrix();
        //获取被缩放的源图片
        bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.mixview_1);
        //获得位图宽
        width = bitmap.getWidth();
        //获得位图高
        height = bitmap.getHeight();
        //设置ImageView初始化时显示的图片
        imageView.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.mixview_1));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return detector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        velocityX = velocityX > 4000 ? 4000 : velocityX;
        velocityX = velocityX < -4000 ? -4000 : velocityX;
        //根据手势的速度来计算缩放比，如果velocityX>0，则放大图片，否则缩小图片
        currentScale += currentScale * velocityX / 4000.0f;
        //保证currentScale不会等于0
        currentScale = currentScale > 0.01 ? currentScale : 0.01f;
        //重置Matrix
        matrix.reset();
        //缩放Matrix
        matrix.setScale(currentScale, currentScale, 160, 200);
        BitmapDrawable tmp = (BitmapDrawable) imageView.getDrawable();
        //如果图片还未回收，先强制回收该图片
        if (!tmp.getBitmap().isRecycled()) {
            tmp.getBitmap().recycle();
        }
        //根据原始位图和Matrix创建新图片
        Bitmap bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        //显示新的位图
        imageView.setImageBitmap(bitmap2);
        return true;
    }
}
