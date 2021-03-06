package com.itke.service;


import com.itke.domain.Permission;
import com.itke.domain.Role;

import java.util.List;

public interface IRoleService {

    List<Role> findAll(int page, int size) throws Exception;

    void save(Role role) throws Exception;

    Role findById(String roleId) throws  Exception;

    List<Permission> findOtherPermissions(String roleId) throws Exception;

    void addPermissionToRole(String roleId, String[] permissionIds) throws Exception;

    void deleteRoleById(String roleId) throws Exception;

}
