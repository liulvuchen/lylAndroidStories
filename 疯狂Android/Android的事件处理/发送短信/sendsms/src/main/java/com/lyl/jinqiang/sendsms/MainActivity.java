package com.lyl.jinqiang.sendsms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText address,content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取页面中收件人地址、短信内容
        address= (EditText) findViewById(R.id.address);
        content= (EditText) findViewById(R.id.content);
        Button bn= (Button) findViewById(R.id.send);
        bn.setOnLongClickListener(new SendSmsListener(this,address,content));
    }
}
