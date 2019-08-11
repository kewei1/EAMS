package com.itke.service;


import com.itke.domain.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll(int page, int size) throws Exception;

    void save(Product product) throws Exception;
}
