package cn.qdgxy.shop.product.dao;

import cn.qdgxy.shop.product.vo.Product;
import cn.qdgxy.shop.utils.page.dao.PageHibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao extends HibernateDaoSupport {

    /**
     * 查询热门商品
     *
     * @return 10个商品
     */
    public List<Product> findHot() {
        return this.getHibernateTemplate().executeWithNativeSession(
                new PageHibernateCallback<Product>(
                        "from Product where is_hot=? and is_del=?",
                        new Object[]{1, 0}, 0, 10));
    }

    /**
     * 查找最新商品
     *
     * @return 10个商品
     */
    public List<Product> findNew() {
        return this.getHibernateTemplate().executeWithNativeSession(
                new PageHibernateCallback<Product>(
                        "from Product where is_del=? order by ptime desc",
                        new Object[]{0}, 0, 10));
    }

    /**
     * 查询一级分类总商品数
     *
     * @param cid 一级分类ID
     * @return 一级分类总商品数
     */
    @SuppressWarnings("unchecked")
    public Integer findCountByCategory(Integer cid) {
        String hql = "select count(*) from Product p join p.categorySecond cs join cs.category c where c.cid=? and p.is_del=?";
        List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql,
                cid, 0);
        return list.get(0).intValue();
    }

    /**
     * 查询一级分类商品
     *
     * @param cid        一级分类ID
     * @param pageNumber 页码
     * @param pageSize   每页显示数量
     * @return 商品List
     */
    public List<Product> findByCategory(Integer cid, int pageNumber,
                                        int pageSize) {
        String hql = "select p from Product p join p.categorySecond cs join cs.category c where c.cid=? and p.is_del=?";
        return this.getHibernateTemplate().executeWithNativeSession(
                new PageHibernateCallback<Product>(hql, new Object[]{
                        cid, 0}, (pageNumber - 1) * pageSize, pageSize));
    }

    /**
     * 查询二级分类总商品数
     *
     * @param csid 二级分类ID
     * @return 二级分类总商品数
     */
    @SuppressWarnings("unchecked")
    public Integer findCountByCategorySecond(Integer csid) {
        String hql = "select count(*) from Product p join p.categorySecond cs where cs.csid=? and p.is_del=?";
        List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql,
                csid, 0);
        return list.get(0).intValue();
    }

    /**
     * 查询二级分类商品
     *
     * @param csid       二级分类ID
     * @param pageNumber 页码
     * @param pageSize   每页显示的数量
     * @return 商品List
     */
    public List<Product> findByCategorySecond(Integer csid, int pageNumber,
                                              int pageSize) {
        String hql = "select p from Product p join p.categorySecond cs where cs.csid=? and p.is_del=?";
        return this.getHibernateTemplate()
                .executeWithNativeSession(
                        new PageHibernateCallback<Product>(hql, new Object[]{
                                csid, 0}, (pageNumber - 1) * pageSize,
                                pageSize));
    }

    /**
     * 加载商品详情
     *
     * @param pid 商品ID
     * @return 商品
     */
    public Product findById(Integer pid) {
        return this.getHibernateTemplate().get(Product.class, pid);
    }

}
