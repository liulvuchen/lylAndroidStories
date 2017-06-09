package com.lyl.jinqiang.dict;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    MyDatabaseHelper dbHelper;
    Button insert, search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建MyDatabaseHelper对象，指定数据库版本为1，此处使用相对路径即可
        //数据库文件会自动保存在程序的数据文件夹的databases目录下
        dbHelper = new MyDatabaseHelper(this, "myDict.db3", null, 1);
        insert = (Button) findViewById(R.id.insert);
        search = (Button) findViewById(R.id.search);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取用户输入
                String word = ((EditText) findViewById(R.id.word)).getText().toString();
                String detail = ((EditText) findViewById(R.id.detail)).getText().toString();
                Log.i("tttt",word+"!!"+detail);
                //插入生词记录
                insertData(dbHelper.getReadableDatabase(), word, detail);
                //显示提示信息
                Toast.makeText(MainActivity.this, "添加生词成功！", Toast.LENGTH_SHORT).show();
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取用户输入
                String key = ((EditText) findViewById(R.id.key)).getText().toString();
                //执行查询
                Cursor cursor = dbHelper.getReadableDatabase().rawQuery("select * from dict where word like ? or detail like ?;", new String[]{"%" + key + "%", "%" + key + "%"});
                //创建一个Bundle对象
                Bundle data = new Bundle();
                data.putSerializable("data", converCursorToList(cursor));
                //创建一个Intent
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtras(data);
                startActivity(intent);
            }
        });
    }

    protected ArrayList<Map<String, String>> converCursorToList(Cursor cursor) {
        ArrayList<Map<String, String>> result = new ArrayList<>();
        Log.i("tttt",result+"+123");
        //遍历Cursor结果集
        while (cursor.moveToNext()) {
            //将结果集中的数据存入ArrayList中
            Map<String, String> map = new HashMap<>();
            //取出查询记录中第列、第3列的值
            map.put("word", cursor.getString(1));
            map.put("detail", cursor.getString(2));
            Log.i("tttt",cursor.getString(1)+"~~~");
            result.add(map);
        }
        return result;
    }

    private void insertData(SQLiteDatabase db, String word, String detail) {
        //执行插入语句
        db.execSQL("insert into dict values(null,?,?)", new String[]{word, detail});
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //退出程序时关闭MyDatabaseHelper里的SQLiteDatabase
        if (dbHelper != null) {
            dbHelper.close();
        }
    }
}
