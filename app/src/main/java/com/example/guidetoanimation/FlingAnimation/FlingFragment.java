package com.example.guidetoanimation.FlingAnimation;


import android.animation.Animator;
import android.os.Bundle;

import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FlingAnimation;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.guidetoanimation.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FlingFragment extends Fragment {





    public FlingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fling, container, false);

        ImageView myImage = v.findViewById(R.id.frag_fling_iv);


        FlingAnimation fling = new FlingAnimation(myImage, DynamicAnimation.SCROLL_X);
        fling.setMinValue(0)
                .setMaxValue(10)
                .setFriction(1.1f)
                .start();

        return v;
    }

}
