package cn.qdgxy.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 登陆和退出
 * create:2016-10-30 20:51
 * <p>
 * author 李欣
 *
 * @version 1.0
 */
@Controller
public class LoginController {

    //用户登陆提交方法
    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password) throws Exception {
        //调用service校验用户账号和密码的正确性
        //..

        //如果service校验通过，将用户身份记录到session
        session.setAttribute("username", username);
        //重定向到商品查询页面
        return "redirect:/product/findAllProduct.action";
    }

    //用户退出
    @RequestMapping("/logout")
    public String logout(HttpSession session) throws Exception {

        //session失效
        session.invalidate();
        //重定向到商品查询页面
        return "redirect:/product/findAllProduct.action";
    }

}
