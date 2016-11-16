package cn.qdgxy.sss.mapper;

import cn.qdgxy.sss.po.Order;
import cn.qdgxy.sss.po.OrderCustom;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 按用户ID和产品ID查找订单
     *
     * @param uid 用户ID
     * @param pid 产品ID
     * @return 订单
     */
    Order findOrderByUidAndPid(@Param("uid") Integer uid, @Param("pid") Integer pid);

}
