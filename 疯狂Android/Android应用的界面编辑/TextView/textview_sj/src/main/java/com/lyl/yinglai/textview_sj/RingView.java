package com.lyl.yinglai.textview_sj;

/**
 * Created by Administrator on 2016/5/5.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author gongchaobin
 *
 * 圆
 * @version 2012-12-5
 */
public class RingView extends View {

    private Paint paint;
    private Context context;
    private int radius;//半径
    private int color;//颜色值

    public RingView(Context context) {

        // TODO Auto-generated constructor stub
        this(context, null);
    }

    public RingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        this.context = context;
        this.paint = new Paint();
        this.paint.setAntiAlias(true); //消除锯齿
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        int center = getWidth()/2;

        //绘制内圆
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(color);
        canvas.drawCircle(center,center, radius, this.paint);

        //绘制外圆(空心)
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(center,center, 60, this.paint);
        super.onDraw(canvas);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

}
