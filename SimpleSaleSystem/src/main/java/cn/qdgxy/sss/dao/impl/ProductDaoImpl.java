package cn.qdgxy.sss.dao.impl;

import cn.qdgxy.sss.dao.ProductDao;
import cn.qdgxy.sss.mapper.ProductCustomMapper;
import cn.qdgxy.sss.mapper.ProductMapper;
import cn.qdgxy.sss.po.ProductCustom;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品Dao实现
 * create:2016-11-13 21:47
 *
 * @author 李欣
 * @version 1.0
 */
@Repository
public class ProductDaoImpl implements ProductDao {

    @Resource
    private ProductMapper productMapper;

    @Resource
    private ProductCustomMapper productCustomMapper;

    /**
     * 查找所有商品
     *
     * @return 所有商品
     */
    @Override
    public List<ProductCustom> findAllProduct() throws Exception {
        return productCustomMapper.findAllProduct();
    }

}
