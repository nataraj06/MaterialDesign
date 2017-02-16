package com.android.materialdesign.ui.fragments;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.materialdesign.R;

public class SnackBarFragment extends Fragment {

    public SnackBarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_snackbar, container, false);

        AppCompatButton showSnackbar = (AppCompatButton) view.findViewById(R.id.snackbar_action_btn);

        showSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUpSnackBar();
            }
        });
        return view;
    }

    void setUpSnackBar() {
        Snackbar.make(getView().findViewById(R.id.root_layout), "This is Snackbar", Snackbar.LENGTH_LONG)
                .setAction("Action", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // do nothing
                    }
                })
                .show();
    }
}
