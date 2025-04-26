package com.mk.springbootaop.model;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Product {
    private int id;
    private String name;
    private double price;
    private int stock;
}
