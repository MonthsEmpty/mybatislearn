package com.vincent;

import com.vincent.mapper.StudentMappper;
import com.vincent.model.Student;
import com.vincent.utils.MybatisUtils;
import com.vincent.utils.Page;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * 测试mybatis的增删改查
 * Created by renwu on 2017/6/19.
 */
public class TestCRUDByAnnotationMapper {

    @Test
    public void testSelect() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMappper studentMappper = sqlSession.getMapper(StudentMappper.class);
        List<Student> studentList = studentMappper.selectByNothing();
        sqlSession.close();
        System.out.println(studentList);
    }

    @Test
    public void testSelectByPage() {
        Page page = new Page();
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMappper studentMappper = sqlSession.getMapper(StudentMappper.class);
        List<Student> studentList = studentMappper.selectByPage(page);
        sqlSession.close();
        System.out.println(studentList.size() + "--" + studentList);
    }

    public void testSelectByStudent() {
        Student student = new Student();
        student.setAge(44);
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMappper studentMappper = sqlSession.getMapper(StudentMappper.class);
        Student result = studentMappper.selectByStudent(student);
        System.out.println(result);
        sqlSession.clearCache();


    }

    @Test
    public void testCache(){
        testSelectByStudent();
        testSelectByStudent();
    }

    /**
     * 这个方法和上面的基本一样，不过我中途修改下数据库的数据查出来的数据是一样的
     * 这里我已配置加手动清除缓存，不过感觉没用奏效，debug进去也执行了，不过原始
     * jdbc查出来的就是这样的值，让我好纳闷
     */
    @Test
    public void testSelectByStudent1(){
        Student student = new Student();
        student.setAge(44);
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMappper studentMappper = sqlSession.getMapper(StudentMappper.class);
        Student result = studentMappper.selectByStudent(student);
        System.out.println(result);
      /*  sqlSession.clearCache();
        *//*对student表做一些修改操作*//*
        StudentMappper studentMappper1 = sqlSession.getMapper(StudentMappper.class);
        Student result1 = studentMappper1.selectByStudent(student);
        System.out.println(result1);*/
    }

}
