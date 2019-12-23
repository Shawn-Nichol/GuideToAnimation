package com.example.guidetoanimation.RevealAnimation;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.guidetoanimation.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RevealFragment extends Fragment {

    View v;
    View circleView;
    public RevealFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_reveal, container, false);

        circleView = v.findViewById(R.id.frag2_circle);
        loadShowCircle();
        loadHideCircle();



        return v;
    }

    private void loadShowCircle(){
        Button button = v.findViewById(R.id.frag2_btn_show_circle);
        button.setOnClickListener(view -> {
            int cx = circleView.getWidth() /2;
            int cy = circleView.getHeight() /2;

            float finalRadius = (float) Math.hypot(cx, cy);

            Animator anim = ViewAnimationUtils.createCircularReveal(circleView, cx, cy, 0, finalRadius);
            circleView.setVisibility(View.VISIBLE);
            anim.start();
        });
    }

    private void loadHideCircle(){
        Button button = v.findViewById(R.id.frag2_btn_hide_circle);
        button.setOnClickListener(view -> {
            int cx = circleView.getWidth() / 2;
            int cy = circleView.getHeight() / 2;

            float initialRadius = (float) Math.hypot(cx, cy);

            Animator anim = ViewAnimationUtils.createCircularReveal(circleView, cx, cy, initialRadius,0);

            anim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    circleView.setVisibility(View.INVISIBLE);
                }
            });

            anim.start();
        });
    }

}
