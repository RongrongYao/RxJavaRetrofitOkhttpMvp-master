package com.example.gs.mvpdemo.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gs.mvpdemo.R;
import com.example.gs.mvpdemo.adapter.TabFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment {

    private TabLayout mViewpagerTab;
    private ViewPager mNewsViewpager;
    private View newsLayout;

    List<Fragment> list_fragment = new ArrayList<>();
    List<String> list_Title = new ArrayList<>();

    public NewsFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(">>>>>>","fra----onCreate");

        if (list_fragment.size() == 0) {
            list_fragment.add(new HeadlineFragment());
            list_fragment.add(new RecreationFragment());
            list_fragment.add(new SportFragment());
            list_fragment.add(new TechnologyFragment());

        }
        if (list_Title.size() == 0) {
            list_Title.add("Headline");
            list_Title.add("Recreation");
            list_Title.add("Sport");
            list_Title.add("Technology");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Log.e(">>>>>>","fra----onCreateview");
        newsLayout = inflater.inflate(R.layout.fragment_news1, container, false);
        //找到控件
        mViewpagerTab = newsLayout.findViewById(R.id.news_viewpager_tab);
        mNewsViewpager = newsLayout.findViewById(R.id.news_viewpager);

        TabFragmentPagerAdapter adapter = new TabFragmentPagerAdapter(
                getActivity().getSupportFragmentManager(), list_fragment, list_Title);

        //viewpager 加载adapter
        mNewsViewpager.setAdapter(adapter);

//        mNewsViewpager.setAdapter(new FragmentStatePagerAdapter(getActivity().getSupportFragmentManager()) {
//            @Override
//            public Fragment getItem(int position) {
//                return list_fragment.get(position);
//            }
//
//            @Override
//            public int getCount() {
//                return list_fragment.size();
//            }
//
//            @Override
//            public void destroyItem(ViewGroup container, int position, Object object) {
//                super.destroyItem(container, position, object);
//            }
//
//            @Override
//            public CharSequence getPageTitle(int position) {
//                return list_Title.get(position);
//            }
//        });
        // TableLayout加载viewpager
        mViewpagerTab.setupWithViewPager(mNewsViewpager);

        return newsLayout;
    }




    @Override
    public void onResume() {
        super.onResume();
//        mNewsViewpager.setCurrentItem(2);
        Log.e(">>>>>>","fra---- onResume");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(">>>>>>","fra---- onStart");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(">>>>>>","fra---- onSaveInstanceState");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e(">>>>>>","fra---- onAttach");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(">>>>>>","fra---- onActivityCreated");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(">>>>>>","fra---- onDestroy");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(">>>>>>","fra---- onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(">>>>>>","fra---- onStop");

    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.e(">>>>>>","fra---- onViewStateRestored");

    }
}

