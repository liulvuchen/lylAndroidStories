package com.lyl.listview1_demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

public class ListAdpter extends BaseAdapter {
    private Context context;
    private String url[];
    private DisplayImageOptions options;

    public ListAdpter(Context convert, String url[]) {
        this.context = convert;
        this.url = url;
        options = new DisplayImageOptions.Builder()
                .showStubImage(R.drawable.ic_stub)
                .showImageForEmptyUri(R.drawable.ic_empty)
                .showImageOnFail(R.drawable.ic_error)
                .cacheInMemory()
                .cacheOnDisc()
                .displayer(new RoundedBitmapDisplayer(5))
                .build();
    }

    @Override
    public int getCount() {
        return url.length;
    }

    @Override
    public Object getItem(int position) {
        return url[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        view = convertView;
        ViewHolder holder = null;
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_list_image, null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) view.findViewById(R.id.image);
            view.setTag(holder);
            holder.textView = (TextView) view.findViewById(R.id.text);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.textView.setText("第 " + position + "图片");
        //	imageLoader.displayImage(url[position], holder.imageView);   //第一種方法
        ImageLoader.getInstance().displayImage(url[position], holder.imageView, options);
        //	ImagerLoder.getImageLoader().displayImage(url[position], holder.imageView, options);      //实现图片圆角

        ImageLoader.getInstance().displayImage(url[position], holder.imageView);
        return view;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView textView;
    }
}
