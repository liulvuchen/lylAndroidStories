package com.lyl.customtextviewdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * describe
 * authors liuyaolin
 * createTime 2017/6/9 9:07
 */

public class CustomTitleView extends TextView {
    //文本
    private String mTitleText;
    //文本颜色
    private int mTitleTextColor;
    //文本大小
    private int mTitleTextSize;
    //绘制时控制文本绘制的范围
    private Rect mBound;
    private Paint mPaint;

    public CustomTitleView(Context context) {
        this(context, null);
    }

    public CustomTitleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * 获得我自定义的样式属性
     *
     * @param context
     * @param attrs
     * @param defStyleAttr
     */

    public CustomTitleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        /**
         * 获得自定义样式属性
         */
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomTextView, defStyleAttr, 0);
        for (int i = 0; i < a.getIndexCount(); i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.CustomTextView_titleText:
                    mTitleText = a.getString(attr);
                    break;
                case R.styleable.CustomTextView_titleTextColor:
                    // 默认颜色设置为黑色
                    mTitleTextColor = a.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.CustomTextView_titleTextSize:
                    //默认设置为16sp，TypeValue也可以把sp转化为px
                    mTitleTextSize = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
                    break;
            }
        }
        a.recycle();
        //获得绘制文本的宽高
        mPaint = new Paint();
        mPaint.setTextSize(mTitleTextSize);
        mPaint.setColor(mTitleTextColor);
        mBound = new Rect();
        mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mBound);

        //添加一个点击事件
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mTitleText = randomText();
                postInvalidate();
            }
        });
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int width, height;
        if (widthMode == MeasureSpec.EXACTLY) {//设置了明确的值或者是MATCH
            width = widthSize;
        } else {
            float textWidth = mBound.width();
            int desired = (int) (getPaddingLeft() + textWidth + getPaddingRight());
            width = desired;
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            float textHeight = mBound.height();
            int desired = (int) (getPaddingTop() + textHeight + getPaddingBottom());
            height = desired;
        }
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);
        mPaint.setColor(mTitleTextColor);
        canvas.drawText(mTitleText, getWidth() / 2 - mBound.width() / 2, getHeight() / 2 + mBound.height() / 2, mPaint);

        /**
         * 点、线要画在字体后面
         */
        mPaint.setColor(Color.BLACK);
        // 获取到自定义的view宽高
        final int height = getHeight();
        final int width = getWidth();
        // 绘制小圆点
        int[] point;
        for (int i = 0; i < 100; i++) {
            point = getPoint(height, width);
            /**
             * drawCircle (float cx, float cy, float radius, Paint paint)
             * float cx：圆心的x坐标。
             * float cy：圆心的y坐标。
             * float radius：圆的半径。
             * Paint paint：绘制时所使用的画笔。
             */
            canvas.drawCircle(point[0], point[1], 1, mPaint);
        }

        int[] line;
        for (int i = 0; i < 100; i++) {
            line = getLine(height, width);
            /**
             * startX：起始端点的X坐标。
             *startY：起始端点的Y坐标。
             *stopX：终止端点的X坐标。
             *stopY：终止端点的Y坐标。
             *paint：绘制直线所使用的画笔。
             */
            canvas.drawLine(line[0], line[1], line[2], line[3], mPaint);
        }
    }

    public int[] getLine(int height, int width) {
        int[] tempCheckNum = {0, 0, 0, 0};
        for (int i = 0; i < 4; i += 2) {
            tempCheckNum[i] = (int) (Math.random() * width);
            tempCheckNum[i + 1] = (int) (Math.random() * height);
        }
        return tempCheckNum;
    }

    private int[] getPoint(int height, int width) {
        int[] tempCheckNum = {0, 0, 0, 0};
        tempCheckNum[0] = (int) (Math.random() * width);
        tempCheckNum[1] = (int) (Math.random() * height);
        return tempCheckNum;
    }

    private String randomText() {
        Random random = new Random();
        Set<Integer> set = new HashSet<>();
        while (set.size() < 4) {
            int randomInt = random.nextInt(10);
            set.add(randomInt);
        }
        StringBuilder sb = new StringBuilder();
        for (Integer i : set) {
            sb.append("" + i);
        }
        return sb.toString();
    }

}
