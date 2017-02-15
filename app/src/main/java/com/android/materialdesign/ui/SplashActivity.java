package com.android.materialdesign.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.android.materialdesign.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        TextView txtSplashTitle = (TextView) findViewById(R.id.splash_title_txt);
        Animation animation = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.fade_in);
        txtSplashTitle.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                //do nothing
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(SplashActivity.this, TextInputLayoutActivity.class));
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                //do nothing
            }
        });
    }
}
