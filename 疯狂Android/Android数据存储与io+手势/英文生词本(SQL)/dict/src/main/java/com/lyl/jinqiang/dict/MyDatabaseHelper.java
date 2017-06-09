package com.lyl.jinqiang.dict;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Administrator on 2016/6/5.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {
    final String CREATE_TABLE_SQL = "create table dict(_id integer primary " + "key autoincrement,word,detail)";

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //第一次使用数据库时自动建表
        db.execSQL(CREATE_TABLE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("tttt", oldVersion + "!!" + newVersion);
    }
}
