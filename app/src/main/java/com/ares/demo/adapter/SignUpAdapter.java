package com.ares.demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ares.demo.R;
import com.ares.demo.entity.SignUpEntity;
import com.ares.demo.listener.OnRecyclerViewClickListener;

import java.util.List;

/**
 * ====================================
 * 作    者：Ares(颜崔)
 * 地    址：https://github.com/Ares-yc
 * 描    述：
 * 版    本：1.0.0
 * 创建时间：2017/9/18/018.
 * 修改时间：2017/9/18/018.
 * ====================================
 */

public class SignUpAdapter extends RecyclerView.Adapter<SignUpAdapter.VH>{

    private static final String TAG = "SignUpAdapter";

    private Context mContext;
    private List<SignUpEntity> mDatas;
    private LayoutInflater mLayoutInflater;
    private OnRecyclerViewClickListener mListener;

    public SignUpAdapter(Context mContext, List<SignUpEntity> mDatas, OnRecyclerViewClickListener mListener) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        this.mListener = mListener;
        this.mLayoutInflater = LayoutInflater.from(mContext);
    }

    public void updateDatas(List<SignUpEntity> _mDatas){
        if (_mDatas == null) return;
        mDatas.clear();
        mDatas.addAll(_mDatas);
        notifyDataSetChanged();
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_sign_up,parent,false);
        VH vh = new VH(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        SignUpEntity entity = mDatas.get(position);
        holder.nameTv.setText(entity.name);
        holder.statusTv.setText(entity.status);
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    class VH extends RecyclerView.ViewHolder implements OnClickListener{

        TextView nameTv,statusTv;

        public VH(View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.tv_item_un_sign_up_name);
            statusTv = itemView.findViewById(R.id.tv_item_un_sign_up_status);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mListener == null) Log.e(TAG,"mListener is null!");
            mListener.onItemClick(getLayoutPosition());
        }
    }
}
