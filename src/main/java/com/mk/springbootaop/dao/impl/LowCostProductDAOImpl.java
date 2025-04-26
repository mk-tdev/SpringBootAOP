package com.mk.springbootaop.dao.impl;

import com.mk.springbootaop.dao.LowCostProductDAO;
import com.mk.springbootaop.model.Product;
import org.springframework.stereotype.Repository;

@Repository
public class LowCostProductDAOImpl implements LowCostProductDAO {
    @Override
    public void addProduct() {
        System.out.println(getClass() + ": doing add product.");
    }

    @Override
    public Product getProduct() {
        System.out.println(getClass() + ": doing get product detail.");
        return Product.builder()
                .id(1)
                .name("Java")
                .price(20.0)
                .stock(100)
                .build();
    }
}
