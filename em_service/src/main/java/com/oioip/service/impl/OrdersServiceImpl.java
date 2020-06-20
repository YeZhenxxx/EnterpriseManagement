package com.oioip.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oioip.domain.Orders;
import com.oioip.mapper.OrdersMapper;
import com.oioip.service.OrdersService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 *
 * 订单 业务层接口实现类
 *
 * PageHelp的使用步骤:
 *  1.导入依赖
 *  2.在spring中的SqlsessionFactoryBean中配置分页插件
 *      <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
 *         <property name="plugins">
 *             <array>
 *                 传入插件对象
 *                 <bean class="com.github.pagehelper.PageInterceptor">
 *                     <property name="properties">
 *                         <props>
 *                             <!--指定数据库厂商-->
 *                             <prop key="helperDialect">mysql</prop>
 *                             <!--不会超出数据库的总页数,当页面小于第一页页面时默认查询第一页,当页面大于总页数时则查询最后一页-->
 *                             <prop key="reasonable">true</prop>
 *                         </props>
 *                     </property>
 *                 </bean>
 *             </array>
 *         </property>
 *
 *
 *  3.在真正调用Mapper方法查询数据库语句之前调用pageHelper.startPage 进行设置
 *    设置完后下一句必须是查询方法,不能有其他语句
 *
 *
 *
 *          *  指定从那页开始,每页显示多少条
 *          *  参数pageNum是页码值
 *          *  参数pageSize代表每页查询多少条
 *
 *              PageHelper.startPage(1,5);
 *
 *          一般写在Service层
 */
@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {
    @Resource(name = "ordersMapper")
    private OrdersMapper om;

    @Override
    public Orders findById(String id) {
        Orders byId = om.findById(id);
        return byId;
    }

    @Override
    public List<Orders> findAll(Integer page,Integer size) throws Exception {
        PageHelper.startPage(page,size);
        List<Orders> all = om.findAll();

        return all;
    }
}
