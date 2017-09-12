package com.ares.demo.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.ares.demo.GestureEntity;
import com.ares.demo.R;
import com.ares.demo.fragment.ReleaseSignUpFragment;
import com.ares.demo.fragment.SetGestureFragment;
import com.ares.demo.view.GestureLockViewGroup.OnGestureLockViewListener;

import java.util.List;

/**
 * ====================================
 * 作    者：Ares(颜崔)
 * 地    址：https://github.com/Ares-yc
 * 描    述：手势签到Activity界面
 * 版    本：1.0.0
 * 创建时间：2017/9/11/011.
 * 修改时间：2017/9/11/011.
 * ====================================
 */
public class GestureSignUpActivity extends AppCompatActivity implements OnClickListener,OnGestureLockViewListener {

    public static final String TAG = "GestureSignUpActivity";

    /**  返回按钮 */
    private ImageView backIv;
    /**  下一步操作按钮 */
    private Button nextBtn;
    /**  发布操作按钮 */
    private Button releaseBtn;
    private FragmentManager fm;
    /**  手势信息 */
    public List<GestureEntity> mGestureInfos;

    private SetGestureFragment setGestureFragment;
    private ReleaseSignUpFragment releaseSignUpFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_sign_up);

        initView();
        initListener();
    }

    //初始化控件
    private void initView() {
        backIv = (ImageView) findViewById(R.id.iv_activity_gesture_sign_up_back);
        nextBtn = (Button) findViewById(R.id.btn_activity_gesture_sign_up_next);
        releaseBtn = (Button) findViewById(R.id.btn_activity_gesture_sign_up_release);

        setGestureFragment = new SetGestureFragment();
        releaseSignUpFragment = new ReleaseSignUpFragment();

        //初始化界面，首次展示为设置手势界面
        replaceFragment(setGestureFragment);
    }

    //绑定监听
    private void initListener() {
        backIv.setOnClickListener(this);//返回按钮点击事件监听
        nextBtn.setOnClickListener(this);//下一步按钮点击事件监听
        releaseBtn.setOnClickListener(this);//发布按钮点击事件监听
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_activity_gesture_sign_up_back://返回键点击事件实现
                if (nextBtn.getVisibility() == View.VISIBLE){
                    finish();
                }else {
                    replaceFragment(setGestureFragment);
                }
                break;
            case R.id.btn_activity_gesture_sign_up_next://下一步按钮点击事件实现
                if (mGestureInfos == null || mGestureInfos.size() <= 0) {
                    Toast.makeText(GestureSignUpActivity.this,"请先创建手势图案!",Toast.LENGTH_LONG).show();
                    break;
                }
                replaceFragment(releaseSignUpFragment);
                break;
            case R.id.btn_activity_gesture_sign_up_release://发布按钮点击事件实现
                Toast.makeText(GestureSignUpActivity.this,"发布签到!",Toast.LENGTH_LONG).show();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (nextBtn.getVisibility() == View.VISIBLE){
            finish();
        }else {
            replaceFragment(setGestureFragment);
        }
    }

    //切换Fragment内容、按钮
    private void replaceFragment(Fragment fragment){
        boolean tag = fragment instanceof SetGestureFragment;
        nextBtn.setVisibility(tag ? View.VISIBLE : View.GONE);
        nextBtn.setEnabled(tag);
        releaseBtn.setVisibility(tag ? View.GONE : View.VISIBLE);
        releaseBtn.setEnabled(!tag);

        fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fl_activity_gesture_sign_up_content,fragment);
        ft.commit();

    }

    @Override
    public void onBlockSelected(int cId) {

    }

    @Override
    public void onGestureEvent(boolean matched) {

    }

    @Override
    public void saveGesture(List<GestureEntity> gestureInfos) {
        this.mGestureInfos = gestureInfos;
    }
}
