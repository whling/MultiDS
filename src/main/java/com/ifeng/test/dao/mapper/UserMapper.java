package com.ifeng.test.dao.mapper;

import com.ifeng.test.common.ds.DataSource;
import com.ifeng.test.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by whling on 2017/12/12.
 */
public interface UserMapper {

    @DataSource("dataSource2")
    List<User> getAll();

    @DataSource("dataSource2")
    User getUserById(@Param("id") int id);

    @DataSource("dataSource2")
    int saveUser(User user);

    @DataSource("dataSource2")
    int updateUser(User user);
}
