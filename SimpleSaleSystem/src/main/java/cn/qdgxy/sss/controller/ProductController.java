package cn.qdgxy.sss.controller;

import cn.qdgxy.sss.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * 商品Controller
 * create:2016-11-12 20:56
 *
 * @author 李欣
 * @version 1.0
 */
@Controller
public class ProductController {

    @Resource
    private ProductService productService;

    @RequestMapping("/")
    public ModelAndView findAllProduct() throws Exception {

        return new ModelAndView("/index");
    }

}
