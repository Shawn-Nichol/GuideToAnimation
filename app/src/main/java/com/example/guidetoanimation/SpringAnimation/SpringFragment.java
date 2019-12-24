package com.example.guidetoanimation.SpringAnimation;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guidetoanimation.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpringFragment extends Fragment {

    View v;

    public SpringFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_spring, container, false);

        View img = v.findViewById(R.id.frag_spring_icon);

        // Setting up a spring animation to animate the views translation Y property with the final
        // spring position at 0.


        return v;
    }

}
