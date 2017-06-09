package com.lyl.yinglai.gridview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private GridView grid;
    private ImageView imageView;
    private int[] imageIds = new int[]{R.drawable.analysis,
            R.drawable.analysis,
            R.drawable.analysis,
            R.drawable.analysis,
            R.drawable.analysis,
            R.drawable.analysis,
            R.drawable.analysis,
            R.drawable.analysis,
            R.drawable.analysis,
            R.drawable.analysis,
            R.drawable.analysis,
            R.drawable.analysis};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建一个List对象，List对象的元素是Map
        List<Map<String,Object>> listItems=new ArrayList<Map<String,Object>>();
        for(int i=0;i<imageIds.length;i++){
            Map<String,Object> listItem=new HashMap<String,Object>();
            listItem.put("image",imageIds[i]);
            listItems.add(listItem);
        }
        //获取显示图片的ImageView
        imageView= (ImageView) findViewById(R.id.imageView);
        //创建一个SimpleAdapter
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,listItems
        //使用/layout/cell.xml文件作为界面布局
                ,R.layout.cell,new String[]{"image"},new int[]{R.id.image1}
        );
        grid= (GridView) findViewById(R.id.grid01);
        //为GridView设置Adapter
        grid.setAdapter(simpleAdapter);
        //添加列表项被选中的监听器
        grid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               /*
                *感觉没有什么用处，因为下面有单击的监听器
                */
                //显示当前被选中的图片
                imageView.setImageResource(imageIds[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //添加列表项被单击的监听器
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //显示被单击的图片
                imageView.setImageResource(imageIds[position]);
            }
        });

    }
}
