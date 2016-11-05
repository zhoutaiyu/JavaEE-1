package cn.qdgxy.ssm.controller;

import cn.qdgxy.ssm.po.ProductCustom;
import cn.qdgxy.ssm.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
     * @return ModelAndView ModelAndView
     * @throws Exception 异常
     */
    // method = RequestMethod.GET 限制使用get方法
    //@RequestMapping(value = "/editProduct", method = RequestMethod.GET)
    //public ModelAndView editProduct() throws Exception {
    //    ModelAndView modelAndView = new ModelAndView();
    //
    //    // 调用service查询商品信息
    //    ProductCustom productCustom = productService.findProductById(1);
    //    //  将模型数据传递到jsp
    //    modelAndView.addObject("product", productCustom);
    //    // 指定逻辑视图名
    //    modelAndView.setViewName("editProduct");
    //
    //    return modelAndView;
    //}

    //方法返回 字符串，字符串就是逻辑视图名，Model作用是将数据填充到request域，在页面展示
    @RequestMapping(value = "/editProduct")
    public String editProduct(Model model, Integer id) throws Exception {
        ModelAndView modelAndView = new ModelAndView();

        // 调用service查询商品信息
        ProductCustom productCustom = productService.findProductById(id);

        //  将模型数据传递到jsp
        model.addAttribute("product", productCustom);

        return "editProduct";
    }

    //@RequestMapping("/editProduct")
    //public void editProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
    //    // 调用service查询商品信息
    //    ProductCustom productCustom = productService.findProductById(1);
    //
    //    //  将模型数据传递到jsp
    //    request.setAttribute("product", productCustom);
    //
    //    request.getRequestDispatcher("/WEB-INF/jsps/product/editProduct.jsp").forward(request, response);
    //}


    @RequestMapping("/editProductSubmit")
    public String editProductSubmit(ProductCustom productCustom) throws Exception {
        //调用service接口更新商品信息
        productService.updateProduct(productCustom);

        //请求重定向
        return "redirect:findAllProduct";
        //转发
        // return "forward:findAllProduct";
    }

}
