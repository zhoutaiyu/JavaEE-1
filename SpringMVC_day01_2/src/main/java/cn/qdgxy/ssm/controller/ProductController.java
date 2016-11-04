package cn.qdgxy.ssm.controller;

import cn.qdgxy.ssm.po.ProductCustom;
import cn.qdgxy.ssm.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品控制器
 * create:2016-10-30 20:51
 * <p>
 * author 李欣
 *
 * @version 1.0
 */
@Controller
@RequestMapping("/product") //定义url的根路径，访问时根路径+方法的url
public class ProductController {

    @Resource
    private ProductService productService;

    /**
     * 查找所有商品
     *
     * @return ModelAndView
     * @throws Exception 异常
     */
    @RequestMapping("findAllProduct")
    public ModelAndView findAllProduct() throws Exception {
        //调用service查询商品列表
        List<ProductCustom> productList = productService.findProductList(null);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productList", productList);
        // 指定逻辑视图名
        modelAndView.setViewName("productList");

        return modelAndView;
    }

    /**
     * 修改商品
     *
     * @return ModelAndView
     * @throws Exception 异常
     */
    @RequestMapping("/editProduct")
    public ModelAndView editPrduct() throws Exception {
        ModelAndView modelAndView = new ModelAndView();

        // 调用service查询商品信息
        ProductCustom productCustom = productService.findProductById(1);
        //  将模型数据传递到jsp
        modelAndView.addObject("product", productCustom);
        // 指定逻辑视图名
        modelAndView.setViewName("editProduct");

        return modelAndView;
    }


}
