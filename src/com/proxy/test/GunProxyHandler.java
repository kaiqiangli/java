package com.proxy.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author likaiqiang
 * @description the proxy of gun
 * @create 2016-11-27 下午2:19
 **/
public class GunProxyHandler implements InvocationHandler {

    private final static String PROXY_NAME = "shoot";

    private Object proxied;

    public GunProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if(PROXY_NAME.equals(method.getName())) {

            //转调具体目标对象之前，执行一些功能处理
            System.out.println("start to check before shoot");

            Object o = method.invoke(proxied, args);

            //转调具体目标对象之后，执行一些功能处理
            System.out.println("start to leave after shoot");

            return o;

        }
        return method.invoke(proxied, args);
    }

}
