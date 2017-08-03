package com.vincent;

import com.vincent.mapper.StudentMappper;
import com.vincent.mapper.UserMapper;
import com.vincent.model.Student;
import com.vincent.model.User;
import com.vincent.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 *
 * Created by renwu on 2017/7/24.
 */
public class UserTest {

    @Test
    public void testSelect() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("vincent");
//        user.setBirthday(new Date());
        List<User> users = userMapper.selectByUser(user);
        sqlSession.close();
        System.out.println(users);
    }
}
