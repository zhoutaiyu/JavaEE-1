package cn.qdgxy.shop.categorysecond.dao;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class CategorySecondDao {

    @Resource
    private HibernateTemplate hibernateTemplate;

}
