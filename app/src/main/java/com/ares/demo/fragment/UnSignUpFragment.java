package com.ares.demo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ares.demo.R;

/**
 * ====================================
 * 作    者：Ares(颜崔)
 * 地    址：https://github.com/Ares-yc
 * 描    述：
 * 版    本：1.0.0
 * 创建时间：2017/9/13.
 * 修改时间：2017/9/13.
 * ====================================
 */

public class UnSignUpFragment extends Fragment{

    public static UnSignUpFragment newInstance(Bundle bundle) {
        UnSignUpFragment fragment = new UnSignUpFragment();
        fragment.setArguments(bundle == null ? new Bundle() : bundle);
        return fragment;
    }

    public UnSignUpFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_un_sign_up,container,false);

        return view;

    }
}
