package com.vincent;

import com.vincent.basic.proxy.AnotherSubject;
import com.vincent.basic.proxy.AnotherSubjectImpl;
import com.vincent.basic.proxy.MyInvocationHandler;
import com.vincent.basic.proxy.RealSubject;
import com.vincent.basic.proxy.Subject;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 测试代理模式
 * Created by Administrator on 2017/7/12.
 */
public class DynaProxyDemo {

    /**
     * 测试代理使用的流程
     */
    @Test
    public void testProxy() {
        Subject subject = new RealSubject();
        Subject proxySubject = (Subject) Proxy.newProxyInstance(subject.getClass().getClassLoader(), subject.getClass().getInterfaces(), new MyInvocationHandler(subject));
        String info = proxySubject.say("vincent", 27);
        System.out.println(info);
    }

    /**
     * 这边证明返回的Proxy.newProxyInstance返回的是Proxy的子类的实例
     */
    @Test
    public void testCoreProxy() throws Throwable {
        Subject subject = new RealSubject();
        //返回的实例可以被Proxy接受，说明是代理类是Proxy的子类。
        Proxy proxySubject = (Proxy) Proxy.newProxyInstance(subject.getClass().getClassLoader(), subject.getClass().getInterfaces(), new MyInvocationHandler(subject));
        //通过Proxy.getInvocationHandler(Object proxy)可以获取代理类的关联的处理器
        InvocationHandler invocationHandler = Proxy.getInvocationHandler(proxySubject);
        //以下的结果和上面的测试结果一样，反证了代理类实例调用方法时会先调用处理器的invoke()方法。
        String info = (String) invocationHandler.invoke(proxySubject, subject.getClass().getMethod("say", String.class, Integer.class), new Object[]{"vincent", 27});
        System.out.println(info);
    }

    /**
     * 证明Proxy生成的实例实现了各种Interface。
     */
    @Test
    public void testInterfacesProxy(){
        Subject subject = new AnotherSubjectImpl();
        AnotherSubject anotherSubject = (AnotherSubject) Proxy.newProxyInstance(subject.getClass().getClassLoader(),subject.getClass().getInterfaces(),new MyInvocationHandler(subject));
        anotherSubject.doSomething("aaa");
    }
}
