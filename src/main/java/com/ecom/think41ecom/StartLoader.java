package com.ecom.think41ecom;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StartLoader {

    @Autowired
    CsvProductLoad loader;

    @PostConstruct
    public void run() {
        try{
            loader.loadProducts("C:/Users/FARHAN-PC/Desktop/Products/products.csv");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
