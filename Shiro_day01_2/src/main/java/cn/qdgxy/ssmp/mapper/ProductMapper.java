package cn.qdgxy.ssmp.mapper;

import cn.qdgxy.ssmp.po.Product;
import cn.qdgxy.ssmp.po.ProductCustom;
import cn.qdgxy.ssmp.po.ProductQueryVo;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author liXin
 * @since 2016-12-23
 */
public interface ProductMapper extends BaseMapper<Product> {

    /**
     * 商品查询
     *
     * @param productQueryVo 查询条件
     * @return 商品包装类
     */
    List<ProductCustom> findProductList(ProductQueryVo productQueryVo);

}