package cn.qdgxy.sss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * FreeMarker
 * create:2016-11-12 18:24
 *
 * @author 李欣
 * @version 1.0
 */
@Controller
@RequestMapping("/FreeMarker")
public class FreeMarkerController {

    @RequestMapping("/user")
    public ModelAndView Add(HttpServletRequest request, HttpServletResponse response) {

        User user = new User();
        user.setUsername("zhangsan");
        user.setSex("男");
        List<User> users = new ArrayList<User>();
        users.add(user);

        return new ModelAndView("user", "users", users);
    }

}
