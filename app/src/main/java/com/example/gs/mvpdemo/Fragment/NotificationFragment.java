package com.example.gs.mvpdemo.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.gs.mvpdemo.R;
import com.example.gs.mvpdemo.adapter.NormalAdapter;
import com.example.gs.mvpdemo.adapter.NormalAdapter1;
import com.example.gs.mvpdemo.adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class NotificationFragment extends Fragment {
    private ViewPager banner;
    private List<Integer> data;
    private int currentPage=0;
    private boolean viewPageScrollStatus=false;
    private List<Object> data1;
    private  View notificationLayout;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(!viewPageScrollStatus){
                banner.setCurrentItem(++currentPage);
            }
            handler.sendEmptyMessageDelayed(1,2000);
        }

    };

    public NotificationFragment(){

    }


    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        notificationLayout = inflater.inflate(R.layout.fragment_notification, container, false);
        data=new ArrayList<>();
        data.add(R.drawable.photo1);
        data.add(R.drawable.photo2);
        data.add(R.drawable.photo3);
        banner=notificationLayout.findViewById(R.id.banner);
        banner.setAdapter(new ViewPagerAdapter(data));
        banner.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){

            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                //头尾衔接，无限循环
                if(position==data.size()-1){
                    currentPage=0;
                }else {
                    currentPage=position;
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
        handler.sendEmptyMessageDelayed(1, 2000);
        initDatas();
        initRecyclerView();


        return notificationLayout;
    }

    private void initRecyclerView() {
        RecyclerView recyclerView=notificationLayout.findViewById(R.id.recyclerViewlist);
        recyclerView.setAdapter(new NormalAdapter1(getActivity(),data1));
    }

    private void initDatas() {
        data1=new ArrayList<>();

    }


}
