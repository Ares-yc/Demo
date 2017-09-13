package com.ares.demo.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * ====================================
 * 作    者：Ares(颜崔)
 * 地    址：https://github.com/Ares-yc
 * 描    述：
 * 版    本：1.0.0
 * 创建时间：2017/9/14.
 * 修改时间：2017/9/14.
 * ====================================
 */

public class SPUtil {

    private static SPUtil                   instance;
    private static SharedPreferences mSharedPreferences;
    private static SharedPreferences.Editor mEditor;
    private static final String             SHAREDPREFERENCES_NAME = "sharedpreferences_cloud_photo";

    private SPUtil(Context context) {
        mSharedPreferences = context.getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
    }

    public static SPUtil getInstance(Context context){
        if (instance == null) {
            synchronized (SPUtil.class){
                if (instance == null) {
                    instance = new SPUtil(context.getApplicationContext());
                }
            }
        }
        return instance;
    }

    public boolean putBoolean(String key,boolean value){
        return mEditor.putBoolean(key,value).commit();
    }

    public boolean getBoolean(String key,boolean defValue){
        return mSharedPreferences.getBoolean(key,defValue);
    }

    public boolean putString(String key,String value){
        return mEditor.putString(key,value).commit();
    }

    public String getString(String key,String defValue){
        return mSharedPreferences.getString(key,defValue);
    }

    public boolean putInt(String key,int value){
        return mEditor.putInt(key,value).commit();
    }

    public int getInt(String key,int defValue){
        return mSharedPreferences.getInt(key,defValue);
    }

    public boolean putLong(String key,long value){
        return mEditor.putLong(key,value).commit();
    }

    public long getLong(String key,long defValue){
        return mSharedPreferences.getLong(key,defValue);
    }

    public boolean putFloat(String key,float value){
        return mEditor.putFloat(key,value).commit();
    }

    public float getFloat(String key,float defValue){
        return mSharedPreferences.getFloat(key,defValue);
    }
}
