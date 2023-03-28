package com.app.pizzashop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PizzashopApplication {

    public static void main(String[] args) {
        SpringApplication.run(PizzashopApplication.class, args);
    }
//    @Bean
//    CommandLineRunner init(StorageService storageService) {
//        return (args) -> {
////            storageService.deleteAll();
//            storageService.init();
//        };
//    }

}
