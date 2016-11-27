package com.proxy.test;

/**
 * @author likaiqiang
 * @description
 * @create 2016-11-27 下午2:14
 **/
public class AK_47 implements IGun {

    @Override
    public void shoot() {
        System.out.println("ak_47 shoot");
    }

    @Override
    public void test() {
        System.out.println("test");
    }
}
