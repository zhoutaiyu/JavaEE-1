package cn.qdgxy.sss.controller;

import cn.qdgxy.sss.exception.MyException;
import cn.qdgxy.sss.po.User;
import cn.qdgxy.sss.service.OrderService;
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
     * @param session session
     * @return 账务页
     * @throws Exception Exception
     */
    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public ModelAndView account(HttpSession session) throws Exception {
        User user = (User) session.getAttribute("user");
        return new ModelAndView("account", "buyList", orderService.findOrderByUid(user.getId()));
    }

    /**
     * 购买商品
     *
     * @param session session
     * @param id      商品ID
     * @return Json
     * @throws Exception Exception
     */
    @RequestMapping(value = "/api/buy", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, Object> buyProduct(HttpSession session, Integer id) throws Exception {
        User user = (User) session.getAttribute("user");
        Map<String, Object> map = new HashMap<>();

        try {
            orderService.buyProduct(user.getId(), id);

            // 购买成功
            map.put("code", 200);
            map.put("result", true);
        } catch (MyException e) {   // 购买失败
            map.put("code", 500);
            map.put("message", e.getMessage());
            map.put("result", false);
        }

        return map;
    }

}
