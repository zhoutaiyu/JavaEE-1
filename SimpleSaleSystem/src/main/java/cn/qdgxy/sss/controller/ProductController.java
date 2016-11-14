package cn.qdgxy.sss.controller;

import cn.qdgxy.sss.po.User;
import cn.qdgxy.sss.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String findAllProduct(Model model, HttpSession session, Integer type) throws Exception {
        User user = (User) session.getAttribute("user");

        //type：0，全部商品；1，未购买商品
        if (type == null) { // type为null页面有错误
            type = 0;
        }

        if (type == 0) { // 查询所有商品
            // 用户


            // 管理员

        } else if (type == 1) {// 查询用户未购买商品

        }

        model.addAttribute("type", type);
        return "index";
    }

}
