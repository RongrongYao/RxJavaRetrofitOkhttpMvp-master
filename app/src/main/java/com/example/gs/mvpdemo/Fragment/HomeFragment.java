package com.example.gs.mvpdemo.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
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
    private View homeLayout;

    List<Fragment> list_fragment = new ArrayList<>();
    List<String> list_Title = new ArrayList<>();

    public HomeFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
       homeLayout = inflater.inflate(R.layout.fragment_home, container, false);
        //找到控件
        mViewpagerTab = homeLayout.findViewById(R.id.home_viewpager_tab);
        mNewsViewpager = homeLayout.findViewById(R.id.home_viewpager);

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

        return homeLayout;
    }




    @Override
    public void onResume() {
        super.onResume();
//        mNewsViewpager.setCurrentItem(2);
    }


}

