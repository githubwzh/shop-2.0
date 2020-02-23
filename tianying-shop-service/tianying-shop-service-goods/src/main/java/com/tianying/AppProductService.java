package com.tianying;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = {"com.tianying.product.es"})
public class AppProductService {

    public static void main(String[] args) {
        SpringApplication.run(AppProductService.class, args);
    }

}
