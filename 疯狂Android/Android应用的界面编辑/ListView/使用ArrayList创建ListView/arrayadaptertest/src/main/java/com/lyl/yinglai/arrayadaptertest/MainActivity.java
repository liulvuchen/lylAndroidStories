package com.lyl.yinglai.arrayadaptertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list1= (ListView) findViewById(R.id.list1);
        //定义一个数组
        String []arr1={"孙悟空","猪八戒","牛魔王"};
        //将数组包装为ArrayAdapter
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this,R.layout.array_item, R.id.TextView,arr1);
        //为ListView设置Adapter
        list1.setAdapter(adapter1);
        ListView list2= (ListView) findViewById(R.id.list2);
        String []arr2={"Java","Android",".net","c"};
        ArrayAdapter<String> adapter2=new ArrayAdapter<String>(this,R.layout.checked_item,R.id.text2,arr2);
        list2.setAdapter(adapter2);
    }
}
