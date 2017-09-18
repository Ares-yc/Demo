package com.ares.demo.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.OnTabSelectedListener;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.ares.demo.R;
import com.ares.demo.adapter.MyFragmentPagerAdapter;
import com.ares.demo.fragment.SignUpFragment;
import com.ares.demo.fragment.UnSignUpFragment;
import com.ares.demo.utils.Constants;
import com.ares.demo.utils.SPUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SignUpActivity extends AppCompatActivity implements OnTabSelectedListener, OnClickListener {

    private ImageView backIv;
    private TextView titleTv;
    private TabLayout tabLayout;
    private ViewPager contentVp;
    private MyFragmentPagerAdapter mAdapter;
    private List<Fragment> fragmentList;
    private UnSignUpFragment unSignUpFragment;
    private SignUpFragment signUpFragment;
    private MyFragmentPagerAdapter myFragmentPagerAdapter;
    private String[] titleTabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initView();
        initListener();
    }

    private void initView() {
        backIv = (ImageView) findViewById(R.id.iv_layout_base_title_back);
        titleTv = (TextView) findViewById(R.id.tv_layout_base_title_text);
        tabLayout = (TabLayout) findViewById(R.id.tl_activity_sign_up_tab);
        contentVp = (ViewPager) findViewById(R.id.vp_activity_sign_up_content);

        titleTv.setText("签到");

        fragmentList = new ArrayList<>();
        String tabUnsignUpStr = String.format(Locale.getDefault(),getString(R.string.un_sign_up),0);
        String tabSignUpStr = String.format(Locale.getDefault(),getString(R.string.sign_up),0);
        titleTabs = new String[]{tabUnsignUpStr, tabSignUpStr};

        FragmentManager fm = getSupportFragmentManager();
        unSignUpFragment = (UnSignUpFragment) fm.findFragmentByTag(SPUtil.getInstance(this).getString(Constants.TAG_UN_SIGN_UP_FRAGMENT, Constants.TAG_UN_SIGN_UP_FRAGMENT));
        signUpFragment = (SignUpFragment) fm.findFragmentByTag(SPUtil.getInstance(this).getString(Constants.TAG_SIGN_UP_FRAGMENT, Constants.TAG_SIGN_UP_FRAGMENT));

        if (unSignUpFragment == null) {
            unSignUpFragment = UnSignUpFragment.newInstance(null);
        }
        if (signUpFragment == null) {
            signUpFragment = SignUpFragment.newInstance(null);
        }

        fragmentList.add(unSignUpFragment);
        fragmentList.add(signUpFragment);

        myFragmentPagerAdapter = new MyFragmentPagerAdapter(
                getSupportFragmentManager(), this, titleTabs, fragmentList);
        contentVp.setAdapter(myFragmentPagerAdapter);

        tabLayout.setupWithViewPager(contentVp);
        tabLayout.setOnTabSelectedListener(this);

        contentVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        contentVp.setOffscreenPageLimit(2);
        contentVp.setCurrentItem(0);
    }

    private void initListener() {
        backIv.setOnClickListener(this);

    }

    /**
     * 当未签到/已签到列表数量
     * 发生改变时调用该方法更新Tab
     * @param tag   Constants.TAG_UN_SIGN_UP_TAB 未签到标记
     *               Constants.TAG_SIGN_UP_TAB    已签到标记
     * @param count 变化后的数量
     */
    public void setTabCount(int tag, int count){
        switch (tag){
            case Constants.TAG_UN_SIGN_UP_TAB:
                titleTabs[0] = String.format(Locale.getDefault(),getString(R.string.un_sign_up),count);
                break;
            case Constants.TAG_SIGN_UP_TAB:
                titleTabs[1] = String.format(Locale.getDefault(),getString(R.string.sign_up),count);
                break;
        }
        myFragmentPagerAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_layout_base_title_back:
                finish();
                break;
        }
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
