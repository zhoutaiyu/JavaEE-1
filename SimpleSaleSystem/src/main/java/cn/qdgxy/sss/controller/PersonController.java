package cn.qdgxy.sss.controller;

import cn.qdgxy.sss.exception.MyException;
import cn.qdgxy.sss.po.PersonCustom;
import cn.qdgxy.sss.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

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
    public ModelAndView login() throws Exception {
        return new ModelAndView("login");
    }

    /**
     * 登录
     *
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, Object> loginSubmit(HttpSession session, String userName, String password) throws Exception {
        Map<String, Object> map = new HashMap<>();

        try {
            PersonCustom personCustom = personService.login(userName, password);

            map.put("code", 200);
            map.put("result", true);

            session.setAttribute("user", personCustom);
        } catch (MyException e) {
            map.put("code", 500);
            map.put("message", e.getLocalizedMessage());
            map.put("result", false);
        }

        return map;
    }
}
