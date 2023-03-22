package com.ChinaMarket.Ecommerce.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    private int requiredQuantity ;


    //Relationship between cart and item is one to many
    //cart is parent and item is child
    @ManyToOne
    @JoinColumn
    Cart cart;

    //Relationship between product and item is one to one
    //product is parent and item is child
    @OneToOne
    @JoinColumn
    Product product;

    //Relationship between ordered and items is one to many
    //order is parent and item is child
    @ManyToOne
    @JoinColumn
    Ordered order;
}
