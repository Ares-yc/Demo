package com.ares.demo.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * ====================================
 * 作    者：Ares(颜崔)
 * 地    址：https://github.com/Ares-yc
 * 描    述：
 * 版    本：1.0.0
 * 创建时间：2017/9/13/013.
 * 修改时间：2017/9/13/013.
 * ====================================
 */

public class IRecyclerView extends RecyclerView{
    public IRecyclerView(Context context) {
        super(context);
    }

    public IRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public IRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onScrollStateChanged(int state) {
        super.onScrollStateChanged(state);
    }
    

    @Override
    public void onScrolled(int dx, int dy) {
        super.onScrolled(dx, dy);
    }
}
