package com.mk.springbootaop.dao.impl;

import com.mk.springbootaop.dao.ProductDAO;
import com.mk.springbootaop.model.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOImpl implements ProductDAO {
    @Override
    public void addProduct() {
        System.out.println(getClass() + ": doing add product.");
    }

    @Override
    public void addProductDetail() {
        System.out.println(getClass() + ": doing add product detail.");
    }

    @Override
    public void addProduct(Product product, Boolean specialProduct) {
        System.out.println(getClass() + ": doing add product with product name: with special product: " + specialProduct);
    }

    @Override
    public void getProduct() {
        System.out.println(getClass() + ": doing get product.");
    }

    @Override
    public Product getProductDetail() {
        System.out.println(getClass() + ": doing get product detail.");

        Product product = new Product();
        product.setId(1);
        product.setName("test");
        product.setPrice(1.0);
        product.setStock(100);

        return product;

//        return Product.builder()
//                .id(1)
//                .name("Java")
//                .price(20.0)
//                .stock(100)
//                .build();
    }

    @Override
    public Product getProductDetail(Integer id) {
        System.out.println(getClass() + ": doing get product detail with id: " + id);

        throw new RuntimeException("sample runtime exception");
    }
}
