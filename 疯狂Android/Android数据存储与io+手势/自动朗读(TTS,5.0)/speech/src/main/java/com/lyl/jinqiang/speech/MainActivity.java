package com.lyl.jinqiang.speech;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextToSpeech tts;
    EditText editText;
    Button speech, record;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化TextToSpeech对象
        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                //如果装载TTS引擎成功
                if (status == TextToSpeech.SUCCESS) {
                    //设置使用美式英语朗读
                    int result = tts.setLanguage(Locale.US);
                    //如果不支持所设置的语音
                    if (result != TextToSpeech.LANG_COUNTRY_AVAILABLE && result != TextToSpeech.LANG_AVAILABLE) {
                        Toast.makeText(MainActivity.this, "TTS暂不支持这种语言的朗读", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        editText = (EditText) findViewById(R.id.txt);
        speech = (Button) findViewById(R.id.speech);
        record = (Button) findViewById(R.id.record);
        speech.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                //执行朗读
                tts.speak(editText.getText().toString(), TextToSpeech.QUEUE_ADD, null, "speech");
            }
        });
        record.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                //将朗读文本的音频记录到指定文件
                tts.synthesizeToFile(editText.getText().toString(), null, new File("/mnt/sdcard/sound.wav"), "record");
                Toast.makeText(MainActivity.this, "声音记录成功！", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //关闭TextToSpeech对象
        if (tts != null) {
            tts.shutdown();
        }
    }
}
