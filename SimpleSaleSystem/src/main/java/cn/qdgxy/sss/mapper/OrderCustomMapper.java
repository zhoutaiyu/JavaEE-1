package cn.qdgxy.sss.mapper;

import cn.qdgxy.sss.po.OrderCustom;

import java.util.List;

/**
 * 自定义订单Mapper
 * create:2016-11-14 21:12
 *
 * @author 李欣
 * @version 1.0
 */
public interface OrderCustomMapper {

    /**
     * 按用户ID查找订单
     *
     * @param uid 用户ID
     * @return 订单
     */
    List<OrderCustom> findOrderByUid(Integer uid);

}
