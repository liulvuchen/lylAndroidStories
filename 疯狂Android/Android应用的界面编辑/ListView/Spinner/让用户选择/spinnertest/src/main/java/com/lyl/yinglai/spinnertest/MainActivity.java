package com.lyl.yinglai.spinnertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取界面布局文件中的Spinner组件
        spinner= (Spinner) findViewById(R.id.spinner);
        String []arr={"王蓉","家第三代","sakjda","暗示可能打开sadasdksajdkjsakdljasl"};
        //创建ArrayAdapter对象
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,arr);
        //为Spinner设置Adapter
        spinner.setAdapter(adapter);
    }
}
