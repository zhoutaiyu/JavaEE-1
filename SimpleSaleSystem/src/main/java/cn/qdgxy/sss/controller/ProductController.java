package cn.qdgxy.sss.controller;

import cn.qdgxy.sss.po.ProductCustom;
import cn.qdgxy.sss.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    /**
     * 首页展示
     *
     * @param model model
     * @param type  ，全部商品；1，未购买商品
     * @return 首页
     * @throws Exception 异常
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String findProduct(Model model, Integer type) throws Exception {
        if (type == null) { // type为null页面有错误
            type = 0;
        }

        model.addAttribute("type", type);
        model.addAttribute("productList", productService.findAllProduct());

        return "index";
    }

    /**
     * 商品详情页
     *
     * @param model model
     * @param id    商品ID
     * @return 商品详情页
     * @throws Exception 异常
     */
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String show(Model model, Integer id) throws Exception {
        ProductCustom productCustom = productService.findProductById(id);
        model.addAttribute("product", productCustom);
        return "show";
    }

}
