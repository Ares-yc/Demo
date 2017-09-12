package com.ares.demo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ares.demo.GestureEntity;
import com.ares.demo.R;
import com.ares.demo.activity.GestureSignUpActivity;

import java.util.List;

/**
 * ====================================
 * 作    者：Ares(颜崔)
 * 地    址：https://github.com/Ares-yc
 * 描    述：发布签到Fragment界面
 * 版    本：1.0.0
 * 创建时间：2017/9/11/011.
 * 修改时间：2017/9/11/011.
 * ====================================
 */

public class ReleaseSignUpFragment extends Fragment{

    private TextView releaseTv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_release_sign_up,container,false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        releaseTv = view.findViewById(R.id.tv_fragment_release_sign_up);

        List<GestureEntity> entities = ((GestureSignUpActivity)getActivity()).mGestureInfos;
        String gestureStr = "";
        if (entities != null){
            for (GestureEntity entity : entities) {
                gestureStr += entity.gesturePosition;
            }
            releaseTv.setText("发布签到\n手势密码为："+ gestureStr);
        }
    }
}
