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
     * @param productQueryVo 查询条件
     * @return 商品包装类
     * @throws Exception 异常
     */
    List<ProductCustom> findProductList(ProductQueryVo productQueryVo) throws Exception;

    /**
     * 根据商品id查询商品信息
     *
     * @param id id
     * @return 商品包装类
     * @throws Exception 异常
     */
    ProductCustom findProductById(Integer id) throws Exception;

    /**
     * 定义service接口，遵循单一职责，将业务参数细化 （不要使用包装类型，比如map）
     *
     * @param productCustom 修改商品的信息
     * @throws Exception 异常
     */
    void updateProduct(Integer id, ProductCustom productCustom) throws Exception;

}
