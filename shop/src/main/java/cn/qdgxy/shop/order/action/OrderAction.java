package cn.qdgxy.shop.order.action;

import cn.qdgxy.shop.cart.vo.Cart;
import cn.qdgxy.shop.cart.vo.CartItem;
import cn.qdgxy.shop.order.service.OrderService;
import cn.qdgxy.shop.order.vo.Order;
import cn.qdgxy.shop.order.vo.OrderItem;
import cn.qdgxy.shop.user.vo.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Date;

@Controller
public class OrderAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    @Resource
    private OrderService orderService;

    private String msg; // 提示信息
    private Order order; // 订单

    /**
     * 添加订单
     *
     * @return
     */
    public String add() {
        order = new Order();
        // 封装订单信息
        User user = (User) ActionContext.getContext().getSession().get("user");
        order.setUser(user); // 设置所属用户
        order.setName(user.getName()); // 设置收货人姓名
        order.setPhone(user.getPhone());// 设置收货人手机
        order.setAddress(user.getAddress());// 设置收货人地址
        order.setOtime(new Date()); // 设置订单时间
        order.setState(1); // 设置订单状态
        Cart cart = (Cart) ActionContext.getContext().getSession().get("cart");
        order.setTotal(cart.getTotal()); // 设置总计

        // 封装订单项
        for (CartItem cartItem : cart.getCartItems()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(cartItem.getProduct()); // 设置商品
            orderItem.setCount(cartItem.getCount()); // 数量
            orderItem.setSubtotal(cartItem.getSubtotal()); // 小计
            orderItem.setOrder(order); // 设置所属订单

            order.getOrderItems().add(orderItem); // 订单添加订单项
        }

        // 保存订单
        Integer oid = orderService.add(order);

        // 查找保存的订单
        orderService.findById(oid);

        // 清空购物车
        cart.clear();
        return "add_success";
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public String getMsg() {
        return msg;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

}
