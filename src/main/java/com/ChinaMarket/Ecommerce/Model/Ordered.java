package com.ChinaMarket.Ecommerce.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="orders")
public class Ordered {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @CreationTimestamp
    private Date orderDate;

    private int totalCost;

    private int deliveryCharge;

    private String cardUsedForPayment;

    //Relationship between customer to orderd is one to many
    //customer is parent and ordered is child
    @ManyToOne
    @JoinColumn
    Customer customer;

    //Relationship between ordered and items is one to many
    //order is parent and item is child
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    List<Item> orderedItems=new ArrayList<>();

}
