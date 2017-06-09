package com.vincent;

import com.vincent.mapper.StudentMappper;
import com.vincent.model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        /*//使用MyBatis提供的Resources类加载mybatis的配置文件
        Reader reader = Resources.getResourceAsReader("mybatis.xml");
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sessionFactory.openSession();
        StudentMappper mappper = sqlSession.getMapper(StudentMappper.class);
        System.out.println(mappper.selectByNothing());*/

//        InputStream inputStream = App.class.getClassLoader().getResourceAsStream("mybatis.xml");

        Reader reader = Resources.getResourceAsReader("mybatis.xml");
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sessionFactory.openSession();
        String statement = "com.vincent.mapper.StudentMappper.selectByNothing";
//        List<Student> studentList = sqlSession.selectOne(statement);
        List<Student> studentList = sqlSession.selectList(statement);
        System.out.println(studentList);
    }
}
