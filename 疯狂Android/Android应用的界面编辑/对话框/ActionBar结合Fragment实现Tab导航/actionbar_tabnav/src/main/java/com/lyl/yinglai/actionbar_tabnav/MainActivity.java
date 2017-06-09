package com.lyl.yinglai.actionbar_tabnav;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {
    private static final String SELECTED_ITEM = "selected_item";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ActionBar actionBar = getActionBar();
        boolean is = (actionBar == null);
        Log.i("tttt",is+"!");
        if (!is) {
            //设置ActionBar的导航方式:Tab导航
            actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
            //依次添加三个Tab标签，并为三个Tab标签添加事件监听器
            actionBar.addTab(actionBar.newTab().setText("第一页").setTabListener(this));
            actionBar.addTab(actionBar.newTab().setText("第二页").setTabListener(this));
            actionBar.addTab(actionBar.newTab().setText("第三页").setTabListener(this));
        }

    }

    //当指定Tab标签被选中时激发该方法
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        //创建一个新的Fragment对象
        Fragment fragment = new DummyFragment();
        //创建一个Bundle对象，用于向Fragment传入参数
        Bundle args = new Bundle();
        args.putInt(DummyFragment.ARG_SECTION_NUMBER, tab.getPosition() + 1);
        //向fragment传入参数
        fragment.setArguments(args);
        //获取FragmentTransaction对象
        FragmentTransaction ft1 = getFragmentManager().beginTransaction();
        //使用fragment代替该Activity中的container组件
        ft1.replace(R.id.container, fragment);
        //提交事物
        ft1.commit();
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey(SELECTED_ITEM)) {
            //选中前面保存的索引对应的Fragment页
            getActionBar().setSelectedNavigationItem(savedInstanceState.getInt(SELECTED_ITEM));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //将当前选中的Fragment页的索引保存到Bundle中
        outState.putInt(SELECTED_ITEM, getActionBar().getSelectedNavigationIndex());
    }
}
