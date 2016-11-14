package cn.qdgxy.sss.service;

import cn.qdgxy.sss.po.ProductCustom;

import java.util.List;

/**
 * 商品Service接口
 * create:2016-11-12 20:51
 *
 * @author 李欣
 * @version 1.0
 */
public interface ProductService {

    /**
     * 查找所有商品
     *
     * @return 所有商品
     */
    List<ProductCustom> findAllProduct() throws Exception;

}
