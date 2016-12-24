package cn.qdgxy.shiro.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstAction {

    //系统首页
    @RequestMapping("/first")
    public String first(Model model) throws Exception {
        return "/first";
    }

}	
