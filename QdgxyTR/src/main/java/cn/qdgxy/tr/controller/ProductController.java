package cn.qdgxy.tr.controller;

import cn.qdgxy.tr.po.ProductCustom;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 商品控制器
 * create:2016-10-30 20:51
 *
 * @author 李欣
 * @version 1.0
 */
@Controller
public class ProductController {

    @Resource
    private ProductService productService;

    @RequestMapping("/findAllProduct")
    public ModelAndView findAllProduct(HttpServletRequest request) throws Exception {
        //调用service查询商品列表
        List<ProductCustom> productList = productService.findProductList(null);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productList", productList);
        // 指定逻辑视图名
        modelAndView.setViewName("productList");

        return modelAndView;
    }

}