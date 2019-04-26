package com.example.gs.mvpdemo.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gs.mvpdemo.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;


public class HeadlineFragment extends Fragment {

    public HeadlineFragment() {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View homeLayout = inflater.inflate(R.layout.fragment_dashboard, container, false);

        SmartRefreshLayout refreshLayout = homeLayout.findViewById(R.id.smartRefreshLayout);
        //刷新的监听事件
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                //请求数据
                refreshLayout.finishRefresh();  //刷新完成
            }
        });
        //加载的监听事件
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishLoadMore();      //加载完成
                refreshLayout.finishLoadMoreWithNoMoreData();  //全部加载完成,没有数据了调用此方法
            }
        });
        return homeLayout;
    }

}
