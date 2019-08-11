package com.itke.dao;

import com.itke.domain.UserInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao {

    @Select("select * from users")
    List<UserInfo> findAll() throws Exception;

}
