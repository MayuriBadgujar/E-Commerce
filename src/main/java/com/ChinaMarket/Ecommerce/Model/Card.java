package com.ChinaMarket.Ecommerce.Model;

import com.ChinaMarket.Ecommerce.Enum.CardType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(unique = true)
    private String cardNo;

    private int cvv;

    @Enumerated(EnumType.STRING)
    private CardType cardType;


    //Relationship between customer to card is one to many
    //customer is parent and card is child
    @ManyToOne
    @JoinColumn
    Customer customer;


}
