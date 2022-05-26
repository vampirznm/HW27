package Dao;

import Dao.entity.Product;

import Dao.entityservice.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
@EnableCaching
public class ShopApplication {

    private static final Logger log = LoggerFactory.getLogger(ShopApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ShopApplication.class, args);
        ProductService productService = context.getBean(ProductService.class);

        Product product = new Product();
        product.setCost(50L);
        product.setName("Book");

        productService.createProduct(product);
        log.info("Product 1: {}", productService.getProductById(1L));

        Product productUpd = productService.getProductById(1L);
        productUpd.setCost(33L);
        productService.update(productUpd);

        log.info("Product 1 UPDATED: {}", productService.getProductById(1L));

    }

}