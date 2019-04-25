package com.example.gs.mvpdemo.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.gs.mvpdemo.Fragment.DashboardFragment;
import com.example.gs.mvpdemo.Fragment.HomeFragment;
import com.example.gs.mvpdemo.Fragment.NotificationFragment;
import com.example.gs.mvpdemo.R;

import java.util.ArrayList;

public class FragmentViewpagerActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private  BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_viewpager);
        mViewPager=(ViewPager) findViewById(R.id.mViewPager);//获取到ViewPager
        bottomNavigationView=findViewById(R.id.navigation);

        //设置点击监听
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    //根据navagatin.xml中item的id进行case
                    case R.id.navigation_home:
                        mViewPager.setCurrentItem(0);
                        //跳到对应ViewPager的page
                        break;
                    case R.id.navigation_dashboard:
                        mViewPager.setCurrentItem(1);

                        break;
                    case R.id.navigation_notifications:
                        mViewPager.setCurrentItem(2);

                        break;
                }
                return false;
            }
        });




        //ViewPager的监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                //滑动页面后做的事，这里与BottomNavigationView结合，使其与正确page对应
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //底部导航栏有几项就有几个Fragment
        final ArrayList<Fragment> fgLists=new ArrayList<>(3);
        fgLists.add(new HomeFragment());
        fgLists.add(new DashboardFragment());
        fgLists.add(new NotificationFragment());


        //设置适配器用于装载Fragment
        FragmentPagerAdapter mPagerAdapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fgLists.get(position);  //得到Fragment
            }

            @Override
            public int getCount() {
                return fgLists.size();  //得到数量
            }
        };
        mViewPager.setAdapter(mPagerAdapter);   //设置适配器
        mViewPager.setOffscreenPageLimit(2); //预加载剩下两页

        //以上就将Fragment装入了ViewPager
    }

}
