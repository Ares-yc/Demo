package com.ares.demo.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.ares.demo.fragment.SignUpFragment;
import com.ares.demo.fragment.UnSignUpFragment;
import com.ares.demo.utils.Constants;
import com.ares.demo.utils.SPUtil;

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

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context context;
    private String[] title;
    private List<Fragment> datas;

    public MyFragmentPagerAdapter(FragmentManager fm, Context context, String[] title, List<Fragment> datas) {
        super(fm);
        this.context = context;
        this.title = title;
        this.datas = datas;
    }

    @Override
    public Fragment getItem(int position) {
        return datas.get(position);
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
//        return super.instantiateItem(container, position);
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        String mTags = fragment.getTag();
        if(fragment instanceof UnSignUpFragment){
            SPUtil.getInstance(context).putString(Constants.TAG_UN_SIGN_UP_FRAGMENT,mTags);
        }else if(fragment instanceof SignUpFragment){
            SPUtil.getInstance(context).putString(Constants.TAG_SIGN_UP_FRAGMENT,mTags);
        }
        return fragment;
    }
}