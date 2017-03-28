package com.android.materialdesign.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.materialdesign.R;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        //Mandatory empty constructor for the fragment manager to instantiate the fragment (e.g. upon screen orientation changes).
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }
}
