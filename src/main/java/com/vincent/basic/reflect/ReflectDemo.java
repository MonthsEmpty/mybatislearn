package com.vincent.basic.reflect;

/**
 * Created by renwu on 2017/7/21.
 */
public class ReflectDemo {

    public void say(){
        System.out.println("say nothing");
    }

    public void say(String name){
        System.out.println("name : " + name);
    }

    public void say(String name,Integer age){
        System.out.println("name : " + name + ", age : " + age);
    }
}
