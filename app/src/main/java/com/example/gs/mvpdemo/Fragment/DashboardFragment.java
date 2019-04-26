package com.example.gs.mvpdemo.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gs.mvpdemo.R;
import com.example.gs.mvpdemo.activity.RecyclerViewActivity;
import com.example.gs.mvpdemo.adapter.NormalAdapter;
import com.example.gs.mvpdemo.adapter.QuickAdapter;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {
   private View dashboardLayout;
   private List<String> data;
    public DashboardFragment() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         dashboardLayout = inflater.inflate(R.layout.fragment_dashboard, container, false);
        initData();
        initRecyclerView();

        return dashboardLayout;
    }

    public void initData() {
        data = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++)
        {
            data.add("" + (char) i);
        }
    }

    public void initRecyclerView() {
        RecyclerView recyclerView=dashboardLayout.findViewById(R.id.recyclerView1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

//        recyclerViewAdapter=new QuickAdapter(data) {
////            @Override
////            public int getLayoutId(int viewType) {
////                return R.layout.item_1;
////            }
////
////            @Override
////            protected void convert(VH holder, Object data, final int position) {
////
////                holder.setText(R.id.title,data.toString());
////                holder.itemView.setOnClickListener(new View.OnClickListener() {
////                    @Override
////                    public void onClick(View v) {
////                        Toast.makeText(getActivity(),"aaa",Toast.LENGTH_SHORT).show();
////                        System.out.println(position+"被点击了");
////                    }
////                });
////
////            }
////
////            @Override
////            public void onBindViewHolder(@NonNull VH viewHolder, int i) {
////                convert(viewHolder,data.get(i),i);
////            }
////        };
////

        recyclerView.setAdapter(new NormalAdapter(getActivity(),data));

    }
}

