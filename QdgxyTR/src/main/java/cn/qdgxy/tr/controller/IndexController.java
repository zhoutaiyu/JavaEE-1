package cn.qdgxy.tr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 首页Controler
 * create:2016-11-18 9:27
 *
 * @author 李欣
 * @version 1.0
 */
@Controller
public class IndexController {

    /**
     * 首页
     *
     * @return 首页
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }

}
