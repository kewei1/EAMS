package com.itke.service.impl;

import com.github.pagehelper.PageHelper;
import com.itke.dao.IUserDao;
import com.itke.domain.UserInfo;
import com.itke.service.IuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements IuserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public List<UserInfo> findAll(int page, int size) throws Exception{
        //参数pageNum 是页码值   参数pageSize 代表是每页显示条数
        PageHelper.startPage(page, size);
        return userDao.findAll() ;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void save(UserInfo user) throws Exception {
        user.setId(UUID.randomUUID().toString().substring(0,18));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }
}
