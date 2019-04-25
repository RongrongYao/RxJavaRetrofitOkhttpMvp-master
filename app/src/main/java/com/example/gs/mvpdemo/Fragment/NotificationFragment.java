package com.example.gs.mvpdemo.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gs.mvpdemo.R;

public class NotificationFragment extends Fragment {
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View notificationLayout = inflater.inflate(R.layout.fragment_notification, container, false);
        return notificationLayout;
    }
}
