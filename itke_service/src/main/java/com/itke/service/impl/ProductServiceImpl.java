package com.itke.service.impl;


import com.github.pagehelper.PageHelper;
import com.itke.dao.IProductDao;
import com.itke.domain.Product;
import com.itke.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;


    @Override
    public void save(Product product) {
        product.setId(UUID.randomUUID().toString().substring(0,18));
        System.out.println(product.getId());
        productDao.save(product);
    }

    @Override
    public List<Product> findAll(int page, int size) throws Exception {
        //参数pageNum 是页码值   参数pageSize 代表是每页显示条数
        PageHelper.startPage(page, size);
        return productDao.findAll();
    }
}
