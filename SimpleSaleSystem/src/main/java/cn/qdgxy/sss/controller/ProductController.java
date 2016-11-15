package cn.qdgxy.sss.controller;

import cn.qdgxy.sss.po.Product;
import cn.qdgxy.sss.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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
     * @throws Exception Exception
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
     * @param id 商品ID
     * @return 商品详情页
     * @throws Exception Exception
     */
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public ModelAndView show(Integer id) throws Exception {
        return new ModelAndView("show", "product", productService.findProductAndOrderById(id));
    }

    /**
     * 商品发布页
     *
     * @return 商品发布页
     * @throws Exception Exception
     */
    @RequestMapping(value = "/public", method = RequestMethod.GET)
    public String publish() throws Exception {
        return "public";
    }

    /**
     * 商品发布页提交
     *
     * @param product 商品
     * @return 商品详情页
     * @throws Exception Exception
     */
    @RequestMapping(value = "/publicSubmit", method = RequestMethod.POST)
    public ModelAndView publishSubmit(Product product) throws Exception {
        productService.addProduct(product);
        return show(product.getId());
    }

    /**
     * 商品编辑页
     *
     * @param id 商品ID
     * @return 商品编辑页
     * @throws Exception Exception
     */
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editProduct(Integer id) throws Exception {
        return new ModelAndView("edit", "product", productService.findProductById(id));
    }

    /**
     * 商品编辑页提交
     *
     * @param product 商品
     * @return 商品编辑页
     * @throws Exception Exception
     */
    @RequestMapping(value = "/editSubmit", method = RequestMethod.POST)
    public ModelAndView editProductSubmit(Product product) throws Exception {
        productService.updateById(product);
        return show(product.getId());
    }

    /**
     * 删除商品
     *
     * @param id 商品ID
     * @return Json
     * @throws Exception Exception
     */
    @RequestMapping(value = "/api/delete", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, Object> deleteProduct(Integer id) throws Exception {
        Map<String, Object> map = new HashMap<>();

        if (productService.deleteById(id)) { // 删除成功
            map.put("code", 200);
            map.put("result", true);
        } else {    // 删除失败
            map.put("code", 500);
            map.put("message", "删除失败！");
            map.put("result", false);
        }

        return map;
    }

}
