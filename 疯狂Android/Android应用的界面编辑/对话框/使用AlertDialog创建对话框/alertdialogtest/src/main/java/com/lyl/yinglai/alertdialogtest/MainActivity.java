package com.lyl.yinglai.alertdialogtest;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {
    TextView show;
    Button btn1, btn2, btn3, btn4, btn5, btn6;
    String[] items = {"大世界看到", "好嗲金士顿", "dasjkjd", "都会拿手机看到", "11111", "赢莱", "djsajdaks", "大世界看到", "好嗲金士顿", "dasjkjd", "都会拿手机看到", "11111", "赢莱", "djsajdaks", "大世界看到", "好嗲金士顿", "dasjkjd", "都会拿手机看到", "11111", "赢莱", "djsajdaks", "大世界看到", "好嗲金士顿", "dasjkjd", "都会拿手机看到", "11111", "赢莱", "djsajdaks"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
    }

    public void init() {
        show = (TextView) findViewById(R.id.show);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
    }

    /*
     *显示提示消息的对话框
     */
    public void simple(View source) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                //设置对话框标题
                .setTitle("简单对话框")
                //设置图标
                .setIcon(R.drawable.bill)
                .setMessage("对话框的测试内容\n第二行内容");
        //为AlertDialog.Builder添加“确定”按钮
        setPositiveButton(builder);
        //为AlertDialog.Builder添加“取消”按钮
        setNegativeButton(builder)
                .create().show();
    }

    //为AlertDialog.Builder添加“确定”按钮
    public AlertDialog.Builder setPositiveButton(AlertDialog.Builder builder) {
        //调用setPositiveButton方法添加“确定”按钮
        return builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                show.setText("单击了【确定】按钮！");
            }
        });
    }

    //为AlertDialog.Builder添加“取消”按钮
    public AlertDialog.Builder setNegativeButton(AlertDialog.Builder builder) {
        //调用setNegativeButton方法添加“取消”按钮
        return builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                show.setText("单击了【取消】按钮！");
            }
        });
    }


    /*
     *简单列表项对话框
     */
    public void simpleList(View source) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                //设置对话框标题
                .setTitle("简单列表项对话框")
                //设置图标
                .setIcon(R.drawable.bill)
                //设置简单的列表项内容
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        show.setText("你选中了《" + items[which] + "》");
                    }
                });
        //为AlertDialog.Builder添加“确定”按钮
        setPositiveButton(builder);
        //为AlertDialog.Builder添加“取消”按钮
        setNegativeButton(builder)
                .create().show();
    }


    /*
     *单选列表项对话框
     */
    public void singleChoice(View source) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                //设置对话框标题
                .setTitle("单选列表项对话框")
                //设置图标
                .setIcon(R.drawable.bill)
                //设置单选列表项，默认选中第二项（索引为1）
                .setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        show.setText("你选中了《" + items[which] + "》");
                    }
                });
        //为AlertDialog.Builder添加“确定”按钮
        setPositiveButton(builder);
        //为AlertDialog.Builder添加“取消”按钮
        setNegativeButton(builder)
                .create().show();
    }


    /*
     *多选列表项对话框
     */
    public void multiChoice(View source) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                //设置对话框标题
                .setTitle("多选列表项对话框")
                //设置图标
                .setIcon(R.drawable.bill)
                //设置多选列表项，设置勾选第2项、第4项
                .setMultiChoiceItems(items, new boolean[]{false, true, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked) {
                            show.setText("你选中了《" + items[which] + "》");
                        }
                    }
                });
        //为AlertDialog.Builder添加“确定”按钮
        setPositiveButton(builder);
        //为AlertDialog.Builder添加“取消”按钮
        setNegativeButton(builder)
                .create().show();

    }


    /*
     *自定义列表项对话框
     */
    public void customList(View source) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                //设置对话框标题
                .setTitle("自定义列表项对话框")
                //设置图标
                .setIcon(R.drawable.bill)
                //设置自定义列表项
                .setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items), null);
        //为AlertDialog.Builder添加“确定”按钮
        setPositiveButton(builder);
        //为AlertDialog.Builder添加“取消”按钮
        setNegativeButton(builder)
                .create().show();
    }


    /*
     *自定义View对话框
     */
    public void customView(View source) {
        //加载app\src\main\res\layout\login.xml界面布局文件
        TableLayout loginForm = (TableLayout) getLayoutInflater().inflate(R.layout.login, null);
        new AlertDialog.Builder(this)
                //设置对话框的图标
                .setIcon(R.drawable.bill)
                //设置对话框的标题
                .setTitle("自定义View对话框")
                //设置对话框显示的View对象
                .setView(loginForm)
                //为对话框设置一个“确定”按钮
                .setPositiveButton("登录", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //此处可执行登录处理
                    }
                })
                //为对话框设置一个“取消”按钮
                .setNegativeButton("登录", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //取消登录，不做任何事情
                    }
                })
                //创建并显示对话框
                .create().show();
    }


    //按钮的监听事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                simple(null);
                break;
            case R.id.btn2:
                simpleList(null);
                break;
            case R.id.btn3:
                singleChoice(null);
                break;
            case R.id.btn4:
                multiChoice(null);
                break;
            case R.id.btn5:
                customList(null);
                break;
            case R.id.btn6:
                customView(null);
                break;
            default:
                break;
        }
    }
}
