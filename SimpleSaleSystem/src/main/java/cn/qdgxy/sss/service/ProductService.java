package cn.qdgxy.sss.service;

import cn.qdgxy.sss.po.Product;
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

    /**
     * 按商品ID查找商品和购买信息
     *
     * @param pid 商品ID
     * @return 商品和购买信息
     */
    ProductCustom findProductAndOrderById(Integer pid) throws Exception;

    /**
     * 按照商品ID查找商品
     *
     * @param pid 商品ID
     * @return 商品
     */
    Product findProductById(Integer pid) throws Exception;

    /**
     * 添加商品
     *
     * @param product 商品
     * @return 操作行数
     */
    Integer addProduct(Product product) throws Exception;

    /**
     * 修改商品
     *
     * @param product 商品
     * @return 是否成功
     */
    boolean updateById(Product product) throws Exception;

    /**
     * 按ID删除商品
     *
     * @param pid 商品ID
     * @return 是否成功
     */
    boolean deleteById(Integer pid) throws Exception;

}
