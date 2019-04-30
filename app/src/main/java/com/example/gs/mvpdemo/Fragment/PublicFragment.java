package com.example.gs.mvpdemo.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gs.mvpdemo.R;

public class PublicFragment extends Fragment {
    private View publicLayout;

    public PublicFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        publicLayout = inflater.inflate(R.layout.fragment_public, container, false);
        return publicLayout;
    }
}
