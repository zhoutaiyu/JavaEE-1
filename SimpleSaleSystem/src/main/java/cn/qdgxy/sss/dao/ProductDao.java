package cn.qdgxy.sss.dao;

import cn.qdgxy.sss.po.ProductCustom;

import java.util.List;

/**
 * 商品Dao接口
 * create:2016-11-13 21:46
 *
 * @author 李欣
 * @version 1.0
 */
public interface ProductDao {

    /**
     * 查找所有商品
     *
     * @return 所有商品
     */
    List<ProductCustom> findAllProduct() throws Exception;

}
