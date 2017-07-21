package com.vincent;

import com.vincent.basic.reflect.ReflectDemo;
import com.vincent.model.Student;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by renwu on 2017/7/19.
 */
public class ReflectTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String classPath = "com.vincent.model.Student";
        Class aClass = Class.forName(classPath);
        Student student = (Student) aClass.newInstance();
        student.setAge(11);
        System.out.println(student);
    }

    @Test
    public void methodReflectTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ReflectDemo reflectDemo = new ReflectDemo();
        Class clazz = ReflectDemo.class;
        Method method = clazz.getMethod("say",new Class[]{String.class});
//        method.invoke(reflectDemo,new Object[]{"aaa"});
        method.invoke(reflectDemo,new Object[]{"aaa"});

    }
}
