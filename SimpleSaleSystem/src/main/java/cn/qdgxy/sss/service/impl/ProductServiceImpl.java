package cn.qdgxy.sss.service.impl;

import cn.qdgxy.sss.dao.ProductDao;
import cn.qdgxy.sss.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 商品Servoce实现
 * create:2016-11-12 20:53
 *
 * @author 李欣
 * @version 1.0
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductDao contentDao;

}
