package cn.qdgxy.shop.category.dao;

import cn.qdgxy.shop.category.vo.Category;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CategoryDao extends HibernateDaoSupport {

    /**
     * 查询所有一级分类
     *
     * @return 分类List
     */
    @SuppressWarnings("unchecked")
    public List<Category> findAll() {
        return (List<Category>) this.getHibernateTemplate().find(
                "from Category where is_del=0");
    }

}
