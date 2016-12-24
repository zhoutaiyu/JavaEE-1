package cn.qdgxy.shiro.service;

import cn.qdgxy.shiro.po.ProductCustom;
import cn.qdgxy.shiro.po.ProductQueryVo;

import java.util.List;

/**
 * 商品Service接口
 * create:2016-10-30 20:31
 *
 * @author 李欣
 * @version 1.0
 */
public interface ProductService {

    /**
     * 商品查询
     *
     * @param productQueryVo 查询条件
     * @return 商品包装类
     */
    List<ProductCustom> findProductList(ProductQueryVo productQueryVo) throws Exception;

}
