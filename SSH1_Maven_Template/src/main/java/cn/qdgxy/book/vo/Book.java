package cn.qdgxy.book.vo;

import java.io.Serializable;

public class Book implements Serializable {

    private Integer bid;
    private String name;
    private Double price;

    public Book() {
        super();
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book [bid=" + bid + ", name=" + name + ", price=" + price + "]";
    }

}
