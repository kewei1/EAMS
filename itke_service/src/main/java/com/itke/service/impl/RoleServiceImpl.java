package com.itke.service.impl;


import com.itke.dao.IRoleDao;
import com.itke.domain.Role;
import com.itke.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;




    @Override
    public List<Role> findAll() throws Exception{
        return roleDao.findAll();
    }
}
