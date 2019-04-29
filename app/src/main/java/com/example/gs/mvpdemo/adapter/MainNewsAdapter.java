package com.example.gs.mvpdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gs.mvpdemo.R;
import com.example.gs.mvpdemo.bean.StoriesEntity;

import java.util.List;

public class MainNewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_TOPIC = 1;
    private static final int TYPE_TITLE = 2;

    private List<StoriesEntity> mData;

    private Context context;


    public MainNewsAdapter(Context context, List<StoriesEntity> data) {
        this.context = context;
        mData = data;
    }

    public void addList(List<StoriesEntity> items) {
        mData.clear();
        mData.addAll(items);
        notifyDataSetChanged();
    }


    public StoriesEntity getItem(int position) {
        return mData.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        StoriesEntity storiesEntity = mData.get(position);
//        if (storiesEntity.getType() == 1) {
//            return TYPE_TOPIC;
//        } else {
//            return TYPE_TITLE;
//        }
        if (position % 2 == 1) {
            return TYPE_TOPIC;
        } else {
            return TYPE_TITLE;
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_TOPIC) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_1, parent, false);
            MainTopicViewHolder mainTopicViewHolder = new MainTopicViewHolder(v);
            return mainTopicViewHolder;
        } else {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item2, parent, false);
            MainHeaderViewHolder mainNewsViewHolder = new MainHeaderViewHolder(v);
            return mainNewsViewHolder;
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MainTopicViewHolder) {
        } else {
        }
    }

    @Override
    public int getItemCount() {
        if (mData != null) {
            return mData.size();
        }
        return 0;
    }

    public class MainTopicViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title;
        ImageView image;

        public MainTopicViewHolder(View itemView) {
            super(itemView);
//            image = itemView.findViewById(R.id.image2);
//            if(itemView==mHeaderView) return;
//            tv_topic=itemView.findViewById(R.id.topic);

        }
    }

    public class MainHeaderViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title;
        ImageView iv_title;

        public MainHeaderViewHolder(View itemView) {
            super(itemView);
//            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
//            iv_title = (ImageView) itemView.findViewById(R.id.iv_title);
        }
    }

}
