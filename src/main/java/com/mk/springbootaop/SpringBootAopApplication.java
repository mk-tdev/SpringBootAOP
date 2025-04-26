package com.mk.springbootaop;

import com.mk.springbootaop.dao.LowCostProductDAO;
import com.mk.springbootaop.dao.ProductDAO;
import com.mk.springbootaop.model.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAopApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ProductDAO productDAO, LowCostProductDAO lowCostProductDAO) {
        return runner -> {
            System.out.println("Starter");
            TestTheAdvices(productDAO);
//            TestLowCostProductDAO(lowCostProductDAO);
        };
    }

    private void TestLowCostProductDAO(LowCostProductDAO lowCostProductDAO) {
        lowCostProductDAO.addProduct();
        lowCostProductDAO.getProduct();
    }

    private void TestTheAdvices(ProductDAO productDAO) {
//        productDAO.addProduct();
//        productDAO.addProductDetail();
//        productDAO.addProduct(Product.builder().id(2).name("John").price(20.0).stock(10).build(), true);

//        productDAO.getProduct();
        Product product = productDAO.getProductDetail();
        try {
            productDAO.getProductDetail(12);
        } catch (Exception e) {
            System.out.println("Exception: ");
        }
    }
}

