package com.example.myjiachengbing20171123;

/**
 * Created by jiachengbing on 2017/11/23.
 */

public interface Ipp<T> {
    //方法：1.绑定方法  2.解绑的方法
    public void attch(T view);
    public void detch();
}
