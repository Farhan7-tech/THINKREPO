package com.ecom.think41ecom.Controllers;

import com.ecom.think41ecom.ProductRepo;
import com.ecom.think41ecom.Products;
import com.ecom.think41ecom.Service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
     private productService productService;

    @GetMapping("/api/products")
    public ResponseEntity<List<Products>> getProducts() {
        List<Products> products = productService.getAllproducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/api/products/{id}")
    public ResponseEntity<Products> getProductsById(@PathVariable Long id) {
        Products product = productService.getProductById(id);
        if(product == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
