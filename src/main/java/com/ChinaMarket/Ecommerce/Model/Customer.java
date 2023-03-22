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
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    private String name;

    private int age;

    @Column(unique = true)
    private  String email;

    @Column(unique = true)
    private int mobNo;

    //Relationship between customer to card is one to many
    //parent class
    //bidirectional mapping
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    List<Card> cards=new ArrayList<>();

    //Relationship between customer and cart is ont to one
    //parent class
    @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL)
    Cart cart;

    //Relationship between customer to ordered is one to many
    //parent class
    @OneToMany(mappedBy = "customer" ,cascade = CascadeType.ALL)
        List<Ordered> orders=new ArrayList<>();

}
