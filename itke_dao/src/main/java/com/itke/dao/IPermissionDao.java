package com.itke.dao;


import com.itke.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissionDao {



    @Select("select * from permission")
    List<Permission> findAll() throws Exception;


    @Insert("insert into permission(permissionName,url,id) values(#{permissionName},#{url},#{id})" )
    void save(Permission permission) throws Exception;

}
