package cn.qdgxy.shiro.mapper;

import cn.qdgxy.shiro.po.Product;
import cn.qdgxy.shiro.po.ProductCustom;
import cn.qdgxy.shiro.po.ProductQueryVo;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author liXin
 * @since 2016-12-21
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