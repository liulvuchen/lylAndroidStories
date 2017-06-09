package com.lyl.yinglai.choosedate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatePicker datePicker= (DatePicker) findViewById(R.id.datePicker);


        //初始化DatePicker组件，初始化时指定监听器
        datePicker.init(0, 0, 0, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                //显示当前日期、时间
                showDate(year,monthOfYear,dayOfMonth);
            }
        });
    }

    //定义在EditText中显示当前日期、时间的方法
    private void showDate(int year,int month,int day){
        EditText show= (EditText) findViewById(R.id.show);
        show.setText("您的购买日期为:"+year+"年"+(month+1)+"月"+day+"日");
    }

}
