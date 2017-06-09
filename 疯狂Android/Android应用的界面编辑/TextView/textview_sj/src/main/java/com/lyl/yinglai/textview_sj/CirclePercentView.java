package com.lyl.yinglai.textview_sj;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;


/**一个圆形百分比进度 View
 * 用于展示简易的图标
 * Created by Administrator on 2015/12/16.
 */
public class CirclePercentView extends View {

    //圆的半径
    private float mRadius;

    //色带的宽度
    private float mStripeWidth;
    //第一个圆距离第四个圆的距离
    private float mStripeWidth_2;

    //总体大小
    private int mHeight;
    private int mWidth;

    //动画位置百分比进度
    private int mCurPercent;

    //实际百分比进度
    private int mPercent;
    //圆心坐标
    private float x;
    private float y;

    //要画的弧度
    private int mEndAngle;

    //饼状图的颜色
    private int mSmallColor;
    //大圆颜色
    private int mBigColor;
    //小圆的颜色
    private int mXiaoYuanColor;
    //最里面的圆的颜色
    private int mZuiYuanColor;

    //中心百分比文字大小
    private float mCenterTextSize;

    private TypedArray a;

    public CirclePercentView(Context context) {
        this(context, null);
    }

    public CirclePercentView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CirclePercentView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        a = context.obtainStyledAttributes(attrs, R.styleable.CirclePercentView, defStyleAttr, 0);
        //第一个圆距离第二个圆的距离
        mStripeWidth = a.getDimension(R.styleable.CirclePercentView_stripeWidth, PxUtils.dpToPx(50, context));
        //第一个圆距离第四个圆的距离
        mStripeWidth_2=a.getDimension(R.styleable.CirclePercentView_stripeWidth_2, PxUtils.dpToPx(100, context));
        mCurPercent = a.getInteger(R.styleable.CirclePercentView_percent, 1);
        //饼状图的颜色
        mSmallColor = a.getColor(R.styleable.CirclePercentView_smallColor,0xff00ff00);
        //大圆的颜色
        mBigColor = a.getColor(R.styleable.CirclePercentView_bigColor,0xffffffff);
        //小圆的颜色
        mXiaoYuanColor=a.getColor(R.styleable.CirclePercentView_xiaoyuanColor,0xffff0000);
        //最里面的圆的颜色
        mZuiYuanColor=a.getColor(R.styleable.CirclePercentView_zuilimianyuanColor,0xffffffff);

        mCenterTextSize = a.getDimensionPixelSize(R.styleable.CirclePercentView_centerTextSize,PxUtils.spToPx(20,context));
        //大圆的大小
        mRadius = a.getDimensionPixelSize(R.styleable.CirclePercentView_radius,PxUtils.dpToPx(200,context));

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //获取测量模式
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        //获取测量大小
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        if (widthMode == MeasureSpec.EXACTLY && heightMode == MeasureSpec.EXACTLY) {
            mRadius = widthSize / 2;
            x = widthSize / 2;
            y = heightSize / 2;
            mWidth = widthSize;
            mHeight = heightSize;
        }

        if(widthMode == MeasureSpec.AT_MOST&&heightMode ==MeasureSpec.AT_MOST){
            mWidth = (int) (mRadius*2);
            mHeight = (int) (mRadius*2);
            x = mRadius;
            y = mRadius;

        }

        setMeasuredDimension(mWidth,mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {


        mEndAngle = (int) (mCurPercent * 3.6);
        //绘制大圆
        Paint bigCirclePaint = new Paint();
        bigCirclePaint.setAntiAlias(true);
        bigCirclePaint.setColor(mBigColor);


        canvas.drawCircle(x, y, mRadius, bigCirclePaint);


        //绘制小圆,颜色透明
        Paint smallCirclePaint = new Paint();
        smallCirclePaint.setAntiAlias(true);
        smallCirclePaint.setColor(mXiaoYuanColor);
        canvas.drawCircle(x, y, mRadius - mStripeWidth, smallCirclePaint);



        //饼状图
        Paint sectorPaint = new Paint();
        sectorPaint.setColor(mSmallColor);
        sectorPaint.setAntiAlias(true);
        RectF rect = new RectF(0, 0, mWidth, mHeight);

        canvas.drawArc(rect, 270, mEndAngle, true, sectorPaint);

        //绘制小圆,颜色透明(最里面的那个圆)
        Paint smallZuiCirclePaint = new Paint();
        smallCirclePaint.setAntiAlias(true);
        smallCirclePaint.setColor(mZuiYuanColor);
        canvas.drawCircle(x, y, mRadius - mStripeWidth_2, smallZuiCirclePaint);



        //绘制文本
        Paint textPaint = new Paint();
        String text = mCurPercent + "%";

        textPaint.setTextSize(mCenterTextSize);
        float textLength = textPaint.measureText(text);

        textPaint.setColor(Color.WHITE);
        canvas.drawText(text, x - textLength/2, y, textPaint);


    }

    //外部设置百分比数
    public void setPercent(int percent) {
        if (percent > 100) {
            throw new IllegalArgumentException("percent must less than 100!");
        }

        setCurPercent(percent);


    }

    //外部设置颜色
    public void setSmallColor(int color){
        //饼状图的颜色
        mSmallColor = a.getColor(R.styleable.CirclePercentView_smallColor,color);
    }

    //绘制百分比的圆
    public void setBaiFenBi(int num){
        mCurPercent = a.getInteger(R.styleable.CirclePercentView_percent, num);
    }



    //内部设置百分比 用于动画效果
    private void setCurPercent(int percent) {

        mPercent = percent;

        new Thread(new Runnable() {
            @Override
            public void run() {
                int sleepTime = 1;
                for(int i =0;i<mPercent;i++){
                    if(i%20 == 0){
                        sleepTime+=2;
                    }
                    try {
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    mCurPercent = i;
                    CirclePercentView.this.postInvalidate();
                }
            }

        }).start();

    }


}