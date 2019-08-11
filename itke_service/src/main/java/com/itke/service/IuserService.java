package com.itke.service;

import com.itke.domain.UserInfo;

import java.util.List;

public interface IuserService {

    List<UserInfo> findAll(int page, int size) throws Exception;

    void save(UserInfo user) throws Exception;
}
