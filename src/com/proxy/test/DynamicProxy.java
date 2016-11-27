package com.proxy.test;


import java.lang.reflect.Proxy;

/**
 * @author likaiqiang
 * @description
 * @create 2016-11-27 下午2:23
 **/
public class DynamicProxy {

    public static void main(String[] args) {
        AK_47 gun = new AK_47();
        IGun proxySubject = (IGun) Proxy.newProxyInstance(IGun.class.getClassLoader(),
                new Class[]{IGun.class},
                new GunProxyHandler(gun));

        proxySubject.shoot();
        proxySubject.test();
    }

}
