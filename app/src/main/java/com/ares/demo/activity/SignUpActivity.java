package com.ares.demo.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.OnTabSelectedListener;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
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

public class SignUpActivity extends AppCompatActivity implements OnTabSelectedListener {

    private ImageView backIv;
    private TextView titleTv;
    private TabLayout tabLayout;
    private ViewPager contentVp;
    private MyFragmentPagerAdapter mAdapter;
    private List<Fragment> fragmentList;
    private UnSignUpFragment unSignUpFragment;
    private SignUpFragment signUpFragment;

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

        fragmentList = new ArrayList<>();

        String[] titleTabs = {getString(R.string.un_sign_up),getString(R.string.sign_up)};

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

        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(
                getSupportFragmentManager(), this, titleTabs, fragmentList);
        contentVp.setAdapter(myFragmentPagerAdapter);

        tabLayout.setupWithViewPager(contentVp);
        tabLayout.setOnTabSelectedListener(this);

    }

    private void initListener() {
        contentVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        contentVp.setOffscreenPageLimit(2);
        contentVp.setCurrentItem(0);
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
