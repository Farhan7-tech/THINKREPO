package com.ecom.think41ecom.Service;

import com.ecom.think41ecom.ProductRepo;
import com.ecom.think41ecom.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class productService {

    @Autowired
    private ProductRepo productRepo;

    public List<Products> getAllproducts() {
        List<Products> products = productRepo.findAll();
        return products;
    }

    public Products getProductById(Long id) {
        Products product =  productRepo.findById(id).get();
        if(product == null){
            return null;
        }
        return product;
    }
}
