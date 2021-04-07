package com.pojo;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Order implements Serializable {
    private Long id;
    private String orderNo;
    private String orderAddress;
    private Double totalPrice;
    List<Product> productList;
}
