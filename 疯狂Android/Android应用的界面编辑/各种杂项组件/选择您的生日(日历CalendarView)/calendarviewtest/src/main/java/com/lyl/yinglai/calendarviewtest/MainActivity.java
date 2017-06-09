package com.lyl.yinglai.calendarviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CalendarView cv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cv= (CalendarView) findViewById(R.id.calendarView);
        //为CalendarView组件的日期改变事件添加事件监听器
        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                //使用Toast显示用户选择的日期
                Toast.makeText(MainActivity.this,"你生日是"+year+"年"+month+"月"+dayOfMonth+"日",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
