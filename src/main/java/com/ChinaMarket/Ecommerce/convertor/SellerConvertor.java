package com.ChinaMarket.Ecommerce.convertor;

import com.ChinaMarket.Ecommerce.Model.Seller;
import com.ChinaMarket.Ecommerce.RequestDTO.SellerRequestDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SellerConvertor {

    //a class which has all the functions as static------
    //this type of class is called utility class
    //utility class cant be initialised
    //@UtilityClass
    public static Seller sellerRequestToSeller(SellerRequestDTO sellerRequestDTO){
        return Seller.builder()
                .name(sellerRequestDTO.getName())
                .email(sellerRequestDTO.getEmail())
                .mobNo(sellerRequestDTO.getMobNo())
                .panNo(sellerRequestDTO.getPanNo())
                .build();
    }
}
