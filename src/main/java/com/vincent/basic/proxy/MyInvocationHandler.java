package com.vincent.basic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * Created by Administrator on 2017/7/11.
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object object;//委托类实例

    public MyInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {//动态调用方法
        System.out.println("---------doSomething--------");
        Object temp = method.invoke(this.object,args);//调用委托类的方法，传入委托实例和参数
        System.out.println("---------doOtherSomething--------");
        return temp;//返回方法的返回信息
    }
}
