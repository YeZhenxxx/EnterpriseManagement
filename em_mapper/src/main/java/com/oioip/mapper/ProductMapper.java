package com.oioip.mapper;

import com.oioip.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Administrator
 *
 * 产品表持久层接口
 */
@Repository("productMapper")
public interface ProductMapper {
    /**
     * 查询所有产品信息
     * @return
     * @throws Exception
     */
    public abstract List<Product> findAll() throws Exception;

    /**
     * 保存产品信息
     * @param product
     * @throws Exception
     */
    public abstract void saveProduct(Product product) throws Exception;
}
