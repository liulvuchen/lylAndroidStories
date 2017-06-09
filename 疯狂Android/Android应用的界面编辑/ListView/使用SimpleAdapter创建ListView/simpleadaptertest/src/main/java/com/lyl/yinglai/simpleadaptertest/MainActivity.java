package com.lyl.yinglai.simpleadaptertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private String []names=new String[]{"糊涂","浓郁","李清照","礼拜"};
    private String []descs=new String[]{"可爱的孩子","一个擅长音乐的女孩","一个擅长文学的女性","浪漫主义诗人"};
    private int[] imageIds=new int[]{R.drawable.analysis,R.drawable.balance,R.drawable.bill,R.drawable.user_s};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建一个List集合，List集合的元素是Map
        List<Map<String,Object>> listItems=new ArrayList<Map<String,Object>>();
        for(int i=0;i<names.length;i++){
            Map<String,Object> listItem=new HashMap<String,Object>();
            listItem.put("header",imageIds[i]);
            listItem.put("personName",names[i]);
            listItem.put("desc",descs[i]);
            listItems.add(listItem);
        }
        //创建一个SimpleAdapter
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,listItems,R.layout.simple_item,new String[]{"personName","header","desc"},new int[]{R.id.name,R.id.header,R.id.desc});
        ListView list= (ListView) findViewById(R.id.mylist);
        //为ListView设置Adapter
        list.setAdapter(simpleAdapter);

        //为ListView的列表项的单击事件绑定事件监听器
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //第position项被单击时激发该方法
                Toast.makeText(MainActivity.this,names[position]+"被单击了",Toast.LENGTH_SHORT).show();
            }
        });
        //为ListView的列表项的选中事件绑定事件监听器
        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //第position项被选中时激发该方法
                Toast.makeText(MainActivity.this,names[position]+"被选中了",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
