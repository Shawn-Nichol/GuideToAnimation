package com.example.guidetoanimation.MoveView;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.os.Build;
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
public class MoveViewFragment extends Fragment {


    View v;
    View squareView;
    public MoveViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         v = inflater.inflate(R.layout.fragment_move_view, container, false);

        squareView = v.findViewById(R.id.frag2_square);
        loadMoveSquareX();
        loadMoveSquareY();
        loadInterpolator();


        return v;
    }

    private void loadMoveSquareX() {
        Button button = v.findViewById(R.id.frag2_btn_move_square);
        button.setOnClickListener(view -> {
            ObjectAnimator animation = ObjectAnimator.ofFloat(squareView, "translationX", 300f);
            animation.setDuration(2000);
            animation.start();
        });
    }

    private void loadMoveSquareY() {
        Button button = v.findViewById(R.id.frag2_btn_move_square_2);
        button.setOnClickListener(view -> {
            ObjectAnimator animator = ObjectAnimator.ofFloat(squareView, "translationY", 600f);
            animator.setDuration(2000);
            animator.start();
        });
    }

    private void loadInterpolator() {

        Button button = v.findViewById(R.id.frag2_btn_square_interpolator);
        button.setOnClickListener(view -> {

            // arcTo() and PathInterpolator only available on API 21+
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Path path = new Path();
                path.arcTo(0f, 0f, 1000f, 1000f, 270f, -180f, true);
                ObjectAnimator animator = ObjectAnimator.ofFloat(squareView, View.X, View.Y, path);
                animator.setDuration(2000);
                animator.start();
            }
        });
    }

}
