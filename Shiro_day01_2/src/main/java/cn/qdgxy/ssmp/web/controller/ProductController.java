package cn.qdgxy.ssmp.web.controller;

import cn.qdgxy.ssmp.po.ProductCustom;
import cn.qdgxy.ssmp.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService productService;

    @RequestMapping("/all")
    public String findAllProduct(Model model, HttpServletRequest request) throws Exception {
        //调用service查询商品列表
        List<ProductCustom> productList = productService.findProductList(null);
        model.addAttribute("productList", productList);
        return "product/productList";
    }

}
