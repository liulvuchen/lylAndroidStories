
package com.lyl.demo3.loader;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import cn.finalteam.galleryfinal.widget.GFImageView;

/**
 * Desction:
 * Author:pengjianbo
 * Date:15/12/2 下午6:54
 */
public class XUtilsImageLoader implements cn.finalteam.galleryfinal.ImageLoader {

    private Bitmap.Config mImageConfig;

    public XUtilsImageLoader() {
        this(Bitmap.Config.RGB_565);
    }

    public XUtilsImageLoader(Bitmap.Config config) {
        this.mImageConfig = config;
    }

    @Override
    public void displayImage(Activity activity, String path, GFImageView imageView, Drawable defaultDrawable, int width, int height) {
        ImageOptions options = new ImageOptions.Builder()
                .setLoadingDrawable(defaultDrawable)
                .setFailureDrawable(defaultDrawable)
                .setConfig(mImageConfig)
                .setSize(width, height)
                .setCrop(true)
                .setUseMemCache(false)
                .build();
        x.image().bind(imageView, "file://" + path, options);

    }

    @Override
    public void clearMemoryCache() {
    }
}
