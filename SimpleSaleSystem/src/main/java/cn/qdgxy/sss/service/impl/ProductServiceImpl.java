package cn.qdgxy.sss.service.impl;

import cn.qdgxy.sss.mapper.ProductCustomMapper;
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
     * 按id查找商品
     *
     * @param id id
     * @return 商品
     */
    @Override
    public ProductCustom findProductById(Integer id) throws Exception {
        return productCustomMapper.findProductById(id);
    }

}
