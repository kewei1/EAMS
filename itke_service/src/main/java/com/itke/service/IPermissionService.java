package com.itke.service;


import com.itke.domain.Permission;

import java.util.List;

public interface IPermissionService {
    List<Permission> findAll(int page, int size) throws Exception;

    void save(Permission permission) throws Exception;

    Permission findById(String id) throws Exception;

    void deleteById(String id) throws Exception;

}
