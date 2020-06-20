package com.oioip.service;

import com.github.pagehelper.PageInfo;
import com.oioip.domain.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Administrator
 *
 * 订单 业务层接口
 *
 *
 */
public interface OrdersService {

    /**
     * 查询订单详细信息
     * @param id
     * @return
     */
    public abstract Orders findById(@Param("id") String id);


    /**
     * 查询所有订单
     * @return
     */
    public abstract List<Orders> findAll(Integer page,Integer size) throws Exception;
}
