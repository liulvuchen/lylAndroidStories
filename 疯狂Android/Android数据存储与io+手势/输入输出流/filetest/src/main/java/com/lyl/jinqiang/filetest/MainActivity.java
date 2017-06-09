package com.lyl.jinqiang.filetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class MainActivity extends AppCompatActivity {
    final String FILE_NAME = "crazyit.bin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println(new StringBuilder("a").append("b").append("c").toString());
        //获取两个按钮
        final Button read = (Button) findViewById(R.id.read);
        final Button write = (Button) findViewById(R.id.write);
        //获取两个文本框
        final EditText edit1 = (EditText) findViewById(R.id.edit1);
        final EditText edit2 = (EditText) findViewById(R.id.edit2);
        //为write按钮绑定事件监听器
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //将edit1中的内容写入文件中
                write(edit1.getText().toString());
                edit1.setText("");
            }
        });
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //读取指定文件中的内容，并显示出来
                edit2.setText(read());
            }
        });
    }

    private String read() {
        try {
            FileInputStream fis = openFileInput(FILE_NAME);
            byte[] buff = new byte[1024];
            int hasRead = 0;
            StringBuilder sb = new StringBuilder("");
            //读取文件内容
            while ((hasRead = fis.read(buff)) > 0) {
                sb.append(new String(buff, 0, hasRead));
            }
            //关闭文件输入流
            fis.close();
            return sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

        }
        return null;
    }

    private void write(String content) {
        try {
            //以追加方式打开文件输出流
            FileOutputStream fos = openFileOutput(FILE_NAME, MODE_APPEND);
            //将FileOutputStream包装成PrintStream
            PrintStream ps = new PrintStream(fos);
            //输出文件内容
            ps.println(content);
            //关闭文件输出流
            ps.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
