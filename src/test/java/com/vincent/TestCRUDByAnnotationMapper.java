package com.vincent;

import com.vincent.mapper.StudentMappper;
import com.vincent.model.Student;
import com.vincent.utils.MybatisUtils;
import com.vincent.utils.Page;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created by renwu on 2017/6/19.
 */
public class TestCRUDByAnnotationMapper {

    @Test
    public void testSelect(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMappper studentMappper = sqlSession.getMapper(StudentMappper.class);
        List<Student> studentList = studentMappper.selectByNothing();
        sqlSession.close();
        System.out.println(studentList);
    }

    @Test
    public void testSelectByPage(){
        Page page = new Page();
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMappper studentMappper = sqlSession.getMapper(StudentMappper.class);
        List<Student> studentList = studentMappper.selectByPage(page);
        sqlSession.close();
        System.out.println(studentList.size() + "--" + studentList);

    }

}