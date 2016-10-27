package cn.qdgxy.springmvc.first;

import cn.qdgxy.springmvc.po.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * create:2016-10-18 8:40
 *
 * @author 李欣
 * @version 1.0
 */
@Controller
public class ProductController3 {

    //商品列表，@RequestMapping中url建议和方法名一致，方便开发维护
    @RequestMapping("/queryProduct")
    public ModelAndView queryProduct() {
        List<Product> productList = new ArrayList<>();

        Product product_1 = new Product();
        product_1.setName("联想笔记本 ProductController2");
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
        modelAndView.addObject("productList", productList);
        // 逻辑视图名
        modelAndView.setViewName("productList");
        return modelAndView;
    }

}
