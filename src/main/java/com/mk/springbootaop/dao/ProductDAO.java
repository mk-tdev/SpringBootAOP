package com.mk.springbootaop.dao;

import com.mk.springbootaop.model.Product;

public interface ProductDAO {
    void addProduct();
    void addProductDetail();
    void addProduct(Product product, Boolean specialProduct);
    void getProduct();
    Product getProductDetail();
    Product getProductDetail(Integer id);

    Product getSampleProduct();
}
