package com.example.gs.mvpdemo.activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.gs.mvpdemo.R;
import com.example.gs.mvpdemo.adapter.NormalAdapter;
import com.example.gs.mvpdemo.adapter.QuickAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView rv;
    private List<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);
       initData();

        rv=(RecyclerView) findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        //rv.setAdapter(new NormalAdapter(data));

        rv.setAdapter(new QuickAdapter(data) {
            @Override
            public int getLayoutId(int viewType) {
                return R.layout.item_1;
            }

            @Override
            protected void convert(VH holder, Object data, final int position) {

                holder.setText(R.id.title,data.toString());
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(RecyclerViewActivity.this,"aaa",Toast.LENGTH_SHORT).show();
                        System.out.println(position+"被点击了");
                    }
                });

            }

            @Override
            public void onBindViewHolder(@NonNull VH viewHolder, int i) {
                convert(viewHolder,data.get(i),i);
            }
        });


    }

    private void initData() {
       data = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++)
        {
            data.add("" + (char) i);
        }
    }


}
