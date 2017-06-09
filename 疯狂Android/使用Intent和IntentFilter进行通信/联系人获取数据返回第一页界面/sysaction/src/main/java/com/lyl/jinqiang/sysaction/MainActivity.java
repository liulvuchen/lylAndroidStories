package com.lyl.jinqiang.sysaction;

import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    final int PICK_CONTACT = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bn = (Button) findViewById(R.id.bn);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                //设置Intent的Action属性
                intent.setAction(Intent.ACTION_GET_CONTENT);
                //设置Intent的Type属性
                intent.setType("vnd.android.cursor.item/phone");
                //启动Activity，并希望获取该Activity的结果
                startActivityForResult(intent, PICK_CONTACT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case (PICK_CONTACT):
                if (resultCode == 0) {
                    boolean is = data == null;
                    //获取返回的数据
                    Uri contactData = data.getData();
                    CursorLoader cursorLoader = new CursorLoader(this, contactData, null, null, null, null);
                    //查询联系人信息
                    Cursor cursor = cursorLoader.loadInBackground();
                    //如果查询到指定联系人
                    if (cursor.moveToFirst()) {
                        String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                        //获取联系人的姓名
                        String name = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME));
                        String phoneNumber = "此联系人暂未输入电话号码";
                        //根据联系人查询该联系人的详细信息
                        Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" + contactId, null,
                                null);
                        if (phones.moveToFirst()) {
                            //取出电话号码
                            phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        }
                        Log.i("tttt", name + "!" + phoneNumber);
                        //关闭游标
                        phones.close();
                        EditText show = (EditText) findViewById(R.id.show);
                        //显示联系人的名称
                        show.setText(name);
                        EditText phone = (EditText) findViewById(R.id.phone);
                        //显示联系人的电话号码
                        phone.setText(phoneNumber);
                    }
                    //关闭游标
                    cursor.close();
                }
                break;
        }
    }
}
