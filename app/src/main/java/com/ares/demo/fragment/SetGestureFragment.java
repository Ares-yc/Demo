package com.ares.demo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ares.demo.R;
import com.ares.demo.activity.GestureSignUpActivity;
import com.ares.demo.view.GestureLockViewGroup;

/**
 * ====================================
 * 作    者：Ares(颜崔)
 * 地    址：https://github.com/Ares-yc
 * 描    述：设置手势Fragmnet界面
 * 版    本：1.0.0
 * 创建时间：2017/9/11/011.
 * 修改时间：2017/9/11/011.
 * ====================================
 */

public class SetGestureFragment extends Fragment{

    public GestureLockViewGroup gestureLockViewGroup;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_set_gesture,container,false);
        initView(view);
        return view;
    }

    //初始化控件
    private void initView(View view) {
        gestureLockViewGroup = view.findViewById(R.id.glv_fragment_set_gesture);
        gestureLockViewGroup.setOnGestureLockViewListener((GestureLockViewGroup.OnGestureLockViewListener) getActivity());
        gestureLockViewGroup.setItemMode(((GestureSignUpActivity)getActivity()).mGestureInfos);
    }
}
