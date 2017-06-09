package com.lyl.jinqiang.addgesture;

import android.content.DialogInterface;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    GestureOverlayView gestureOverlayView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取手势编辑视图
        gestureOverlayView = (GestureOverlayView) findViewById(R.id.gesture);
        //设置手势的绘制宽度
        gestureOverlayView.setGestureStrokeWidth(4);
        //为gestureOverlayView的手势完成时间绑定事件监听器
        gestureOverlayView.addOnGesturePerformedListener(new GestureOverlayView.OnGesturePerformedListener() {
            @Override
            public void onGesturePerformed(GestureOverlayView overlay, final Gesture gesture) {
                //加载save.xml界面布局代表的视图
                View saveDialog = getLayoutInflater().inflate(R.layout.save, null);
                //获取saveDialog里的show组件
                ImageView imageView = (ImageView) saveDialog.findViewById(R.id.show);
                //获取saveDialog里的gesture_name组件
                final EditText gestureName = (EditText) saveDialog.findViewById(R.id.gesture_name);
                //根据Gesture包含的手势创建一个位图
                Bitmap bitmap = gesture.toBitmap(128, 128, 10, 0xffff0000);
                imageView.setImageBitmap(bitmap);
                //使用对话框显示saveDialog组件
                new AlertDialog.Builder(MainActivity.this)
                        .setView(saveDialog)
                        .setPositiveButton("保存", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //获取指定文件对应的手势库
                                GestureLibrary gestureLib = GestureLibraries.fromFile("/mnt/sdcard/mygestures");
                                //添加手势
                                gestureLib.addGesture(gestureName.getText().toString(), gesture);
                                //保存手势库
//                                gestureLib.save();
                                if (gestureLib.save()) {
                                    Toast.makeText(MainActivity.this, "保存成功！", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(MainActivity.this, "保存失败！", Toast.LENGTH_SHORT).show();
                                }

                            }
                        })
                        .setNegativeButton("取消", null)
                        .show();
            }
        });
    }
}
