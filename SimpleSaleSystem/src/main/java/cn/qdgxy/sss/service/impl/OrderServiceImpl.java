package cn.qdgxy.sss.service.impl;

import cn.qdgxy.sss.mapper.OrderCustomMapper;
import cn.qdgxy.sss.po.OrderCustom;
import cn.qdgxy.sss.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单Service实现
 * create:2016-11-12 20:53
 *
 * @author 李欣
 * @version 1.0
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderCustomMapper orderCustomMapper;

    /**
     * 按用户ID查找订单
     *
     * @param uid 用户ID
     * @return 订单
     */
    @Override
    public List<OrderCustom> findOrderByUid(Integer uid) {
        return orderCustomMapper.findOrderByUid(uid);
    }

}
