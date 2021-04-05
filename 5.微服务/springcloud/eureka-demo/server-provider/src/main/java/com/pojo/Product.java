package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Product implements Serializable {
    private Integer id;
    private String name;
    private Integer num;
    private Double price;
}
