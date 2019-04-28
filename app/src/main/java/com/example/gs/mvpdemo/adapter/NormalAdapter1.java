package com.example.gs.mvpdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gs.mvpdemo.R;

import java.util.List;


public class NormalAdapter1 extends RecyclerView.Adapter<NormalAdapter1.VH> {
    //创建ViewHolder
    public static class VH extends RecyclerView.ViewHolder {
        public final TextView text;
        public final ImageView image1;
        public final ImageView image2;
        public final ImageView image3;
        public final TextView type;
        public final TextView comment;
        public final TextView time;

        public VH(View v) {
            super(v);
            text = (TextView) v.findViewById(R.id.text);
            image1=v.findViewById(R.id.image1);
            image2=v.findViewById(R.id.image2);
            image3=v.findViewById(R.id.image3);
            type=v.findViewById(R.id.type);
            comment=v.findViewById(R.id.comment);
            time=v.findViewById(R.id.time);


        }
    }

    private List<Object> mDatas;
    private Context context;

    public NormalAdapter1(Context context, List<Object> data) {
        this.mDatas = data;
        this.context = context;
    }

    @NonNull
    //在adapter中实现三个方法
    @Override
    public NormalAdapter1.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //layoutInflater.from的指定写法
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item2, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NormalAdapter1.VH holder, final int position) {
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
