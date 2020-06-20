package com.oioip.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oioip.domain.Orders;
import com.oioip.mapper.OrdersMapper;
import com.oioip.service.OrdersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author Administrator
 *
 * 会员Controller
 */
@Controller
@SessionAttributes({"size"})
@RequestMapping("/orders")
public class OrdersController {
    @Resource(name = "ordersService")
    private OrdersService os;


    /**
     * 查询全部订单---未分页
     * @return
     */
    /*@RequestMapping("/findAll")
    public ModelAndView findAllOrders(){
        try {
            List<Orders>all = os.findAll();
            all.stream().forEach(val-> System.out.println(val));
            ModelAndView mv=new ModelAndView();
            mv.addObject("ordersList",all);
            mv.setViewName("orders-list");
            return mv;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询失败");
        }
    }*/

    @RequestMapping("/findAll")
    public ModelAndView findAllOrders(@RequestParam(name = "page",defaultValue = "1") Integer page,@RequestParam(name = "size",defaultValue = "4") Integer size){
        try {
            List<Orders> all = os.findAll(page,size);
            PageInfo pg=new PageInfo(all);
            ModelAndView mv=new ModelAndView();
            mv.addObject("pageInfo",pg);
            mv.setViewName("orders-page-list");
            return mv;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询失败");
        }
    }

    @RequestMapping("/findById")
    public ModelAndView findById(String id){
        ModelAndView mv=new ModelAndView();
        Orders byId = os.findById(id);
        mv.addObject("orders",byId);
        mv.setViewName("orders-show");
        return mv;
    }
}
