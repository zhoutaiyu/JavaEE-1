package cn.qdgxy.shop.category.dao;

import cn.qdgxy.shop.category.vo.Category;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class CategoryDao extends HibernateDaoSupport {

    @Resource
    private HibernateTemplate hibernateTemplate;

    /**
     * 查询所有一级分类
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Category> findAll() {
        return (List<Category>) this.getHibernateTemplate().find(
                "from Category where is_del=0");
    }

}
