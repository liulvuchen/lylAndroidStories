package com.lyl.jinqiang.handdraw;

import android.graphics.BlurMaskFilter;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    EmbossMaskFilter emboss;//指定了光源的方向和环境光强度来添加浮雕效果。
    BlurMaskFilter blur;//指定了一个模糊的样式和半径来处理Paint的边缘。
    DrawView drawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        LinearLayout line = new LinearLayout(this);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        //获取创建的宽度和高度
        getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        //创建一个DrawView，该DrawView的宽度、高度与该Activity保持相同
        drawView = new DrawView(this, displayMetrics.widthPixels, displayMetrics.heightPixels);
        line.addView(drawView);
        setContentView(line);
        emboss = new EmbossMaskFilter(new float[]{1.5f, 1.5f, 1.5f}, 0.6f, 6, 4.2f);
        blur = new BlurMaskFilter(8, BlurMaskFilter.Blur.NORMAL);
    }

    //负责创建选项菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        //加载R.menu.menu_main对应的菜单，并添加到menu中
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //菜单项被单击后的回调方法
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //判断单击的是哪个菜单项，并有针对性地做出响应
        switch (item.getItemId()) {
            case R.id.red:
                drawView.paint.setColor(Color.RED);
                item.setChecked(true);
                break;
            case R.id.green:
                drawView.paint.setColor(Color.GREEN);
                item.setChecked(true);
                break;
            case R.id.blue:
                drawView.paint.setColor(Color.BLUE);
                item.setChecked(true);
                break;
            case R.id.width_1:
                drawView.paint.setStrokeWidth(1);
                break;
            case R.id.width_3:
                drawView.paint.setStrokeWidth(3);
                break;
            case R.id.width_5:
                drawView.paint.setStrokeWidth(5);
                break;
            case R.id.blur:
                drawView.paint.setMaskFilter(blur);
                break;
            case R.id.emboss:
                drawView.paint.setMaskFilter(emboss);
                break;
        }
        return true;
    }
}
