package cn.qdgxy.sss.sss.po;

import java.io.Serializable;

public class Product implements Serializable {
    private Integer id;

    private Double price;

    private String title;

    private String image;

    private String summary;

    private byte[] detail;

    private static final long serialVersionUID = 1L;

    public Product(Integer id, Double price, String title, String image, String summary, byte[] detail) {
        this.id = id;
        this.price = price;
        this.title = title;
        this.image = image;
        this.summary = summary;
        this.detail = detail;
    }

    public Product() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public byte[] getDetail() {
        return detail;
    }

    public void setDetail(byte[] detail) {
        this.detail = detail;
    }
}