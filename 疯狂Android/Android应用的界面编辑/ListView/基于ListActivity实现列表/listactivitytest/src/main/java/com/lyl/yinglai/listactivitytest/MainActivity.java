package com.lyl.yinglai.listactivitytest;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        //无须使用布局文件
        String[] arr={"孙悟空","石晶","吃屎"};
        //创建ArrayAdapter对象
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,arr);
        //设置该窗口显示列表
       setListAdapter(adapter);
    }


}
