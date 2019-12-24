package com.example.guidetoanimation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;


import com.example.guidetoanimation.AnimationList.ListAnimationFragment;
import com.example.guidetoanimation.FlingAnimation.FlingFragment;
import com.example.guidetoanimation.MoveView.MoveViewFragment;
import com.example.guidetoanimation.MyShapes.MyShapesFragment;
import com.example.guidetoanimation.RevealAnimation.RevealFragment;
import com.example.guidetoanimation.SpringAnimation.SpringFragment;
import com.example.guidetoanimation.Zoom.ZoomFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar mToolbar;
    private NavigationView mNavigationView;
    DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadToolbar();
        loadNavigation();
        loadFragment();
    }

    private void loadToolbar() {
        mToolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(mToolbar);
    }
    private void loadFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ListAnimationFragment fragment = new ListAnimationFragment();
        ft.replace(R.id.main_fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }

    private void loadNavigation() {
        mDrawerLayout = findViewById(R.id.main_nav_drawer);
        mNavigationView = findViewById(R.id.main_nav_view);
        mNavigationView.setNavigationItemSelectedListener(MainActivity.this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar,
                R.string.close_drawer, R.string.open_drawer);

        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch(menuItem.getItemId()) {
            case R.id.menu_nav_1:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container,
                        new ListAnimationFragment()).commit();
                break;
            case R.id.menu_nav_2:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container,
                        new MoveViewFragment()).commit();
                break;
            case R.id.menu_nav_3:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container,
                        new RevealFragment()).commit();
                break;
            case R.id.menu_nav_4:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container,
                        new FlingFragment()).commit();
                break;
            case R.id.menu_nav_5:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container,
                        new ZoomFragment()).commit();
                break;
            case R.id.menu_nav_6:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container,
                        new SpringFragment()).commit();
                break;
            case R.id.menu_nav_7:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container,
                        new MyShapesFragment()).commit();
                break;

        }

        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;

    }
}
