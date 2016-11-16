package cn.qdgxy.sss.service.impl;

import cn.qdgxy.sss.exception.MyException;
import cn.qdgxy.sss.mapper.OrderCustomMapper;
import cn.qdgxy.sss.mapper.OrderMapper;
import cn.qdgxy.sss.mapper.ProductMapper;
import cn.qdgxy.sss.po.Order;
import cn.qdgxy.sss.po.OrderCustom;
import cn.qdgxy.sss.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    private OrderMapper orderMapper;

    @Resource
    private OrderCustomMapper orderCustomMapper;

    @Resource
    private ProductMapper productMapper;

    /**
     * 按用户ID查找订单
     *
     * @param uid 用户ID
     * @return 订单
     */
    @Override
    public List<OrderCustom> findOrderByUid(Integer uid) throws Exception {
        return orderCustomMapper.findOrderByUid(uid);
    }

    /**
     * 购买商品
     *
     * @param uid 用户ID
     * @param pid 商品ID
     */
    @Override
    public void buyProduct(Integer uid, Integer pid) throws Exception {
        // 不能重复购买
        Order order = orderCustomMapper.findOrderByUidAndPid(uid, pid);
        if (order != null) {
            throw new MyException("重复购买!");
        }

        // 封装订单
        order = new Order();
        order.setUid(uid);
        order.setPid(pid);
        order.setBuyPrice(productMapper.selectByPrimaryKey(pid).getPrice());
        order.setBuyTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        int result = orderMapper.insert(order);
        if (result != 1) {
            throw new MyException("购买失败！");
        }
    }

}
