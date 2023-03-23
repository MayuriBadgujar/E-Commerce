package com.ChinaMarket.Ecommerce.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
//builder is used for creating object ...diff way to create object
@Table(name="seller")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    private String name;
    @Column(unique = true)
    private String mobNo;

    @Column(unique = true)
    private  String email;

    @Column(unique = true)
    private String panNo;

    //Bidirectional mapping between child to parent
    //child is product and parent is seller
    @OneToMany(mappedBy = "seller",cascade = CascadeType.ALL)
    //if we dont initialise list with new .. then it will show null  pointer exception
    List<Product> products=new ArrayList<>();


}
