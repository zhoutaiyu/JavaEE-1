package cn.qdgxy.ssm.service.impl;

import cn.qdgxy.ssm.exception.CustomException;
import cn.qdgxy.ssm.mapper.ProductMapper;
import cn.qdgxy.ssm.mapper.ProductMapperCustom;
import cn.qdgxy.ssm.po.Product;
import cn.qdgxy.ssm.po.ProductCustom;
import cn.qdgxy.ssm.po.ProductQueryVo;
import cn.qdgxy.ssm.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品Service实现
 * create:2016-10-30 20:33
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
    private ProductMapperCustom productMapperCustom;

    /**
     * 商品查询
     *
     * @param productQueryVo 查询条件
     * @return 商品包装类
     */
    @Override
    public List<ProductCustom> findProductList(ProductQueryVo productQueryVo) throws Exception {
        return productMapperCustom.findProductList(productQueryVo);
    }

    /**
     * 根据商品id查询商品信息
     *
     * @param id id
     * @return 商品包装类
     * @throws Exception 异常
     */
    @Override
    public ProductCustom findProductById(Integer id) throws Exception {
        Product product = productMapper.selectByPrimaryKey(id);

        if (product == null) {
            throw new CustomException("此商品信息不存在");
        }

        //在这里随着需求的变量，需要查询商品的其它的相关信息，返回到controller
        ProductCustom productCustom = new ProductCustom();
        //将product的属性拷贝到productCustom
        BeanUtils.copyProperties(product, productCustom);

        return productCustom;
    }

    /**
     * @param productCustom 商品包装类
     * @throws Exception 异常
     */
    @Override
    public void updateProduct(Integer id, ProductCustom productCustom) throws Exception {
        // 写业务代码

        //对于关键业务数据的非空校验
        if (productCustom.getId() == null) {
            //抛出异常，提示调用接口的用户，id不能为空
            //...
        }

        productMapper.updateByPrimaryKeyWithBLOBs(productCustom);
    }

}
