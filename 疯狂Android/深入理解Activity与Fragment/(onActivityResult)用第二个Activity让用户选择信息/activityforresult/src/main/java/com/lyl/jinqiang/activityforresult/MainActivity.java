package com.lyl.jinqiang.activityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button bn;
    EditText city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取界面上的组件
        bn = (Button) findViewById(R.id.bn);
        city = (EditText) findViewById(R.id.city);
        //为按钮绑定事件监听器
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建需要对应于目标Activity的Intent
                Intent intent = new Intent(MainActivity.this, SelectCityActivity.class);
                //启动指定Activity并等待返回的结果，其中0是请求码，用于标识该请求
                startActivityForResult(intent, 0);
            }
        });
    }

    //重写该方法，该方法以回调的方式来获取指定Activity返回的结果

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //当requestCode、resultCode同时为0时，也就是处理特定的结果
        if (requestCode == 0 && resultCode == 0) {
            //取出Intent里的Extras数据
            Bundle data1 = data.getExtras();
            //取出Bundle中的数据
            String resultCity = data1.getString("city");
            //修改city文本框的内容
            city.setText(resultCity);
        }
    }
}
