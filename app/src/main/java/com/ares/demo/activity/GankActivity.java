package com.ares.demo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.ares.demo.R;
import com.ares.demo.entity.GankAndroidEntity;
import com.ares.demo.entity.GankResultEntity;
import com.ares.demo.utils.JsonUtil;
import com.google.gson.reflect.TypeToken;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.OnResponseListener;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.Response;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class GankActivity extends AppCompatActivity implements OnResponseListener<String>{

    private RecyclerView mRecyclerView;
    private int pageCount = 1;
    private int pageSize = 10;
    private String url = "http://gank.io/api/data/Android/"+pageSize+"/"+pageCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gank);

        initView();
        initData();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_activity_gank_content);

    }

    private void initData() {
        Request<String> request = NoHttp.createStringRequest(url, RequestMethod.GET);
        NoHttp.getRequestQueueInstance().add(1,request,this);
    }

    @Override
    public void onStart(int what) {
        Log.e("*****","onStart");
    }

    @Override
    public void onSucceed(int what, Response<String> response) {
        if (response.get() == null) return;
        Log.e("*****","onSucceed");
        GankResultEntity<GankAndroidEntity> resultEntity = JsonUtil.getInstance().fromJson(response.get(),new TypeToken<GankResultEntity<GankAndroidEntity>>(){}.getType());
        if (resultEntity.error) return;
        List<GankAndroidEntity> androidEntity = resultEntity.results;
        if (androidEntity == null) androidEntity = new ArrayList<>();
        if (androidEntity.size() > 0) {
        }
    }

    private static String getString(Calendar c)
    {
        StringBuffer result = new StringBuffer();
        result.append(c.get(Calendar.YEAR));
        result.append("-");
        result.append((c.get(Calendar.MONTH) + 1));
        result.append("-");
        result.append(c.get(Calendar.DAY_OF_MONTH));
        result.append(" ");
        result.append(c.get(Calendar.HOUR_OF_DAY));
        result.append(":");
        result.append(c.get(Calendar.MINUTE));
        result.append(":");
        result.append(c.get(Calendar.SECOND));
        return result.toString();
    }

    @Override
    public void onFailed(int what, Response<String> response) {
        Log.e("*****","onFailed");
    }

    @Override
    public void onFinish(int what) {
        Log.e("*****","onFinish");
    }
}
