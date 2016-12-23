package cn.qdgxy.ssmp.mapper;

import cn.qdgxy.ssmp.po.ProductCustom;
import cn.qdgxy.ssmp.po.ProductQueryVo;

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