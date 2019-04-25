package com.example.gs.mvpdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gs.mvpdemo.R;
import com.example.gs.mvpdemo.activity.RecyclerViewActivity;

import java.util.List;


public class NormalAdapter extends RecyclerView.Adapter<NormalAdapter.VH> {
    //创建ViewHolder
    public static class VH extends RecyclerView.ViewHolder {
        public final TextView title;

        public VH(View v) {
            super(v);
            title = (TextView) v.findViewById(R.id.title);
        }
    }

    private List<String> mDatas;
    private Context context;

    public NormalAdapter(Context context, List<String> data) {
        this.mDatas = data;
        this.context = context;
    }

    @NonNull
    //在adapter中实现三个方法
    @Override
    public NormalAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //layoutInflater.from的指定写法
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_1, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NormalAdapter.VH holder, final int position) {
        holder.title.setText(mDatas.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, position + "被点击了", Toast.LENGTH_SHORT).show();
                System.out.println(position + "被点击了");


            }

        });

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }


}
