package com.ecom.think41ecom;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {
    @Id
    @Column(name = "product_id", nullable = false)
    private Long id;

    private String brand;
    private String category;
    private Double cost;
    private String department;
    private Integer distributionCenterId;
    private String name;
    private Double retailPrice;
    private String sku;
}
