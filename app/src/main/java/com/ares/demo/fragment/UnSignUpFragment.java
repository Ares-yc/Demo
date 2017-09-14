package com.ares.demo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.ares.demo.R;
import com.ares.demo.activity.SignUpActivity;
import com.ares.demo.utils.Constants;

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

public class UnSignUpFragment extends Fragment implements OnClickListener{

    private Button changeBtn;
    private SignUpActivity parent;

    public static UnSignUpFragment newInstance(Bundle bundle) {
        UnSignUpFragment fragment = new UnSignUpFragment();
        fragment.setArguments(bundle == null ? new Bundle() : bundle);
        return fragment;
    }

    public UnSignUpFragment() { }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_un_sign_up,container,false);
        initView(view);
        initListener();
        initData();
        return view;

    }

    private void initView(View view) {
        parent = (SignUpActivity) getActivity();
        changeBtn = view.findViewById(R.id.btn_fragment_un_sign_up_change);
    }

    private void initListener() {
        changeBtn.setOnClickListener(this);
    }

    private void initData() {

    }

    private int x = 0;
    @Override
    public void onClick(View view) {
        parent.setTabCount(Constants.TAG_UN_SIGN_UP_TAB,x++);
    }
}
