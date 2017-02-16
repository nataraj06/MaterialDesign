package com.android.materialdesign.ui.fragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.materialdesign.R;

public class FloatingActionButtonFragment extends Fragment {

    public FloatingActionButtonFragment() {
        //Mandatory empty constructor for the fragment manager to instantiate the fragment (e.g. upon screen orientation changes).
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_floating_action_button, container, false);
        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.floating_action_button);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), R.string.floating_action_bar, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
