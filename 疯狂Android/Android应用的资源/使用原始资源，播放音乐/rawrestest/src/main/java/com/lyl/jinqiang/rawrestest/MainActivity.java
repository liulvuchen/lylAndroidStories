package com.lyl.jinqiang.rawrestest;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer1 = null;
    MediaPlayer mediaPlayer2 = null;
    boolean is = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //直接根据声音文件的ID来创建MediaPlayer
        mediaPlayer1 = MediaPlayer.create(this, R.raw.bomb);
        //获取该应用的AssetManager
        AssetManager am = getAssets();
        try {
            //获取指定文件对应的AssetFileDescriptor
            AssetFileDescriptor adf = am.openFd("shot.mp3");
            mediaPlayer2 = new MediaPlayer();
            //使用MediaPlayer加载指定的声音文件
            mediaPlayer2.setDataSource(adf.getFileDescriptor());
            mediaPlayer2.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //获取第一个按钮，并为它绑定事件监听器
        Button playRaw = (Button) findViewById(R.id.playRaw);
        playRaw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (is) {
                    //播放声音
                    mediaPlayer1.start();
                    is = false;
                } else {
                    Toast.makeText(MainActivity.this, "歌停止播放~，", Toast.LENGTH_SHORT).show();
                    is = true;
                    mediaPlayer1.pause();
                }

            }
        });
        Button playAsset = (Button) findViewById(R.id.playAsset);
        playAsset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (is) {
                    //播放声音
                    mediaPlayer2.start();
                    is = false;
                } else {
                    Toast.makeText(MainActivity.this, "歌停止播放~，", Toast.LENGTH_SHORT).show();
                    is = true;
                    mediaPlayer2.pause();
                }
            }
        });
    }
}
