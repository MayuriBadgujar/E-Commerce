package com.ChinaMarket.Ecommerce.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    private int cartTotal;

    //Relationship between customer to cart is one to many
    //customer is parent and cart is child
    @OneToOne
    @JoinColumn
    Customer customer;

    //Relationship between cart to item is one to many
    //cart is parent and item is child
    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
    List<Item> items=new ArrayList<>();
}
