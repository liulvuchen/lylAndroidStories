package com.lyl.listview1_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView listView;
	  private String[] url;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.main);
			init();
			setDate();
			setListener();
		}
	   private void init()
	   {
		   url=ImageUrl.IMAGES;
		   listView=(ListView) findViewById(R.id.listView);
	   }
	 private void setDate()
	 {
		 listView.setAdapter(new ListAdpter(this, url));
	 }
	private void setListener()
	{
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent intent=new Intent();
				intent.putExtra("url", url[arg2]);
				intent.setClass(MainActivity.this, ShowOneImage.class);
				startActivity(intent);
			}
		});
	}

}
