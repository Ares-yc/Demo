package com.ares.demo.app;

import android.app.Application;

import com.yanzhenjie.nohttp.Logger;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.OkHttpNetworkExecutor;


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

public class App extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        initNoHttp();
    }

    private void initNoHttp() {
        Logger.setDebug(true); // 开启NoHttp调试模式。
        Logger.setTag("NoHttpSample"); // 设置NoHttp打印Log的TAG。

        NoHttp.initialize(this, new NoHttp.Config()
                        .setConnectTimeout(30 * 1000) // 全局连接超时时间，单位毫秒。
                        .setReadTimeout(30 * 1000) // 全局服务器响应超时时间，单位毫秒。
                        .setNetworkExecutor(new OkHttpNetworkExecutor())  // 使用OkHttp做网络层。
        );
    }
}
