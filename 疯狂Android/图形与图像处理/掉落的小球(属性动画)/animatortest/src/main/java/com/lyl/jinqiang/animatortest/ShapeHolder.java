package com.lyl.jinqiang.animatortest;

import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.drawable.ShapeDrawable;

/**
 * Created by Administrator on 2016/5/31.
 */
public class ShapeHolder {
    private float x = 0, y = 0;
    private ShapeDrawable shape;
    private int color;
    private RadialGradient gradient;
    private float alpha = 1f;
    private Paint paint;

    public ShapeHolder(ShapeDrawable s) {
        shape = s;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setShape(ShapeDrawable shape) {
        this.shape = shape;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setGradient(RadialGradient gradient) {
        this.gradient = gradient;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public float getX() {

        return x;
    }

    public float getY() {
        return y;
    }

    public int getColor() {
        return color;
    }

    public RadialGradient getGradient() {
        return gradient;
    }

    public float getAlpha() {
        return alpha;
    }

    public Paint getPaint() {
        return paint;
    }

    public ShapeDrawable getShape() {
        return shape;
    }
}
