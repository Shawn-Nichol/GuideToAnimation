package com.example.guidetoanimation.AnimationList;


import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.guidetoanimation.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListAnimationFragment extends Fragment {

    // TODO: AnimationDrawable.
    AnimationDrawable wifiAnimation;
    View v;


    public ListAnimationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_list_animation, container, false);

        // TODO: bind View
        ImageView imageView = v.findViewById(R.id.frag1_image);
        // TODO: set BackgroundResource
        imageView.setBackgroundResource(R.drawable.animation);
        // TODO: link imageView to Animation.
        wifiAnimation = (AnimationDrawable) imageView.getBackground();

        Button btn = v.findViewById(R.id.frag1_btn);
        btn.setOnClickListener(view -> {
            wifiAnimation.start();
        });

        return v;
    }


}
