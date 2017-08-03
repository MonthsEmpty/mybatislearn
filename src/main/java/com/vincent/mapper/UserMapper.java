package com.vincent.mapper;

import com.vincent.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by renwu on 2017/7/24.
 */
public interface UserMapper {

//    User selectById(Integer id);

    List<User> selectByUser(User user);
}
