package com.lyl.jinqiang.activityforresult;

import android.app.ExpandableListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/5/25.
 */
public class SelectCityActivity extends ExpandableListActivity {
    //定义省份数组
    private String[] provinces = new String[]{"广西", "广东", "湖南", "江西", "浙江"};
    private String[][] cities = new String[][]{{"广州", "神族", "珠海", "中山"}, {"桂林", "柳州", "南宁", "北海"}, {"长沙", "岳阳", "衡阳", "株洲"}, {"南昌", "抚州"}, {"杭州", "义务"}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ExpandableListAdapter adapter = new BaseExpandableListAdapter() {
            @Override
            public int getGroupCount() {
                return provinces.length;
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return cities[groupPosition].length;
            }

            @Override
            public Object getGroup(int groupPosition) {
                return provinces[groupPosition];
            }

            //获取指定组位置、指定子列表处的子列表项数据
            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return cities[groupPosition][childPosition];
            }

            @Override
            public long getGroupId(int groupPosition) {
                return groupPosition;
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return childPosition;
            }

            @Override
            public boolean hasStableIds() {
                return true;
            }

            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                LinearLayout ll = new LinearLayout(SelectCityActivity.this);
                ll.setOrientation(LinearLayout.HORIZONTAL);
                ImageView imageView = new ImageView(SelectCityActivity.this);
                ll.addView(imageView);
                TextView textView = getTextView();
                textView.setText(getGroup(groupPosition).toString());
                ll.addView(textView);
                return ll;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                TextView textView = getTextView();
                textView.setText(getChild(groupPosition, childPosition).toString());
                return textView;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return true;
            }

            //动态加载TextView
            private TextView getTextView() {
                AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 64);
                TextView textView = new TextView(SelectCityActivity.this);
                textView.setLayoutParams(lp);
                textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
                textView.setPadding(36, 0, 0, 0);
                textView.setTextSize(20);
                return textView;
            }
        };
        //设置该窗口显示列表
        setListAdapter(adapter);
        getExpandableListView().setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                //获取启动该Activity之前的Activity对应的Intent
                Intent intent = getIntent();
                intent.putExtra("city", cities[groupPosition][childPosition]);
                //设置该SelectCityActivity的结果码，并设置结束之后退回的Activity
                SelectCityActivity.this.setResult(0, intent);
                //结束SelectCityActivity
                SelectCityActivity.this.finish();
                return false;
            }
        });
    }
}
