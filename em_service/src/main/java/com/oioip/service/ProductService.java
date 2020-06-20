package com.oioip.service;

import com.oioip.domain.Product;

import java.util.List;

/**
 * @author Administrator
 *
 * 产品表业务层接口
 */
public interface ProductService {
    /**
     * 查询所有产品信息
     * @return
     * @throws Exception
     */
    public abstract List<Product> findAll(Integer page,Integer size) throws Exception;

    /**
     * 保存产品信息
     * @param product
     * @throws Exception
     */
    public abstract void saveProduct(Product product) throws Exception;
}
