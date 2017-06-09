package com.android.yunke.huarenkeji;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * 作者：滑尧伟
 * 邮箱：hyw88866@163.com
 * 公司:北京拓维信息（高能壹佰）股份制有限公司
 * 公司网址: https://www.yunke.com
 * 创建于 2016/4/8 11:31
 */
public class RuleView extends View {

    private static final int rule5Length = 48; //当刻度为5的倍数时的长度
    private static final int ruleOtherLength = 33; //当刻度为其它数的长度
    private static final int rule10Length = 63; //当刻度为10的倍数时的长度

    private int ruleLenght; //尺子长度
    private Paint paint; //绘制需要的画笔
    private int ruleMargin; //尺子每个刻度的距离
    private int ruleLeft; // 尺子X轴开始位置
    private int ruleTop;// 尺子Y轴开始位置
    private int ruleRight;// 尺子X轴结束位置 这个是决定刻度的宽度
    private int ruleBottom = rule10Length;// 尺子Y轴结束位置 这个是决定刻度的高度


    public RuleView(Context context) {
        this(context, null);
    }

    public RuleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RuleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // 初始化画笔，并且给当前View设置一个背景 可以自己修改
        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setTextSize(25);
        setBackgroundColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ruleLenght = getWidth(); //尺子的长度就是当前View的长度
        ruleMargin = 15; // 刻度的间隔 可以自己定义
        ruleLeft = 10; //默认开始X轴从10个PX绘制 12个PX结束 所以刻度的宽度就是2个PX
        ruleRight = 12;

        // 默认开始X轴从5个PX绘制 63个PX结束 所以刻度的高度度就是48个PX
        // 这个是动态发生改变的 遇到5或10的倍数高度就会发生变化
        ruleTop = 5;
        ruleBottom = rule10Length;

        drawRuleX(canvas);//开始绘制
    }

    private void drawRuleX(Canvas canvas) {
        //首先绘制第一个刻度 0的刻度为高度为最高
        canvas.drawRect(ruleLeft, ruleTop, ruleRight, ruleBottom, paint);

        for (int i = 1; i <= ruleLenght / ruleMargin; i++) {//开始绘制剩下的刻度
            //更改开始X轴位置和结束X轴位置 也就是加一个间隔
            ruleLeft += ruleMargin;
            ruleRight += ruleMargin;

            if (i % 10 == 0) {
                //如果是10的倍数 那么ruleBottom赋值为rule10Length 并且绘制数字提示
                ruleBottom = rule10Length;
                canvas.drawText(i / 10 + "", ruleLeft - 5, ruleTop + ruleBottom + 20, paint);
            } else if (i % 5 == 0) {
                //如果是10的倍数 那么ruleBottom赋值为rule5Length
                ruleBottom = rule5Length;
            } else {
                //否则就是ruleOtherLength
                ruleBottom = ruleOtherLength;
            }
            // 继续绘制
            canvas.drawRect(ruleLeft, ruleTop, ruleRight, ruleBottom, paint);
        }
    }


    int downX = 0;
    int moveXMargin;
    @Override
        public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = (int) event.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                int moveX = (int) event.getX();
                //获取到滑动的距离
                moveXMargin += (moveX - downX);
                // 重新布局
                layout(moveXMargin, 0, moveXMargin + getWidth(), getHeight());
                break;
        }
        return true;
    }


}
