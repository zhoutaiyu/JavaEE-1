package cn.qdgxy.sss.controller;

import cn.qdgxy.sss.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * 用户Controller
 * create:2016-11-12 20:57
 *
 * @author 李欣
 * @version 1.0
 */
@Controller
public class PersonController {

    @Resource
    private PersonService personService;

    /**
     * 登录
     *
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView findAllProduct() throws Exception {
        return new ModelAndView("login");
    }
}
