package cn.qdgxy.sss.service.impl;

import cn.qdgxy.sss.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * ${DESCRIPTION}
 * create:2016-11-15 21:57
 *
 * @author 李欣
 * @version ${VERSION}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-dao.xml", "classpath:spring/applicationContext-service.xml"})
public class ProductServiceImplTest {

    @Resource
    private ProductService productService;

    @Test
    public void deleteById() throws Exception {
        System.out.println(productService.deleteById(1));
    }

}