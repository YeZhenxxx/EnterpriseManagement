package com.oioip.controller;

import com.github.pagehelper.PageInfo;
import com.oioip.domain.Product;
import com.oioip.domain.Status;
import com.oioip.mapper.ProductMapper;
import com.oioip.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 *
 * 产品表Controller
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Resource(name = "productService")
    private ProductService ps;

    /**
     * 查询全部产品
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page",defaultValue = "4")Integer page,@RequestParam(name = "size",defaultValue = "4")Integer size) throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Product> all = ps.findAll(page,size);
        PageInfo pageInfo=new PageInfo(all);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("product-list");

        return mv;
    }

    /**
     * 添加产品
     * @param product
     * @return 添加状态
     */
    @ResponseBody
    @RequestMapping("/save")
    public Status saveProduct(Product product){
        Status status=new Status();
        try {
            ps.saveProduct(product);
            status.setCode(200);
            status.setMessage("保存产品成功");
        } catch (Exception e) {
            e.printStackTrace();
            status.setCode(500);
            status.setMessage("添加产品失败");
        }
        return status;
    }
}
