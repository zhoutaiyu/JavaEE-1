package cn.qdgxy.sss.controller;

import cn.qdgxy.sss.po.User;
import cn.qdgxy.sss.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 订单Controller
 * create:2016-11-12 20:58
 *
 * @author 李欣
 * @version 1.0
 */
@Controller
public class OrderController {

    @Resource
    private OrderService orderService;

    /**
     * 账务页
     *
     * @param model   model
     * @param session session
     * @return String
     * @throws Exception Exception
     */
    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public String account(Model model, HttpSession session) throws Exception {
        User user = (User) session.getAttribute("user");

        if (user != null) {
            model.addAttribute("buyList", orderService.findOrderByUid(user.getId()));
        }

        return "account";
    }

}
