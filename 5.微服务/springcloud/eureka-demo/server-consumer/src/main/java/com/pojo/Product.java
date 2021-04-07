package com.pojo;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Product implements Serializable {
    private Integer id;
    private String name;
    private Integer num;
    private Double price;
}
