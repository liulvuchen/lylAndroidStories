package com.lyl.zm;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

public class TongXunAdapter extends BaseAdapter implements SectionIndexer{

	private List<NameModel> list;
	private Context context;
	private final static String TAG = "TongXunAdapter";
	private List<Integer> catlogList = new ArrayList<Integer>();
	public TongXunAdapter(List<NameModel> list,Context context){
		this.list = list;
		this.context = context;
		for(int i = 0 ; i < list.size() ; i++){
			Log.d(TAG, "pinyin:"+list.get(i).getPinyinName());
			if(list.get(i).getFirstLetter() >= 'A' && list.get(i).getFirstLetter() <='z'){
				if(i == 0){
					catlogList.add(i);
					Log.d(TAG, "addPosition:"+i);
				}else{
					if(list.get(i).getFirstLetter() != list.get(i-1).getFirstLetter()){
						catlogList.add(i);
						Log.d(TAG, "addPosition:"+i);
					}
				}
			}
		}
		
		
	}
	
	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if(convertView == null){
			holder = new ViewHolder();
			convertView = LayoutInflater.from(context).inflate(R.layout.item_sort_listview, null);
			holder.catlog =  (TextView) convertView.findViewById(R.id.catlog);
			holder.title = (TextView) convertView.findViewById(R.id.title);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		
		if(catlogList.contains(position)){
			holder.catlog.setText(list.get(position).getFirstLetter()+"");
			holder.catlog.setVisibility(View.VISIBLE);
		}else
		    holder.catlog.setVisibility(View.INVISIBLE);
		
		holder.title.setText(list.get(position).getRealName());
		
		return convertView;
	}

	class ViewHolder{
		TextView catlog;
		TextView title;
	}
	
	@Override
	public Object[] getSections() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPositionForSection(int sectionIndex) {
		// TODO Auto-generated method stub
		Log.d(TAG, "sectionIndex:" + sectionIndex);
		for(int i = 0 ; i < getCount() ; i++){
			
			if(list.get(i).getFirstLetter() == sectionIndex  ){
				return i;
			}
		}
		return -1;
	}

	@Override
	public int getSectionForPosition(int position) {
		return list.get(position).getFirstLetter();
	}

}
