package cn.qdgxy.sss.mapper;

import cn.qdgxy.sss.po.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * ${DESCRIPTION}
 * create:2016-11-15 10:40
 *
 * @author 李欣
 * @version ${VERSION}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-dao.xml", "classpath:spring/applicationContext-service.xml"})
public class ProductMapperTest {

    @Resource
    private ProductMapper productMapper;

    @Test
    public void insert() throws Exception {
        Product product = new Product();
        product.setTitle("测试商品");

        Integer result = productMapper.insert(product);
        System.out.println("id:" + product.getId());
    }

    @Test
    public void deleteByPrimaryKey() throws Exception {
        System.out.println(productMapper.deleteByPrimaryKey(100));
    }


}