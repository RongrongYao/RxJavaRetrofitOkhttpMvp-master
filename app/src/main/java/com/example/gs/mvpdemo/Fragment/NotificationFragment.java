package com.example.gs.mvpdemo.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gs.mvpdemo.R;
import com.example.gs.mvpdemo.adapter.MainNewsAdapter;
import com.example.gs.mvpdemo.adapter.ViewPagerAdapter;
import com.example.gs.mvpdemo.bean.StoriesEntity;

import java.util.ArrayList;
import java.util.List;

public class NotificationFragment extends Fragment {

    private ViewPager banner;

    private List<Integer> data;
    private List<StoriesEntity> entityList;

    private int[] icon = {R.drawable.photo1, R.drawable.photo2, R.drawable.photo3};
    private int currentPage = 0;
    private boolean viewPageScrollStatus = false;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (!viewPageScrollStatus) {
                banner.setCurrentItem(++currentPage);
            }
            handler.sendEmptyMessageDelayed(1, 2000);
        }

    };

    public NotificationFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data = new ArrayList<>();
        data.add(R.drawable.photo1);
        data.add(R.drawable.photo2);
        data.add(R.drawable.photo3);


        initDatas();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewlist);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new MainNewsAdapter(getActivity(), entityList));

        banner = view.findViewById(R.id.banner);
        banner.setAdapter(new ViewPagerAdapter(data));

        handler.sendEmptyMessageDelayed(1, 2000);
        setListener();

        return view;
    }

    private void initDatas() {
        entityList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            StoriesEntity data = new StoriesEntity();

            entityList.add(data);
        }
    }


    private void setListener() {
        banner.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                //头尾衔接，无限循环
                if (position == data.size() - 1) {
                    currentPage = 0;
                } else {
                    currentPage = position;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    viewPageScrollStatus = false;
                    banner.setCurrentItem(currentPage, false);
                } else {
                    viewPageScrollStatus = true;
                }

            }
        });
    }
}
