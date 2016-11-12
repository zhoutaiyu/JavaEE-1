package cn.qdgxy.sss.po;

import java.io.Serializable;

public class Trx implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer contentid;
    private Integer personid;
    private Integer price;
    private Long time;

    public Trx(Integer id, Integer contentid, Integer personid, Integer price, Long time) {
        this.id = id;
        this.contentid = contentid;
        this.personid = personid;
        this.price = price;
        this.time = time;
    }

    public Trx() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getContentid() {
        return contentid;
    }

    public void setContentid(Integer contentid) {
        this.contentid = contentid;
    }

    public Integer getPersonid() {
        return personid;
    }

    public void setPersonid(Integer personid) {
        this.personid = personid;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}