package com.example.gs.mvpdemo.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.gs.mvpdemo.Fragment.DashboardFragment;
import com.example.gs.mvpdemo.Fragment.HomeFragment;
import com.example.gs.mvpdemo.Fragment.NotificationFragment;
import com.example.gs.mvpdemo.R;


public class FragmentActivity extends AppCompatActivity {
    private FrameLayout content;
    private HomeFragment homeFragment;
    private DashboardFragment dashboardFragment;
    private NotificationFragment notificationFragment;
    private FragmentManager fragmentManager;
    private BottomNavigationView mBottomNavigationView;
    private TabLayout mViewpagerTab;
    private ViewPager mNewsViewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        content = findViewById(R.id.content);
//        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
//        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        initBottomNavigation();
        fragmentManager = getSupportFragmentManager();
        setFragmentPosition(0);

    }


    public void initBottomNavigation() {
        mBottomNavigationView = findViewById(R.id.navigation);
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        setFragmentPosition(0);
                        break;
                    case R.id.navigation_dashboard:
                        setFragmentPosition(1);
                        break;
                    case R.id.navigation_notifications:
                        setFragmentPosition(2);
                        break;

                    default:
                        break;
                }
                return true;
            }
        });
    }

    private void setFragmentPosition(int i) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (i) {
            case 0:
                if (homeFragment == null) {
                    //如果MessageFragment为空，则创建一个并添加到界面上
                    homeFragment = new HomeFragment();
                }
                //如果MessageFragment不为空，则直接将它显示出来
                transaction.replace(R.id.content, homeFragment);

                break;
            case 1:
                if (dashboardFragment == null) {
                    //如果MessageFragment为空，则创建一个并添加到界面上
                    dashboardFragment = new DashboardFragment();
                }
                // 如果MessageFragment不为空，则直接将它显示出来
                transaction.replace(R.id.content, dashboardFragment);

                break;
            case 2:
                if (notificationFragment == null) {
                    //如果MessageFragment为空，则创建一个并添加到界面上
                    notificationFragment = new NotificationFragment();
                }
                //  如果MessageFragment不为空，则直接将它显示出来
                transaction.replace(R.id.content, notificationFragment);

                break;
        }
        transaction.commit();
    }


}
