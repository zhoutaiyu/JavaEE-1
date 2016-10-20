package cn.qdgxy.mybatis.mapper;

import cn.qdgxy.mybatis.po.Orders;
import cn.qdgxy.mybatis.po.User;
import cn.qdgxy.mybatis.po_extend.OrderCustom;

import java.util.List;

/**
 * 订单自定义Mapper接口<br>
 * create:2016-10-17 17:40
 *
 * @author 李欣
 * @version 1.0
 */
public interface OrdersMapperCustom {

    // 一对一查询，查询订单关联查询用户，使用resultType
    public List<OrderCustom> findOrderUserList() throws Exception;

    // 一对一查询，使用resultMap
    public List<Orders> findOrderUserListResultMap() throws Exception;

    //一对一查询，延迟加载
    public List<Orders> findOrderUserListLazyLoading() throws Exception;

    // 一对多查询，使用resultMap
    public List<Orders> findOrderAndOrderDetails() throws Exception;

    // 一对多查询，使用resultMap
    public List<User> findUserOrderDetail() throws Exception;

}
