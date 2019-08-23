package com.itke.service;


import com.itke.domain.Role;
import com.itke.domain.UserInfo;

import java.util.List;

public interface IUserService {
    List<UserInfo> findAll(int page, int size) throws Exception;

    void save(UserInfo userInfo) throws Exception;

    UserInfo findById(String id) throws Exception;

    List<Role> findOtherRoles(String userId) throws Exception;

    void addRoleToUser(String userId, String[] roleIds);
}
