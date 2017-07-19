package com.vincent;

import com.vincent.model.Student;

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
}
