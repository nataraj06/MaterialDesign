package com.android.materialdesign.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.android.materialdesign.R;
import com.android.materialdesign.adapters.SlideTabAdapter;
import com.android.materialdesign.ui.fragments.FragmentA;
import com.android.materialdesign.ui.fragments.FragmentB;


public class TabLayoutActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);
        setupToolbar();
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        //setting tabs via viewpager this contains scroll behaviour in the content area
        setUpViewPager();
        //to setup tabs without viewpager which doesn't have swipe actions for the content
        //initTabs();
        //to set the current position where the tab should start
        //setDefaultTab();
    }

    private void initTabs() {
        mTabLayout.addTab(mTabLayout.newTab().setTag("Tab_One").setText("TAB ONE"));
        mTabLayout.addTab(mTabLayout.newTab().setTag("Tab_Two").setText("Tab Two"));
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getTag().toString()) {
                    case "Tab_One":
                        loadTabFragment(new FragmentA());
                        break;
                    case "Tab_Two":
                        loadTabFragment(new FragmentB());
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //do nothing
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //do nothing
            }
        });
    }

    private void setDefaultTab() {
        mTabLayout.post(new Runnable() {
            @Override
            public void run() {
                mTabLayout.post(new Runnable() {
                    @Override
                    public void run() {
                        mTabLayout.getTabAt(1).select();
                    }
                });
            }
        });
    }

    private void setUpViewPager() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        SlideTabAdapter slideTabAdapter = new SlideTabAdapter(getSupportFragmentManager());
        slideTabAdapter.addFragment(new FragmentA(), "TAB ONE");
        slideTabAdapter.addFragment(new FragmentB(), "Tab Two");

        mViewPager.setAdapter(slideTabAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null)
            setSupportActionBar(toolbar);

        // to show back arrow icon
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(getString(R.string.menu_tab_layout));
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        } else
            return super.onOptionsItemSelected(item);
    }

    private void loadTabFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.activity_tab_content_fl, fragment);
        transaction.commit();
    }
}
