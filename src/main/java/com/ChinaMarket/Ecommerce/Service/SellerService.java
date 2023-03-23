package com.ChinaMarket.Ecommerce.Service;

import com.ChinaMarket.Ecommerce.Model.Seller;
import com.ChinaMarket.Ecommerce.Repository.SellerRepository;
import com.ChinaMarket.Ecommerce.RequestDTO.SellerRequestDTO;
import com.ChinaMarket.Ecommerce.convertor.SellerConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {
    @Autowired
    SellerRepository sellerRepository;

    public String addSeller(SellerRequestDTO sellerRequestDTO){

        //creating object
        //replacement of new keyword
        Seller seller= SellerConvertor.sellerRequestToSeller(sellerRequestDTO);
        sellerRepository.save(seller);

        return "Congratulations! Now you can sell on china Market !!!!!";




    }
}
