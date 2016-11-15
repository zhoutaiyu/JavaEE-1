package cn.qdgxy.sss.service.impl;

import cn.qdgxy.sss.mapper.ProductCustomMapper;
import cn.qdgxy.sss.mapper.ProductMapper;
import cn.qdgxy.sss.po.Product;
import cn.qdgxy.sss.po.ProductCustom;
import cn.qdgxy.sss.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品Service实现
 * create:2016-11-12 20:53
 *
 * @author 李欣
 * @version 1.0
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Resource
    private ProductCustomMapper productCustomMapper;

    /**
     * 查找商品
     *
     * @return 商品
     * @throws Exception 异常
     */
    @Override
    public List<ProductCustom> findAllProduct() throws Exception {
        return productCustomMapper.findAllProduct();
    }

    /**
     * 按商品ID查找商品和购买信息
     *
     * @param pid 商品ID
     * @return 商品和购买信息
     */
    @Override
    public ProductCustom findProductAndOrderById(Integer pid) throws Exception {
        return productCustomMapper.findProductAndOrderById(pid);
    }

    /**
     * 按照商品ID查找商品
     *
     * @param pid 商品ID
     * @return 商品
     */
    @Override
    public Product findProductById(Integer pid) throws Exception {
        return productMapper.selectByPrimaryKey(pid);
    }

    /**
     * 添加商品
     *
     * @param product 商品
     * @return 操作行数
     */
    @Override
    public Integer addProduct(Product product) throws Exception {
        return productMapper.insert(product);
    }

    /**
     * 修改商品
     *
     * @param product 商品
     * @return 是否成功
     */
    @Override
    public boolean updateById(Product product) throws Exception {
        try {
            int result = productMapper.updateByPrimaryKey(product);

            return result == 1;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 按ID删除商品
     *
     * @param pid 商品ID
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer pid) throws Exception {
        try {
            int result = productMapper.deleteByPrimaryKey(pid);

            return result == 1;
        } catch (Exception e) {
            return false;
        }
    }

}
