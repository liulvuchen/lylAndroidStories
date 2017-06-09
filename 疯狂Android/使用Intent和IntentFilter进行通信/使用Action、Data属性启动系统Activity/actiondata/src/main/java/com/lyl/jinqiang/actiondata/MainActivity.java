package com.lyl.jinqiang.actiondata;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bn, edit, call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bn = (Button) findViewById(R.id.bn);
        edit = (Button) findViewById(R.id.edit);
        call = (Button) findViewById(R.id.call);
        bn.setOnClickListener(this);
        edit.setOnClickListener(this);
        call.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.bn:
                String data = "http://www.baidu.com";
                //根据指定字符串解析出Uri对象
                Uri uri = Uri.parse(data);
                //为Intent设置Action属性
                intent.setAction(Intent.ACTION_VIEW);
                //设置Data属性
                intent.setData(uri);
                break;
            case R.id.edit:
                //为Intent设置Action属性（动作为：编辑）
                intent.setAction(Intent.ACTION_EDIT);
                String data1 = "content://com.android.contacts/contacts/1";
                //根据指定字符串解析出Uri对象
                Uri uri1 = Uri.parse(data1);
                //设置Data属性
                intent.setData(uri1);
                break;
            case R.id.call:
                //为Intent设置Action属性（动作为：拨号）
                intent.setAction(Intent.ACTION_DIAL);
                String data2 = "tel:18797810526";
                //根据指定字符串解析出Uri对象
                Uri uri2 = Uri.parse(data2);
                //设置Data属性
                intent.setData(uri2);
                break;
        }
        startActivity(intent);
    }
}
