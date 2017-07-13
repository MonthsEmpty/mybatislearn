package com.vincent.basic.proxy;

/**
 * Created by renwu on 2017/7/13.
 */
public class AnotherSubjectImpl implements AnotherSubject, Subject {
    @Override
    public String doSomething(String action) {
        String str = "AnotherSubjectImpl is doing something : " + action;
        System.out.println(str);
        return str;
    }

    @Override
    public String say(String name, Integer age) {
        String info = "姓名：" + name + ",年龄：" + age;
        System.out.println(info);
        return info;
    }
}
