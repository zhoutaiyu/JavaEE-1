package cn.qdgxy.sss.po;

import java.io.Serializable;

public class Content implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Long price;
    private String title;
    private String digest;

    public Content(Integer id, Long price, String title, String digest) {
        this.id = id;
        this.price = price;
        this.title = title;
        this.digest = digest;
    }

    public Content() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest == null ? null : digest.trim();
    }
}