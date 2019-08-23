package com.itke.service.impl;


import com.github.pagehelper.PageHelper;
import com.itke.dao.IRoleDao;
import com.itke.domain.Permission;
import com.itke.domain.Role;
import com.itke.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Override
    public void deleteRoleById(String roleId) {
        //从user_role表中删除
        roleDao.deleteFromUser_RoleByRoleId(roleId);
        //从role_permission表中删除
        roleDao.deleteFromRole_PermissionByRoleId(roleId);
        //从role表中删除
        roleDao.deleteRoleById(roleId);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) {
        for(String permissionId:permissionIds){
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }

    @Override
    public Role findById(String roleId) {
        return roleDao.findById(roleId);
    }

    @Override
    public List<Permission> findOtherPermissions(String roleId) {

        return roleDao.findOtherPermissions(roleId);

    }

    @Override
    public void save(Role role) {
        role.setId(UUID.randomUUID().toString().substring(0,18));
        roleDao.save(role);
    }



    @Override
    public List<Role> findAll(int page, int size) throws Exception{
        PageHelper.startPage(page, size);
        return roleDao.findAll();
    }
}
