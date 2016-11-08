package cn.qdgxy.ssm.po;

import java.util.List;

/**
 * 商品查询类
 * create:2016-10-30 20:08
 *
 * @author 李欣
 * @version 1.0
 */
public class ProductQueryVo {

    private ProductCustom productCustom;

    //定义一个list
    private List<ProductCustom> productList;


    public ProductCustom getProductCustom() {
        return productCustom;
    }

    public void setProductCustom(ProductCustom productCustom) {
        this.productCustom = productCustom;
    }

    public List<ProductCustom> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductCustom> productList) {
        this.productList = productList;
    }
}
