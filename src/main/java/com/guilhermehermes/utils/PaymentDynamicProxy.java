package com.guilhermehermes.utils;

import java.lang.reflect.Proxy;

public class PaymentDynamicProxy {

    public static Object createProxy(Object target){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new BancoDynamicProxyHandler(target)
        );
    }
}
