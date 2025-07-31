package com.ecom.think41ecom;

import org.apache.commons.csv.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.*;
import java.util.*;


import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

@Service
public class CsvProductLoad {

    @Autowired
    private ProductRepo productRepo;


    public void loadProducts(String csvPath) throws IOException {
        try (Reader reader = new FileReader(csvPath)) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);
            List<Products> products = new ArrayList<>();
            for (CSVRecord csvRow : records) {
                Products product = new Products();
                product.setId(Long.parseLong(csvRow.get("id"))); // This line is crucial
                product.setBrand(csvRow.get("brand"));
                product.setCategory(csvRow.get("category"));
                product.setCost(Double.parseDouble(csvRow.get("cost")));
                product.setDepartment(csvRow.get("department"));
                product.setDistributionCenterId(Integer.parseInt(csvRow.get("distribution_center_id")));
                product.setName(csvRow.get("name"));
                product.setRetailPrice(Double.parseDouble(csvRow.get("retail_price")));
                product.setSku(csvRow.get("sku"));
                products.add(product);
            }
            productRepo.saveAll(products);
        }

    }
}