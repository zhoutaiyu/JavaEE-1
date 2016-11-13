package cn.qdgxy.sss.controller;

import cn.qdgxy.sss.service.ContentService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * 商品Controller
 * create:2016-11-12 20:56
 *
 * @author 李欣
 * @version 1.0
 */
@Controller
public class ContentController {

    @Resource
    private ContentService contentService;

    /* @RequestMapping("/")
    public ModelAndView findAllProduct(HttpServletRequest request) throws Exception {
        //调用service查询商品列表
        List<ProductCustom> productList = productService.findProductList(null);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productList", productList);
        // 指定逻辑视图名
        modelAndView.setViewName("productList");

        return modelAndView;
    }*/

}
