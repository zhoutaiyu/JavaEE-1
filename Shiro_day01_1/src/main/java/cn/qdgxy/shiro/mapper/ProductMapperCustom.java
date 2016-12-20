package cn.qdgxy.shiro.mapper;

import cn.qdgxy.shiro.po.ProductCustom;
import cn.qdgxy.shiro.po.ProductQueryVo;

import java.util.List;

public interface ProductMapperCustom {

    /**
     * 商品查询
     *
     * @param productQueryVo 查询条件
     * @return 商品包装类
     */
    List<ProductCustom> findProductList(ProductQueryVo productQueryVo);

}