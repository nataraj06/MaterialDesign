package com.android.materialdesign.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.android.materialdesign.R;
import com.android.materialdesign.ui.fragments.FloatingActionButtonFragment;
import com.android.materialdesign.ui.fragments.HomeFragment;
import com.android.materialdesign.ui.fragments.SnackBarFragment;

public class NavigationViewActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_view);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        setUpToolBar();
        setUpNavigationDrawer();
        setUpFragment(new HomeFragment());
    }

    private void setUpToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.toolbar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    private void setUpNavigationDrawer() {
        NavigationView mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_widget:
                        //handles default home screen
                        setUpFragment(new HomeFragment());
                        break;
                    case R.id.menu_fab:
                        setUpFragment(new FloatingActionButtonFragment());
                        break;
                    case R.id.menu_snack_bar:
                        setUpFragment(new SnackBarFragment());
                        break;
                    case R.id.menu_recycler:
                        break;
                    case R.id.menu_collapsing_tb:
                        startActivity(new Intent(NavigationViewActivity.this, CollapsableToolBarActivity.class));
                        break;
                    case R.id.menu_tab_layout:
                        startActivity(new Intent(NavigationViewActivity.this, TabLayoutActivity.class));

                        break;
                    case R.id.menu_palette:
                        startActivity(new Intent(NavigationViewActivity.this, PaletteConceptActivity.class));
                        break;
                    case R.id.menu_percent:
                        break;
                    case R.id.sub_menu_settings:
                        break;
                }
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    private void setUpFragment(Fragment fragment) {
        if (fragment != null) {
            String fragmentName = fragment.getClass().getSimpleName();
            FragmentManager fragmentManager = getSupportFragmentManager();
            boolean isFragmentPopped = fragmentManager.popBackStackImmediate(fragmentName, 0);

            if (!isFragmentPopped && fragmentManager.findFragmentByTag(fragmentName) == null) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_container, fragment, fragmentName);
                fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                fragmentTransaction.commit();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        } else if (item.getItemId() == R.id.action_search) {
            //implementation for search
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 1)
            ActivityCompat.finishAffinity(this);
        else
            super.onBackPressed();
    }
}