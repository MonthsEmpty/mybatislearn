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

        /**
         * 在idea中可能读取不到这个xml文件，在pom文件中加入相关的<resource>
         */
        Reader reader = Resources.getResourceAsReader("mybatis.xml");
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sessionFactory.openSession();
        String statement = "com.vincent.mapper.StudentMappper.selectByNothing";
        /**
         * Exception in thread "main" org.apache.ibatis.exceptions.TooManyResultsException: Expected one result (or null) to be returned by selectOne(), but found: 4
         * 使用selectOne(String statement)方法会报错，这个方法只会返回一个值，艹，害我在xml中对来对去，找不到错误原因
         */
//        List<Student> studentList = sqlSession.selectOne(statement);
        List<Student> studentList = sqlSession.selectList(statement);
        System.out.println(studentList);
    }
}
