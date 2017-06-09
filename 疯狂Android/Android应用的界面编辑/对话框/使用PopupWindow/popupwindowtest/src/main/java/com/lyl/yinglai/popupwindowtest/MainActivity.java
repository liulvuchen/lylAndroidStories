package com.lyl.yinglai.popupwindowtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //加载R.layout.popup对应的界面布局文件
        View root=this.getLayoutInflater().inflate(R.layout.popup,null);
        //创建PopupWindow对象
        final PopupWindow popup=new PopupWindow(root,560,720);
        Button button= (Button) findViewById(R.id.bn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //以下拉方式显示
                popup.showAsDropDown(v);
                //将PopupWindow显示在指定位置
//                popup.showAtLocation(findViewById(R.id.bn), Gravity.CENTER,20,20);
            }
        });
        //获取PopupWindow中的“关闭”按钮
        root.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //关闭PopupWindow
                popup.dismiss();
            }
        });
    }
}
