package com.example.guidetoanimation.FlingAnimation;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guidetoanimation.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FlingFragment extends Fragment {


    public FlingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fling, container, false);
    }

}
