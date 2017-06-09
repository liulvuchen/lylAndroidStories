package com.lyl.jinqiang.listener_lyl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by Administrator on 2016/5/23.
 */
public class PlainView extends View {
    public float currentX;//飞机的X点
    public float currentY;//飞机的Y点
    Bitmap plane;

    public PlainView(Context context) {
        super(context);
        //定义飞机图片
        plane = BitmapFactory.decodeResource(context.getResources(), R.drawable.plane);
        //给它焦点
        setFocusable(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //创建画笔
        Paint p = new Paint();
        //绘制飞机
        canvas.drawBitmap(plane, currentX, currentY, p);
    }
}
