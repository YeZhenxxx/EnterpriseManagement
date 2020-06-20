package com.oioip.mapper;

import com.oioip.domain.Orders;
import com.oioip.domain.Permission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Administrator
 *
 * 订单持久层接口
 */
@Repository("ordersMapper")
public interface OrdersMapper {

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
    public abstract List<Orders> findAll();
}
