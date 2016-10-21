package cn.qdgxy.shop.category.dao;

import cn.qdgxy.shop.category.vo.Category;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;


@Repository
public class CategoryDao {

    @Resource
    private HibernateTemplate hibernateTemplate;

    /**
     * 查询所有一级分类
     *
     * @return 分类List
     */
    @SuppressWarnings("unchecked")
    public List<Category> findAll() {
        return (List<Category>) hibernateTemplate.find(
                "from Category where is_del=0");
    }

}
