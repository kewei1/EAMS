package com.itke.dao;


import com.itke.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface IRoleDao {



    @Select("select * from role")
    List<Role> findAll() throws Exception;


}
