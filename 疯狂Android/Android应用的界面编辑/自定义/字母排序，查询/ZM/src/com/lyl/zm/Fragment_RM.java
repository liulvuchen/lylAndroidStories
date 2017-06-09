package com.lyl.zm;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.lyl.zm.SildBar.OnCharSelectedListener;

public class Fragment_RM extends Fragment implements OnCharSelectedListener {

	private SildBar sildBar;
	private TextView textView;
	private ListView listView;
	private List<NameModel> list;
	private TongXunAdapter adapter;
	private final static String TAG = "MainActivity";
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.activity_main, container,false);
		textView = (TextView) view.findViewById(R.id.textView);
		sildBar = (SildBar) view.findViewById(R.id.sildBar);
        sildBar.setOnCharSelectedListener(this);
        sildBar.setDialogTextView(textView);
        listView = (ListView) view.findViewById(R.id.listView);
        initData(getResources().getStringArray(R.array.date));
		adapter = new TongXunAdapter(list, view.getContext());
		listView.setAdapter(adapter);
		return view;
	}
	
	private void initData(String[] name) {
           list = new LinkedList<NameModel>();
           HanyuPinyinOutputFormat outputFormat = new HanyuPinyinOutputFormat();
           outputFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
           outputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
           for(int i = 0 ; i < name.length ; i++){
        	   StringBuffer sb = new StringBuffer();
               NameModel model = new NameModel(name[i]);
               char[] nameChars = name[i].toCharArray();
               for(int j = 0 ; j < nameChars.length ; j++){
            	   if(nameChars[j] > 128)
            		   sb.append(PinyinHelper.toHanyuPinyinStringArray(nameChars[j], outputFormat)[0]);
            	   else{
            		   if(nameChars[j] <= 'z' && nameChars[j] >='a'){
            			   nameChars[j] = (char) (nameChars[j] - 'a' + 'A');
            		   }
            		   sb.append(nameChars[j]);
            		   }
               }
               model.setPinyinName(sb.toString());
               model.setFirstLetter(sb.charAt(0));
               list.add(model);
           }
           
           Collections.sort(list, new PinyinComparator());
           
	}

	//Ñ¡ÖÐµÄ×ÖÄ¸
	@Override
	public void charSelected(char c) {
		int position = adapter.getPositionForSection(c);
		Log.d(TAG, "C:" + c + ",position:" + position);
		if(position != -1)
		listView.setSelection(position);
	}

	

}
