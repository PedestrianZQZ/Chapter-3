package com.example.chapter3.homework;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;

import java.util.concurrent.TimeUnit;

/**
 * 使用 ViewPager 和 Fragment 做一个简单版的好友列表界面
 * 1. 使用 ViewPager 和 Fragment 做个可滑动界面
 * 2. 使用 TabLayout 添加 Tab 支持
 * 3. 对于好友列表 Fragment，使用 Lottie 实现 Loading 效果，在 5s 后展示实际的列表，要求这里的动效是淡入淡出
 */
public class Ch3Ex3Activity extends AppCompatActivity {
    private LottieAnimationView animationView;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch3ex3);
        animationView = findViewById(R.id.animation_view);
        pager = findViewById(R.id.view_pager);
        animationView.playAnimation();
//        ObjectAnimator animator0 = ObjectAnimator.ofFloat(pager, "alpha", 0, 0);
//        animator0.setDuration(1);
//
//        ObjectAnimator animator1 = ObjectAnimator.ofFloat(animationView, "alpha", 1, 1);
//        animator1.setDuration(5000);
//
//        ObjectAnimator animator2 = ObjectAnimator.ofFloat(animationView, "alpha", 1, 0);
//        animator2.setDuration(1000);
////        animator4.setRepeatCount(ObjectAnimator.INFINITE);
////        animator4.setRepeatMode(ObjectAnimator.REVERSE);
//        ObjectAnimator animator3 = ObjectAnimator.ofFloat(pager, "alpha", 0, 1);
//        animator3.setDuration(1000);
//
//        AnimatorSet animatorset;
//        animatorset = new AnimatorSet();
//        animatorset.playSequentially(animator0, animator1, animator2, animator3);
//        animatorset.start();

        // TODO: ex3-1. 添加 ViewPager 和 Fragment 做可滑动界面

        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return new ItemFragment();
            }

            @Override
            public int getCount() {
                return 2;
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                String[] list = {"好友列表", "我的好友"};
                return list[position];
            }
        });


        // TODO: ex3-2, 添加 TabLayout 支持 Tab
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(pager);
    }
}
