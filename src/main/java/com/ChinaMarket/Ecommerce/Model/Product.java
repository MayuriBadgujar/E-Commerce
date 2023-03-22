package com.ChinaMarket.Ecommerce.Model;

import com.ChinaMarket.Ecommerce.Enum.ProductCategory;
import com.ChinaMarket.Ecommerce.Enum.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    private String productName;

    private int price;

    private String quantity;

    @Enumerated(EnumType.STRING)
    ProductCategory productCategory;

    @Enumerated(EnumType.STRING)
    ProductStatus productStatus;

    //first relationship between parent to child
    //seller to product ( seller is parent and child is product)
    //one to many(@ManyToOne many is child class and one is parent class
    //first mapping in child class
    @ManyToOne
    @JoinColumn
    Seller seller;

    //bidirectional mapping
    //Relationship between product and item is one to one
    //product is parent and item is child
    @OneToOne(mappedBy ="product ",cascade = CascadeType.ALL)
    Item item;

}
