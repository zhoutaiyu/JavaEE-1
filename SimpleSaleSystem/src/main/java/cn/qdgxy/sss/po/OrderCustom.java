package cn.qdgxy.sss.po;

/**
 * 自定义订单
 * create:2016-11-12 20:36
 *
 * @author 李欣
 * @version 1.0
 */
public class OrderCustom extends Order {

    private String title; // 商品名
    private String image; // 商品图片

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
