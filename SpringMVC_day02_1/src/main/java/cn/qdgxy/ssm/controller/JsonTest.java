package cn.qdgxy.ssm.controller;

import cn.qdgxy.ssm.po.ProductCustom;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试Json
 * create:2016-10-30 20:51
 * <p>
 * author 李欣
 *
 * @version 1.0
 */
@Controller
public class JsonTest {

    //请求的json响应json，请求商品信息，商品信息用json格式，输出商品信息
    @RequestMapping("/requestJson.action")
    public
    @ResponseBody
    ProductCustom requestJson(@RequestBody ProductCustom productCustom) throws Exception {

        return productCustom;
    }


    //请求key/value响应json
    @RequestMapping("/responseJson.action")
    public
    @ResponseBody
    ProductCustom responseJson(ProductCustom productCustom) throws Exception {

        return productCustom;
    }

}
