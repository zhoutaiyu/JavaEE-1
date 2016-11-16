package cn.qdgxy.sss.service;

import cn.qdgxy.sss.po.OrderCustom;

import java.util.List;

/**
 * 订单Service接口
 * create:2016-11-12 20:52
 *
 * @author 李欣
 * @version 1.0
 */
public interface OrderService {

    /**
     * 按用户ID查找订单
     *
     * @param uid 用户ID
     * @return 订单
     */
    List<OrderCustom> findOrderByUid(Integer uid) throws Exception;

    /**
     * 购买商品
     *
     * @param uid 用户ID
     * @param pid 商品ID
     */
    void buyProduct(Integer uid, Integer pid) throws Exception;

}
