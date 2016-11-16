package cn.qdgxy.sss.service.impl;

import cn.qdgxy.sss.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * ${DESCRIPTION}
 * create:2016-11-16 14:32
 *
 * @author 李欣
 * @version ${VERSION}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-dao.xml", "classpath:spring/applicationContext-service.xml"})
public class OrderServiceImplTest {

    @Resource
    private OrderService orderService;

    @Test
    public void buyProduct() throws Exception {
        orderService.buyProduct(0, 10);
    }

}