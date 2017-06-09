package com.example.ruler_view;

import android.app.Activity;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
	private DisplayMetrics dm;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.main_layout);
		RulerView rulerView1 = new RulerView(this, dm);
		relativeLayout.addView(rulerView1);
    }
}
