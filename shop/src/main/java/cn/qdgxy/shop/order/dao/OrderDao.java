package cn.qdgxy.shop.order.dao;

import cn.qdgxy.shop.order.vo.Order;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class OrderDao {

    @Resource
    private HibernateTemplate hibernateTemplate;

    /**
     * 保存订单
     *
     * @param order 订单
     * @return 订单ID
     */
    public Integer add(Order order) {
        return (Integer) hibernateTemplate.save(order);
    }

    /**
     * 按ID查找订单
     *
     * @param oid 订单ID
     * @return 订单
     */
    public Order findById(Integer oid) {
        return hibernateTemplate.get(Order.class, oid);
    }

}
