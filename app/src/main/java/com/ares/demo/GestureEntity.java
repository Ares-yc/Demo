package com.ares.demo;

import java.io.Serializable;

/**
 * ====================================
 * 作    者：Ares(颜崔)
 * 地    址：https://github.com/Ares-yc
 * 描    述：手势图案信息
 * 版    本：1.0.0
 * 创建时间：2017/9/12/012.
 * 修改时间：2017/9/12/012.
 * ====================================
 */

public class GestureEntity implements Serializable{

    public int gesturePosition;
    public int gestureX;
    public int gestureY;

    public GestureEntity(int gesturePosition, int gestureX, int gestureY) {
        this.gesturePosition = gesturePosition;
        this.gestureX = gestureX;
        this.gestureY = gestureY;
    }
}
