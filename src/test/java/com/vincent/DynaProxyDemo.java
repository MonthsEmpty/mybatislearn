package com.vincent;

import com.vincent.basic.MyInvocationHandler;
import com.vincent.basic.RealSubject;
import com.vincent.basic.Subject;
import org.junit.Test;

/**
 * Created by Administrator on 2017/7/12.
 */
public class DynaProxyDemo {

    @Test
    public void testProxy(){
        MyInvocationHandler handler = new MyInvocationHandler();
        Subject subject = (Subject) handler.bind(new RealSubject());
        String info = subject.say("vincent",27);
        System.out.println(info);
    }
}
