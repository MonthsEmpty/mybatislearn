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

    @Test
    public void testSelectByStudent() {
        Student student = new Student();
        student.setAge(44);
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMappper studentMappper = sqlSession.getMapper(StudentMappper.class);
        Student result = studentMappper.selectByStudent(student);
        System.out.println(result);
        sqlSession.clearCache();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Student result1 = studentMappper.selectByStudent(student);
        System.out.println(result1);
        List<Student> studentList = studentMappper.selectByNothing();
        System.out.println(studentList);


    }

}
