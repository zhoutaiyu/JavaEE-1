package cn.qdgxy.ssm.service.impl;

import cn.qdgxy.ssm.mapper.ProductMapper;
import cn.qdgxy.ssm.po.Product;
import cn.qdgxy.ssm.service.ProductService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author liXin
 * @since 2016-12-14
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
