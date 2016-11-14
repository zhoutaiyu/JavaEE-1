package cn.qdgxy.sss.mapper;

import cn.qdgxy.sss.po.ProductCustom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * ${DESCRIPTION}
 * create:2016-11-14 18:20
 *
 * @author 李欣
 * @version ${VERSION}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-dao.xml"})
public class ProductCustomMapperTest {

    @Resource
    private ProductCustomMapper productCustomMapper;


    @Test
    public void findProduct() throws Exception {
        List<ProductCustom> productCustomList = productCustomMapper.findAllProduct();

        for (ProductCustom productCustom : productCustomList) {
            System.out.println("id:" + productCustom.getId());
            System.out.println("getIsBuy:" + productCustom.getIsBuy());
        }

    }

}