package com.ares.demo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ares.demo.R;
import com.ares.demo.activity.SignUpActivity;
import com.ares.demo.adapter.SignUpAdapter;
import com.ares.demo.entity.SignUpEntity;
import com.ares.demo.listener.OnRecyclerViewClickListener;
import com.ares.demo.utils.Constants;

import java.util.ArrayList;
import java.util.List;

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

public class SignUpFragment extends Fragment implements OnRecyclerViewClickListener{

    private SignUpActivity parent;
    private TextView noDataRoot;
    private RecyclerView contentRv;
    private List<SignUpEntity> mDatas;
    private SignUpAdapter mAdapter;

    public static SignUpFragment newInstance(Bundle bundle) {
        SignUpFragment fragment = new SignUpFragment();
        fragment.setArguments(bundle == null ? new Bundle() : bundle);
        return fragment;
    }

    public SignUpFragment() { }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up,container,false);
        initView(view);
        initListener();
        initData();
        return view;

    }

    private void initView(View view) {
        noDataRoot = view.findViewById(R.id.tv_layout_no_data_root);
        contentRv = view.findViewById(R.id.rv_fragment_sign_up_content);

        parent = (SignUpActivity) getActivity();
        mDatas = new ArrayList<>();

        mAdapter = new SignUpAdapter(parent,mDatas,this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(parent);
        contentRv.setLayoutManager(layoutManager);
        contentRv.setAdapter(mAdapter);
    }

    private void initListener() {

    }

    private void initData() {
        //模拟数据 黄十三，柯十四，冯十五，余十六，曾十七，邹十八，袁十九
        SignUpEntity entity = new SignUpEntity("刘一","已签到");
        SignUpEntity entity2 = new SignUpEntity("陈二","已签到");
        SignUpEntity entity3 = new SignUpEntity("张三","已签到");
        SignUpEntity entity4 = new SignUpEntity("李四","已签到");
        SignUpEntity entity5 = new SignUpEntity("王五","已签到");
        SignUpEntity entity6 = new SignUpEntity("赵六","已签到");
        SignUpEntity entity7 = new SignUpEntity("孙七","已签到");
        SignUpEntity entity8 = new SignUpEntity("周八","已签到");
        SignUpEntity entity9 = new SignUpEntity("吴九","已签到");
        SignUpEntity entity10 = new SignUpEntity("郑十","已签到");
        SignUpEntity entity11 = new SignUpEntity("何十一","已签到");
        SignUpEntity entity12 = new SignUpEntity("祝十二","已签到");
        SignUpEntity entity13 = new SignUpEntity("黄十三","已签到");
        SignUpEntity entity14 = new SignUpEntity("柯十四","已签到");
        SignUpEntity entity15 = new SignUpEntity("冯十五","已签到");
        SignUpEntity entity16 = new SignUpEntity("余十六","已签到");
        SignUpEntity entity17 = new SignUpEntity("曾十七","已签到");
        SignUpEntity entity18 = new SignUpEntity("邹十八","已签到");
        SignUpEntity entity19 = new SignUpEntity("袁十九","已签到");

        List<SignUpEntity> datas = new ArrayList<>();
        datas.add(entity);
        datas.add(entity2);
        datas.add(entity3);
        datas.add(entity4);
        datas.add(entity5);
        datas.add(entity6);
        datas.add(entity7);
        datas.add(entity8);
        datas.add(entity9);
        datas.add(entity10);
        datas.add(entity11);
        datas.add(entity12);
        datas.add(entity13);
        datas.add(entity14);
        datas.add(entity15);
        datas.add(entity16);
        datas.add(entity17);
        datas.add(entity18);
        datas.add(entity19);
        updateDatas(datas);//测试数据
        //updateDatas(new ArrayList<SignUpEntity>()); // 测试无数据显示
    }

    public void updateDatas(List<SignUpEntity> _mDatas){
        if (_mDatas == null) return;
        noDataRoot.setVisibility(_mDatas.size() == 0 ? View.VISIBLE : View.GONE);
        parent.setTabCount(Constants.TAG_SIGN_UP_TAB,_mDatas.size());
        mDatas = _mDatas;
        mAdapter.updateDatas(mDatas);
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(parent,"姓名: "+mDatas.get(position).name,Toast.LENGTH_LONG).show();
    }
}
