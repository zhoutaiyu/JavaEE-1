package cn.qdgxy.ssm.mapper;

import cn.qdgxy.ssm.po.ProductCustom;
import cn.qdgxy.ssm.po.ProductQueryVo;

import java.util.List;

public interface ProductMapper {

    /**
     * 商品查询
     *
     * @param productQueryVo 查询条件
     * @return 商品包装类
     */
    List<ProductCustom> findProductList(ProductQueryVo productQueryVo);

}