package com.lyl.zm;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class SildBar extends View {

	private final static String TAG = "SildBar";
	public final static String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ#";
	private float width, height, singleHeight;
	private Paint paint;
	private TextView textView;
	

	public void setDialogTextView(TextView textView) {
		this.textView = textView;
	}

	public SildBar(Context context) {
		super(context);
	}

	public SildBar(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public SildBar(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		height = getMeasuredHeight();
		width = getMeasuredWidth();
		singleHeight = height / CHARS.length();
		// Log.d(TAG,
		// "height:"+height+",width:"+width+",singleHeight:"+singleHeight);
		paint = new Paint();
		paint.setTypeface(Typeface.DEFAULT_BOLD);
		paint.setColor(Color.parseColor("#000000"));
		paint.setAntiAlias(true);
		paint.setTextSize(20.0f);
		for (int i = 0; i < CHARS.length(); i++) {
			float x = width / 2 - paint.measureText(CHARS.charAt(i) + "") / 2;
			float y = singleHeight * (i + 1);
			canvas.drawText(CHARS.charAt(i) + "", x, y, paint);
		}
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent event) {
		float y = event.getY();
		switch (event.getAction()) {
		case MotionEvent.ACTION_UP:
			y = event.getY();
			int index = (int) (y / singleHeight);
			if (charSelectedListener != null)
				// charSelectedListener.charSelected(CHARS.charAt(index));
				textView.setVisibility(View.INVISIBLE);
			setBackgroundColor(Color.parseColor("#00ffffff"));
			Log.d(TAG, "dispatchTouchEvent: up index = " + index);
			charSelectedListener.charSelected(CHARS.charAt(index));
			break;
		default:
			setBackgroundResource(R.drawable.sortlistview_sidebar_background);
			y = event.getY();
			int index1 = (int) (y / singleHeight);
			// Log.d(TAG, "dispatchTouchEvent: default index = " + index1 +
			// ",y = " + y);
			textView.setVisibility(View.VISIBLE);
			if (index1 >= 0 && index1 < CHARS.length()) {
				textView.setText(CHARS.charAt(index1) + "");
				charSelectedListener.charSelected(CHARS.charAt(index1));
			}
			break;
		}
		return true;
	}

	public interface OnCharSelectedListener {
		void charSelected(char c);
	}

	private OnCharSelectedListener charSelectedListener;

	public void setOnCharSelectedListener(
			OnCharSelectedListener charSeleectedListener) {
		this.charSelectedListener = charSeleectedListener;
	}

}
