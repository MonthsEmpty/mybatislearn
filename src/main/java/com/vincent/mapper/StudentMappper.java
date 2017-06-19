package com.vincent.mapper;

import com.vincent.model.Student;
import com.vincent.utils.Page;

import java.util.List;

/**
 * Created by renwu on 2017/5/9.
 */
public interface StudentMappper {

    List<Student> selectByNothing();

    List<Student> selectByPage(Page page);
}
