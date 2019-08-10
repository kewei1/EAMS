package com.itke.service;


import com.itke.domain.Orders;

import java.util.List;

public interface IOrdersService {


    List<Orders> findAll(int page, int size) throws Exception;
}
