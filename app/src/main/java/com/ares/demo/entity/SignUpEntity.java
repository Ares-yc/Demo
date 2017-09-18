package com.ares.demo.entity;

import java.io.Serializable;

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

public class SignUpEntity implements Serializable{

    public String name;
    public String status;

    public SignUpEntity(String name, String status) {
        this.name = name == null ? "未知" : name;
        this.status = status == null ? "请假" : status;
    }
}
