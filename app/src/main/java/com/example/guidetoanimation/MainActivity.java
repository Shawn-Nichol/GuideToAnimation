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


import com.example.guidetoanimation.Fragment1.Fragment1;
import com.example.guidetoanimation.Fragment2.Fragment2;
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
        Fragment1 fragment = new Fragment1();
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
                        new Fragment1()).commit();
                break;
            case R.id.menu_nav_2:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container,
                        new Fragment2()).commit();
                break;
        }

        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;

    }
}
