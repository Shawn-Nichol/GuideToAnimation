package com.example.guidetoanimation.MyShapes;


import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ToggleButton;

import com.example.guidetoanimation.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyShapesFragment extends Fragment {


    View v;


    public MyShapesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_my_shapes, container, false);

        loadAnimation();
        loadLevelList();

        return v;
    }

    private void loadLevelList() {
        ImageView levelList = v.findViewById(R.id.frag_shape_level_list);
        levelList.setBackgroundResource(R.drawable.my_line_level_list);
        AnimationDrawable levelListAnimation = (AnimationDrawable) levelList.getBackground();

        ToggleButton button = v.findViewById(R.id.frag_shape_line_btn_level_list);
        button.setOnCheckedChangeListener((compoundButton, b) -> {
            if(b) {
                levelListAnimation.start();
            } else {
                levelListAnimation.stop();
            }
        });
    }

    private void loadAnimation() {

        ImageView lineRotation = v.findViewById(R.id.frag_shape_rotation);
        lineRotation.setBackgroundResource(R.drawable.my_line_animation);
        AnimationDrawable lineAnimation = (AnimationDrawable) lineRotation.getBackground();

        ToggleButton button = v.findViewById(R.id.frag_shape_line_btn);
        button.setOnCheckedChangeListener((compoundButton, b) -> {
            if(b) {
                lineAnimation.start();
            } else {
                lineAnimation.stop();
            }
        });
    }

}
