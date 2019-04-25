package com.example.gs.mvpdemo.Fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gs.mvpdemo.R;
import com.example.gs.mvpdemo.adapter.TabFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private TabLayout mViewpagerTab;
    private ViewPager mNewsViewpager;
    List<Fragment> list_fragment;
    List<String> list_Title;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View homeLayout = inflater.inflate(R.layout.fragment_home, container, false);



        //找到控件
        mViewpagerTab = homeLayout.findViewById(R.id.home_viewpager_tab);
        mNewsViewpager = homeLayout.findViewById(R.id.home_viewpager);
        mViewpagerTab.setupWithViewPager(mNewsViewpager);
//        fragment列表
        list_fragment = new ArrayList<>();
        // tab名的列表
        list_Title = new ArrayList<>(12);
        list_fragment.add(new HeadlineFragment());
        list_fragment.add(new RecreationFragment());
        list_fragment.add(new SportFragment());
        list_fragment.add(new TechnologyFragment());
        list_fragment.add(new HeadlineFragment());
        list_fragment.add(new RecreationFragment());
        list_fragment.add(new SportFragment());
        list_fragment.add(new TechnologyFragment());
        list_fragment.add(new HeadlineFragment());
        list_fragment.add(new RecreationFragment());
        list_fragment.add(new SportFragment());
        list_fragment.add(new TechnologyFragment());
        list_Title.add("头条");
        list_Title.add("娱乐");
        list_Title.add("体育");
        list_Title.add("科技");
        list_Title.add("头条");
        list_Title.add("娱乐");
        list_Title.add("体育");
        list_Title.add("科技");
        list_Title.add("头条");
        list_Title.add("娱乐");
        list_Title.add("体育");
        list_Title.add("科技");
        // 设置名称
//        for (int i = 0; i < list_Title.size(); i++) {
//            mViewpagerTab.addTab(mViewpagerTab.newTab().setText(list_Title.get(i)));
//        }
//        TabFragmentPagerAdapter adapter = new TabFragmentPagerAdapter(
//                getActivity().getSupportFragmentManager(), list_fragment, list_Title);
        // viewpager 加载adapter
//        mNewsViewpager.setAdapter(adapter);
        mNewsViewpager.setAdapter(new FragmentStatePagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list_fragment.get(position);
            }

            @Override
            public int getCount() {
                return list_fragment.size();
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                super.destroyItem(container, position, object);
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return list_Title.get(position);
            }
        });
        // TableLayout加载viewpager
        mViewpagerTab.setupWithViewPager(mNewsViewpager);
        return homeLayout;
    }


}

