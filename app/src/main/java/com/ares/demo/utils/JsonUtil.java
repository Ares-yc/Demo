package com.ares.demo.utils;

import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * ====================================
 * 作    者：Ares(颜崔)
 * 地    址：https://github.com/Ares-yc
 * 描    述：Json转化工具类
 * 版    本：1.0.0
 * 创建时间：2017/9/8/008.
 * 修改时间：2017/9/8/008.
 * ====================================
 */

public class JsonUtil {

    private Gson gson;

    private JsonUtil(){ gson = new Gson(); }

    public static JsonUtil getInstance(){
        return ClassHolder.INSTANCE;
    }

    //静态内部类实现单例
    private static class ClassHolder{
        private static final JsonUtil INSTANCE = new JsonUtil();
    }

    /**
     * 将Json字符串转换为对象
     * 使用示例：Data data = JsonUtil.getInstance().fromJson(jsonStr, Data.class);
     * @param jsonStr   Json字符串
     * @param clz       具体对象 例如:Data.class
     * @param <T>       泛型对象
     * @return          转换结果
     */
    public <T> T fromJson(String jsonStr, Class<T> clz) {
        return gson.fromJson(jsonStr, clz);
    }

    /**
     * 将Json字符串转换为对象或数组、集合
     * 使用示例：Data data = JsonUtil.getInstance().fromJson(js, new TypeToken<Data>(){}.getType());
     *           List<Data> datas = JsonUtil.getInstance().fromJson(js, new TypeToken<List<Data>>(){}.getType());
     * @param jsonStr   Json字符串
     * @param type      欲转换类型 new TypeToken<T>(){}.getType()
     * @param <T>       泛型对象
     * @return          转换结果
     */
    public <T> T fromJson(String jsonStr, Type type) {
        return gson.fromJson(jsonStr, type);
    }

    /**
     * 将对象转换为Json字符串
     * 使用示例：String jsonStr = JsonUtil.getInstance().toJson(data);
     * @param object 具体对象
     * @return       转换结果
     */
    public String toJson(Object object) {
        return gson.toJson(object);
    }
}
