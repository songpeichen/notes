package com.pojo;


import java.io.Serializable;

public class Product implements Serializable {
    private Integer id;
    private String name;
    private Integer num;
    private Double price;

    public Product() {
    }

    public Product(Integer id, String name, Integer num, Double price) {
        this.id = id;
        this.name = name;
        this.num = num;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
