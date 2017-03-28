package com.android.materialdesign.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.materialdesign.R;

public class FragmentB extends Fragment {


    public FragmentB() {
        //Mandatory empty constructor for the fragment manager to instantiate the fragment (e.g. upon screen orientation changes).
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false);
    }
}
