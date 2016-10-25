package cn.qdgxy.springmvc.first;

import cn.qdgxy.springmvc.po.Product;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 入门程序 商品列表的查询<br>
 * create:2016-10-18 8:40
 *
 * @author 李欣
 * @version 1.0
 */
public class ProductController2 implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 使用静态数据将商品信息列表显示在jsp页面
        // 商品列表
        List<Product> productList = new ArrayList<>();

        Product product_1 = new Product();
        product_1.setName("联想笔记本");
        product_1.setPrice(6000f);
        product_1.setCreateTime(new Date());
        product_1.setDetail("ThinkPad T430 联想笔记本电脑！");

        Product product_2 = new Product();
        product_2.setName("苹果手机");
        product_2.setPrice(5000f);
        product_2.setDetail("iphone6苹果手机！");

        productList.add(product_1);
        productList.add(product_2);


        ModelAndView modelAndView = new ModelAndView();
        // 将数据填充到request
        //request.setAttribute("productList", productList);
        modelAndView.addObject("productList", productList);
        // 指定转发jsp页面
        modelAndView.setViewName("/WEB-INF/jsps/product/productList.jsp");
        return modelAndView;
    }

}
