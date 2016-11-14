package cn.qdgxy.sss.controller;

import cn.qdgxy.sss.exception.MyException;
import cn.qdgxy.sss.po.User;
import cn.qdgxy.sss.po.UserCustom;
import cn.qdgxy.sss.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 登录
     *
     * @return String
     * @throws Exception Exception
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() throws Exception {
        return "login";
    }

    /**
     * 登录提交
     *
     * @param session  session
     * @param userName 用户名
     * @param password 密码
     * @return Json
     * @throws Exception Exception
     */
    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, Object> loginSubmit(HttpSession session, String userName, String password) throws Exception {
        Map<String, Object> map = new HashMap<>();

        try {
            UserCustom userCustom = userService.login(userName, password);

            map.put("code", 200);
            map.put("result", true);

            session.setAttribute("user", userCustom);
        } catch (MyException e) {
            map.put("code", 500);
            map.put("message", e.getLocalizedMessage());
            map.put("result", false);
        }

        return map;
    }

    /**
     * 退出
     *
     * @param session session
     * @return String
     * @throws Exception Exception
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) throws Exception {
        session.invalidate();
        return "login";
    }

    /**
     * 账务页
     *
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public String account(HttpSession session) throws Exception {
        User user = (User) session.getAttribute("user");

        if (user != null) {

        }

        return "account";
    }


}
