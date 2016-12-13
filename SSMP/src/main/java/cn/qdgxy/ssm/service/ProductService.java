package cn.qdgxy.ssm.service;

import cn.qdgxy.ssm.po.ProductCustom;
import cn.qdgxy.ssm.po.ProductQueryVo;

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
