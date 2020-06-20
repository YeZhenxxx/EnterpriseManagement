package com.oioip.service.impl;

import com.github.pagehelper.PageHelper;
import com.oioip.domain.Product;
import com.oioip.mapper.ProductMapper;
import com.oioip.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 *
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Resource(name = "productMapper")
    private ProductMapper pm;

    @Override
    public List<Product> findAll(Integer page,Integer size) throws Exception {
        PageHelper.startPage(page,size);
        List<Product> all = pm.findAll();
        return all;
    }

    @Override
    public void saveProduct(Product product) throws Exception {
        pm.saveProduct(product);
    }
}
