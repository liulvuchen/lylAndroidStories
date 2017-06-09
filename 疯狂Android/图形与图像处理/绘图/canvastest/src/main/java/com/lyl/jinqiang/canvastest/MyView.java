package com.lyl.jinqiang.canvastest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/5/27.
 */
public class MyView extends View {
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //重写该方法，进行绘图
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //把整张画布绘制成白色
        canvas.drawColor(Color.WHITE);
        Paint paint = new Paint();
        //去锯齿
        paint.setAntiAlias(true);//设置是否抗锯齿
        paint.setColor(Color.BLUE);//设置颜色
        paint.setStyle(Paint.Style.STROKE);//设置Paint的填充风格
        paint.setStrokeWidth(4);//设置画笔的笔触宽度
        int viewWidth = this.getWidth();
        //绘制圆形
        canvas.drawCircle(viewWidth / 10 + 10, viewWidth / 10 + 10, viewWidth / 10, paint);
        //绘制正方形
        canvas.drawRect(10, viewWidth / 5 + 20, viewWidth / 5 + 10, viewWidth * 2 / 5 + 20, paint);
        //绘制矩形
        canvas.drawRect(10, viewWidth * 2 / 5 + 30, viewWidth / 5 + 10, viewWidth / 2 + 30, paint);
        RectF re1 = new RectF(10, viewWidth / 2 + 40, 10 + viewWidth / 5, viewWidth * 3 / 5 + 40);
        //绘制圆角矩形
        canvas.drawRoundRect(re1, 15, 15, paint);
        RectF re11 = new RectF(10, viewWidth * 3 / 5 + 50, 10 + viewWidth / 5, viewWidth * 7 / 10 + 50);
        //绘制椭圆
        canvas.drawOval(re11, paint);
        //定义一个Path对象，封装成一个三角形
        Path path1 = new Path();
        //MoveTo函数和LineTo函数经常备用来画线,moveTo用来画起始位置,lineTo画结束位置
        path1.moveTo(10, viewWidth * 9 / 10 + 60);
        path1.lineTo(viewWidth / 5 + 10, viewWidth * 9 / 10 + 60);
        path1.lineTo(viewWidth / 10 + 10, viewWidth * 7 / 10 + 60);
        path1.close();
        //根据Path进行绘制，绘制三角形
        canvas.drawPath(path1, paint);
        //定义一个Path对象，封闭成一个五角形
        Path path2 = new Path();
        path2.moveTo(10 + viewWidth / 15, viewWidth * 9 / 10 + 70);
        path2.lineTo(10 + viewWidth * 2 / 15, viewWidth * 9 / 10 + 70);
        path2.lineTo(10 + viewWidth / 5, viewWidth + 70);
        path2.lineTo(10 + viewWidth / 10, viewWidth * 11 / 10 + 70);
        path2.lineTo(10, viewWidth + 70);
        path2.close();
        //根据Path进行绘制，绘制五角形
        canvas.drawPath(path2, paint);
        //----------设置填充风格后绘制---------
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        //绘制圆形
        canvas.drawCircle(viewWidth * 3 / 10 + 20, viewWidth / 10 + 10, viewWidth / 10, paint);
        //绘制正方形
        canvas.drawRect(viewWidth / 5 + 20, viewWidth / 5 + 20, viewWidth * 2 / 5 + 20, viewWidth * 2 / 5 + 30, paint);
        RectF re2 = new RectF(viewWidth / 5 + 20, viewWidth / 2 + 40, 20 + viewWidth * 2 / 5, viewWidth * 3 / 5 + 40);
        //绘制圆角矩形
        canvas.drawRoundRect(re2, 15, 15, paint);
        RectF re21 = new RectF(20 + viewWidth / 5, viewWidth * 3 / 5 + 50, 20 + viewWidth * 2 / 5, viewWidth * 7 / 10 + 50);
        //绘制椭圆
        canvas.drawOval(re21, paint);
        //定义一个Path对象，封装成一个三角形
        Path path3 = new Path();
        path3.moveTo(20 + viewWidth / 5, viewWidth * 9 / 10 + 60);
        path3.lineTo(viewWidth * 2 / 5 + 20, viewWidth * 9 / 10 + 60);
        path3.lineTo(viewWidth * 3 / 10 + 20, viewWidth * 7 / 10 + 60);
        path3.close();
        //根据Path进行绘制，绘制三角形
        canvas.drawPath(path3, paint);
        //定义一个Path对象，封装成一个五角形
        Path path4 = new Path();
        path4.moveTo(20 + viewWidth * 4 / 15, viewWidth * 9 / 10 + 70);
        path4.lineTo(20 + viewWidth / 3, viewWidth * 9 / 10 + 70);
        path4.lineTo(20 + viewWidth * 2 / 5, viewWidth + 70);
        path4.lineTo(20 + viewWidth * 3 / 10, viewWidth * 11 / 10 + 70);
        path4.lineTo(20 + viewWidth / 5, viewWidth + 70);
        path4.close();
        //根据Path进行绘制，绘制五角形
        canvas.drawPath(path4, paint);
        //---------设置渐变器后绘制---------
        //为Path设置渐变器
        Shader mShader = new LinearGradient(0, 0, 40, 60, new int[]{Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW}, null, Shader.TileMode.REPEAT);
        paint.setShader(mShader);
        //设置阴影
        paint.setShadowLayer(25, 20, 20, Color.GRAY);
        //绘制圆形
        canvas.drawCircle(viewWidth / 2 + 30, viewWidth / 10 + 10, viewWidth / 10, paint);
        //绘制正方形
        canvas.drawRect(viewWidth * 2 / 5 + 30, viewWidth / 5 + 20, viewWidth * 3 / 5 + 30, viewWidth * 2 / 5 + 20, paint);
        //绘制矩形
        canvas.drawRect(viewWidth * 2 / 5 + 30, viewWidth * 2 / 5 + 30, viewWidth * 3 / 5 + 30, viewWidth / 2 + 30, paint);
        RectF re3 = new RectF(viewWidth * 2 / 5 + 30, viewWidth / 2 + 40, 30 + viewWidth * 3 / 5, viewWidth * 3 / 5 + 40);
        //绘制圆角矩形
        canvas.drawRoundRect(re3, 15, 15, paint);
        RectF re31 = new RectF(30 + viewWidth * 2 / 5, viewWidth * 3 / 5 + 50, 30 + viewWidth * 3 / 5, viewWidth * 7 / 10 + 50);
        //绘制椭圆
        canvas.drawOval(re31, paint);
        //定义一个Path对象，封闭成一个三角形
        Path path5 = new Path();
        path5.moveTo(30 + viewWidth * 2 / 5, viewWidth * 9 / 10 + 60);
        path5.lineTo(30 + viewWidth * 3 / 5 + 30, viewWidth * 9 / 10 + 60);
        path5.lineTo(viewWidth / 2 + 30, viewWidth * 7 / 10 + 60);
        path5.close();
        //根据Path进行绘制，绘制三角形
        canvas.drawPath(path5, paint);
        //定义一个Path对象，封闭成一个五角形
        Path path6 = new Path();
        path6.moveTo(30 + viewWidth * 7 / 15, viewWidth * 9 / 10 + 70);
        path6.lineTo(30 + viewWidth * 8 / 15, viewWidth * 9 / 10 + 70);
        path6.lineTo(30 + viewWidth * 3 / 5, viewWidth + 70);
        path6.lineTo(30 + viewWidth / 2, viewWidth * 11 / 10 + 70);
        path6.lineTo(30 + viewWidth * 2 / 5, viewWidth + 70);
        path6.close();
        //根据Path进行绘制，绘制五角形
        canvas.drawPath(path6, paint);
        //---------设置字符大小后绘制---------
        paint.setTextSize(48);
        paint.setShader(null);
        //绘制7个字符串
        canvas.drawText("圆形", 60 + viewWidth * 3 / 5, viewWidth / 10 + 10, paint);
        canvas.drawText("正方形", 60 + viewWidth * 3 / 5, viewWidth * 3 / 10 + 20, paint);
        canvas.drawText("长方形", 60 + viewWidth * 3 / 5, viewWidth * 1 / 2 + 20, paint);
        canvas.drawText("圆角矩形", 60 + viewWidth * 3 / 5, viewWidth * 3 / 5 + 30, paint);
        canvas.drawText("椭圆形", 60 + viewWidth * 3 / 5, viewWidth * 7 / 10 + 30, paint);
        canvas.drawText("三角形", 60 + viewWidth * 3 / 5, viewWidth * 9 / 10 + 30, paint);
        canvas.drawText("五角形", 60 + viewWidth * 3 / 5, viewWidth * 11 / 10 + 30, paint);
    }
}
