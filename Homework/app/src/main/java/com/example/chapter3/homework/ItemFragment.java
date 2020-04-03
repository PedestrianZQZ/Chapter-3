package com.example.chapter3.homework;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;

public class ItemFragment extends Fragment{
    private static final String TAG = "ItemFragment";
    private View view;//定义view用来设置fragment的layout
    public RecyclerView mItemRecyclerView;//定义RecyclerView
    private ItemRecycleAdapter mItemRecycleAdapter;
    private ArrayList<String> friends = new ArrayList<String>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView() called with: inflater = [" + inflater + "], container = [" + container + "], savedInstanceState = [" + savedInstanceState + "]");
        view = inflater.inflate(R.layout.fragment_item, container, false);
        initRecyclerView();
        initData();
        RecyclerView rv;
        rv = (RecyclerView) view.findViewById(R.id.rv_items);
        LottieAnimationView animationView;
        animationView = view.findViewById(R.id.animation_view);
        ObjectAnimator animator0 = ObjectAnimator.ofFloat(rv, "alpha", 0, 0);
        animator0.setDuration(1);

        ObjectAnimator animator1 = ObjectAnimator.ofFloat(animationView, "alpha", 1, 1);
        animator1.setDuration(5000);

        ObjectAnimator animator2 = ObjectAnimator.ofFloat(animationView, "alpha", 1, 0);
        animator2.setDuration(1000);
//        animator4.setRepeatCount(ObjectAnimator.INFINITE);
//        animator4.setRepeatMode(ObjectAnimator.REVERSE);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(rv, "alpha", 0, 1);
        animator3.setDuration(1000);

        AnimatorSet animatorset;
        animatorset = new AnimatorSet();
        animatorset.playSequentially(animator0, animator1, animator2, animator3);
        animatorset.start();
        return view;

    }

    private void initData() {
        String temp = "";
        for (int i = 0; i <= 5; i++){
            temp = "Item" + i;
            friends.add(temp);
        }
    }

    private void initRecyclerView() {
        //获取RecycleView
        mItemRecyclerView = (RecyclerView) view.findViewById(R.id.rv_items);
        //创建adapter
        mItemRecycleAdapter = new ItemRecycleAdapter(getActivity(), friends);
        //给recyclerview设置adapter
        mItemRecyclerView.setAdapter(mItemRecycleAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mItemRecyclerView.setLayoutManager(layoutManager);
    }

}
