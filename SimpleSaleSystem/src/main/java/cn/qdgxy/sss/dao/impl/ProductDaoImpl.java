package cn.qdgxy.sss.dao.impl;

import cn.qdgxy.sss.dao.ProductDao;
import cn.qdgxy.sss.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

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

}
