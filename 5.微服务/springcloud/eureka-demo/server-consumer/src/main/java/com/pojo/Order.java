package com.pojo;


import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {
    private Long id;
    private String orderNo;
    private String orderAddress;
    private Double totalPrice;
    List<Product> productList;

    public Order() {
    }

    public Order(Long id, String orderNo, String orderAddress, Double totalPrice, List<Product> productList) {
        this.id = id;
        this.orderNo = orderNo;
        this.orderAddress = orderAddress;
        this.totalPrice = totalPrice;
        this.productList = productList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
