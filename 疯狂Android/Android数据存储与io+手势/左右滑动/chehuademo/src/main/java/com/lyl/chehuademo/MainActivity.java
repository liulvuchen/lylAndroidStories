package com.lyl.chehuademo;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnTouchListener,
        GestureDetector.OnGestureListener{
    private static final int FLING_MIN_DISTANCE = 50;
    private static final int FLING_MIN_VELOCITY = 0;
    GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGestureDetector = new GestureDetector(this);
        LinearLayout ll=(LinearLayout)findViewById(R.id.ll);
        ll.setOnTouchListener(this);
        ll.setLongClickable(true);
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        if (motionEvent.getX()-motionEvent1.getX() > FLING_MIN_DISTANCE
                && Math.abs(v) > FLING_MIN_VELOCITY) {
            // Fling left
            Toast.makeText(this, "向左手势", Toast.LENGTH_SHORT).show();
        } else if (motionEvent1.getX()-motionEvent.getX() > FLING_MIN_DISTANCE
                && Math.abs(v) > FLING_MIN_VELOCITY) {
            // Fling right
            Toast.makeText(this, "向右手势", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return mGestureDetector.onTouchEvent(motionEvent);
    }
}
