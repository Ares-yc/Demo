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

public class UnSignUpFragment extends Fragment implements OnRecyclerViewClickListener{

    private SignUpActivity parent;
    private TextView noDataRoot;
    private RecyclerView contentRv;
    private List<SignUpEntity> mDatas;
    private SignUpAdapter mAdapter;

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
        noDataRoot = view.findViewById(R.id.tv_layout_no_data_root);
        contentRv = view.findViewById(R.id.rv_fragment_un_sign_up_content);

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
        //模拟数据
        SignUpEntity entity = new SignUpEntity("墨菲斯","请假");
        SignUpEntity entity2 = new SignUpEntity("阿努比斯","请假");
        SignUpEntity entity3 = new SignUpEntity("波塞冬","请假");
        SignUpEntity entity4 = new SignUpEntity("宙斯","早退");
        SignUpEntity entity5 = new SignUpEntity("阿瑞斯","早退");
        SignUpEntity entity6 = new SignUpEntity("哈迪斯","早退");
        SignUpEntity entity7 = new SignUpEntity("阿瑞比斯","早退");
        SignUpEntity entity8 = new SignUpEntity("阿尔瑞斯","早退");
        SignUpEntity entity9 = new SignUpEntity("卡尔比斯","早退");

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
        updateDatas(datas);//测试数据
        //updateDatas(new ArrayList<SignUpEntity>()); // 测试无数据显示
    }

    public void updateDatas(List<SignUpEntity> _mDatas){
        if (_mDatas == null) return;
        noDataRoot.setVisibility(_mDatas.size() == 0 ? View.VISIBLE : View.GONE);
        parent.setTabCount(Constants.TAG_UN_SIGN_UP_TAB,_mDatas.size());
        mDatas = _mDatas;
        mAdapter.updateDatas(mDatas);
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(parent,"姓名: "+mDatas.get(position).name,Toast.LENGTH_LONG).show();
    }
}
