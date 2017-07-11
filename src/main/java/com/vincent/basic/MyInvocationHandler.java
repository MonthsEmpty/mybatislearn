package com.vincent.basic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2017/7/11.
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object object;//真实主题

    public Object bind(Object object){//绑定真实操作主题
        this.object = object;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),this);//取得代理对象
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {//动态调用方法
        Object temp = method.invoke(this.object,args);//调用方法，传入真实主题和参数
        return temp;//返回方法的返回信息
    }
}
