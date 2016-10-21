package cn.qdgxy.shop.categorysecond.vo;

import cn.qdgxy.shop.category.vo.Category;
import cn.qdgxy.shop.product.vo.Product;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 二级分类
 *
 * @author 李欣
 */
public class CategorySecond implements Serializable {

    private Integer csid; // 二级分类ID
    private String csname; // 二级分类名
    private String cstime; // 二级分类时间
    private Integer is_del; // 是否删除

    private Category category; // 所属一级分类
    private Set<Product> products = new HashSet<Product>(); // 二级分类下的商品

    public CategorySecond() {
        super();
    }

    public Integer getCsid() {
        return csid;
    }

    public void setCsid(Integer csid) {
        this.csid = csid;
    }

    public String getCsname() {
        return csname;
    }

    public void setCsname(String csname) {
        this.csname = csname;
    }

    public String getCstime() {
        return cstime;
    }

    public void setCstime(String cstime) {
        this.cstime = cstime;
    }

    public Integer getIs_del() {
        return is_del;
    }

    public void setIs_del(Integer is_del) {
        this.is_del = is_del;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "CategorySecond [csid=" + csid + ", csname=" + csname
                + ", cstime=" + cstime + ", is_del=" + is_del + "]";
    }

}
