package cn.qdgxy.sss.service.impl;

import cn.qdgxy.sss.mapper.ProductMapperCustom;
import cn.qdgxy.sss.service.ProductService;
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

}
