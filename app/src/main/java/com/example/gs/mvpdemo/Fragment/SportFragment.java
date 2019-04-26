package com.example.gs.mvpdemo.Fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gs.mvpdemo.R;
import com.example.gs.mvpdemo.adapter.NormalAdapter;

import java.util.ArrayList;
import java.util.List;

public class SportFragment extends android.support.v4.app.Fragment {
    private View sportLayout;
    private List<String> data;

    public SportFragment(){

    }
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        sportLayout = inflater.inflate(R.layout.fragment_sport, container, false);
        initData();
        initRecyclerView();
        return sportLayout;
    }
    private void initData() {
        data=new ArrayList<>();
        for(int i='A';i<'z';i++) {
            data.add("i");

        }
    }
    private void initRecyclerView() {
        RecyclerView recyclerView=sportLayout.findViewById(R.id.recyclerViewSport);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new NormalAdapter(getActivity(),data));
    }


}
