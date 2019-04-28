package com.example.gs.mvpdemo.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.example.gs.mvpdemo.Fragment.DashboardFragment;
import com.example.gs.mvpdemo.Fragment.HomeFragment;
import com.example.gs.mvpdemo.Fragment.NotificationFragment;
import com.example.gs.mvpdemo.R;


public class FragmentActivity extends AppCompatActivity {

    private BottomNavigationView mBottomNavigationView;

    private HomeFragment homeFragment;
    private DashboardFragment dashboardFragment;
    private NotificationFragment notificationFragment;
    private FragmentManager fragmentManager;


    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(">>>>>>","act----onCreate");
        setContentView(R.layout.activity_fragment);


        initBottomNavigation();

        fragmentManager = getSupportFragmentManager();
        setFragmentPosition(0);

    }


    public void initBottomNavigation() {
        mBottomNavigationView = findViewById(R.id.navigation);
        mBottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
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
        switch (i) {
            case 0:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                }
                switchFragment(homeFragment).commit();
                break;
            case 1:
                if (dashboardFragment == null) {
                    dashboardFragment = new DashboardFragment();
                }
                switchFragment(dashboardFragment).commit();
                break;
            case 2:
                if (notificationFragment == null) {
                    notificationFragment = new NotificationFragment();
                }
                switchFragment(notificationFragment).commit();
                break;
        }
    }


    /**
     * 替换fragment
     *
     * @param targetFragment
     * @return
     */
    private FragmentTransaction switchFragment(Fragment targetFragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (targetFragment.isAdded()) {
            transaction.hide(currentFragment).show(targetFragment);
        } else {
            //第一次使用switchFragment()时currentFragment为null，所以要判断一下
            if (currentFragment != null) {
                transaction.hide(currentFragment);
            }
            transaction.add(R.id.content, targetFragment, targetFragment.getClass().getName());
        }
        currentFragment = targetFragment;
        return transaction;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(">>>>>>","act----onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(">>>>>>","act----onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(">>>>>>","act----onPause");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(">>>>>>","act----onSaveInstanceState");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(">>>>>>","act----onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(">>>>>>","act----onDestroy");
    }
}
