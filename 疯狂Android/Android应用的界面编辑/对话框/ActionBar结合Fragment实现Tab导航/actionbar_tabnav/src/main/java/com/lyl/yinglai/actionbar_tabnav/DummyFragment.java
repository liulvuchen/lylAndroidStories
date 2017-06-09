package com.lyl.yinglai.actionbar_tabnav;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/5/23.
 */
public class DummyFragment extends Fragment {
    public static final String ARG_SECTION_NUMBER="section_number";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TextView textView=new TextView(getActivity());
        textView.setGravity(Gravity.START);
        //获取创建该Fragment时传入的参数Bundle
        Bundle args=getArguments();
        //设置TextView显示的文本
        textView.setText(args.getInt(ARG_SECTION_NUMBER)+"");
        textView.setTextSize(30);
        //返回该TextView
        return textView;
    }
}
