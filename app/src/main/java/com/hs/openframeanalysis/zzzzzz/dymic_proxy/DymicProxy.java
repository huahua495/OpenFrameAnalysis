package com.hs.openframeanalysis.zzzzzz.dymic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DymicProxy implements InvocationHandler {
    private Dymic客户 target;//要代理的真实对象

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(target,args);
        return null;
    }
}
