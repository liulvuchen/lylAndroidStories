package com.lyl.yinglai.autocompletetextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {
    private AutoCompleteTextView auto;
    private MultiAutoCompleteTextView mauto;
    //定义字符串数组，作为提示的文本
    String[] books=new String[]{
       "石晶", "王强","王强刘某人","AAAA","zzz","疯狂"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建一个ArrayAdapter,封装数组
        ArrayAdapter<String> aa=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,books);
        auto= (AutoCompleteTextView) findViewById(R.id.auto);
        //设置Adapter
        auto.setAdapter(aa);
        mauto= (MultiAutoCompleteTextView) findViewById(R.id.mauto);
        //设置Adapter
        mauto.setAdapter(aa);
        //为MultiAutoCompleteTextView设置分隔符
        mauto.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

    }
}
