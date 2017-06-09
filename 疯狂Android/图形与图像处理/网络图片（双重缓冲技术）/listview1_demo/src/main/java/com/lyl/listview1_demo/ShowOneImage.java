package com.lyl.listview1_demo;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;

public class ShowOneImage extends Activity{
	private ImageView imageView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_one_image);
		imageView=(ImageView) findViewById(R.id.image);
		ImageLoader.getInstance().loadImage(getIntent().getStringExtra("url"), new SimpleImageLoadingListener()
		{
			public void onLoadingComplete(String imageUri, View view, android.graphics.Bitmap loadedImage) {
				imageView.setImageBitmap(loadedImage);
			};
		public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
			Toast.makeText(ShowOneImage.this,"加载失败", Toast.LENGTH_LONG).show();
		};
		@Override
	    public void onLoadingStarted(String imageUri, View view) {
			
	    }
	    @Override
	    public void onLoadingCancelled(String imageUri, View view) {
	    }
		}
		);
	
	}

}
