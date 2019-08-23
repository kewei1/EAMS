package com.itke.service.impl;


import com.github.pagehelper.PageHelper;
import com.itke.dao.IPermissionDao;
import com.itke.domain.Permission;
import com.itke.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao permissionDao;

    @Override
    public void deleteById(String id) throws Exception {
        permissionDao.deleteFromRole_Permission(id);
        permissionDao.deleteById(id);
    }

    @Override
    public Permission findById(String id) throws Exception {
        return permissionDao.findById(id);
    }

    @Override
    public void save(Permission permission) throws Exception{
        permission.setId(UUID.randomUUID().toString().substring(0,18));
        permissionDao.save(permission);
    }


    @Override
    public List<Permission> findAll(int page, int size) throws Exception{
        PageHelper.startPage(page, size);
        return permissionDao.findAll();
    }
}
