package com.vincent.basic;

/**
 * Created by Administrator on 2017/7/11.
 */
public class RealSubject implements Subject{
    @Override
    public String say(String name, Integer age) {
        return "姓名：" + name + ",年龄：" + age;
    }
}
