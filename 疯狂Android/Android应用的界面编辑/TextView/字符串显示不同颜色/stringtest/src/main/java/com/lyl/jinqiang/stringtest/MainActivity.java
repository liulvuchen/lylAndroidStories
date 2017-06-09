package com.lyl.jinqiang.stringtest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView myTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myTextView = (TextView) this.findViewById(R.id.myTextView);
        //创建一个 SpannableString对象
        SpannableString sp = new SpannableString("这句话中有百度超链接,有高亮显示，这样，或者这样，还有斜体.");
        //设置高亮样式一
        sp.setSpan(new BackgroundColorSpan(Color.RED), 17, 19, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //SpannableString对象设置给TextView
        myTextView.setText(sp);
    }
}
