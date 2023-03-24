package com.ChinaMarket.Ecommerce.Service;

import com.ChinaMarket.Ecommerce.Enum.ProductCategory;
import com.ChinaMarket.Ecommerce.Exception.SellerNotFoundException;
import com.ChinaMarket.Ecommerce.Model.Product;
import com.ChinaMarket.Ecommerce.Repository.ProductRepository;
import com.ChinaMarket.Ecommerce.Repository.SellerRepository;
import com.ChinaMarket.Ecommerce.RequestDTO.ProductRequestDto;
import com.ChinaMarket.Ecommerce.ResponseDTO.ProductResponseDto;
import com.ChinaMarket.Ecommerce.convertor.ProductConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ChinaMarket.Ecommerce.Model.Seller;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    private ProductRepository productRepository;

    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) throws SellerNotFoundException {
        Seller seller;

        try {
            seller = sellerRepository.findById(productRequestDto.getSellerId()).get();
        } catch (Exception e) {
            throw new SellerNotFoundException("Invalid seller Id");
        }
        Product product = ProductConvertor.productRequestDtoToProduct(productRequestDto);
            product.setSeller(seller);
        seller.getProducts().add(product);

        //saved the seller and product parent and child
      sellerRepository.save(seller);

      //prepare response
      ProductResponseDto productResponseDto=ProductConvertor.productToProductResponseDto(product);
      return productResponseDto;
    }

    public List<ProductResponseDto> getProductByCategory(@PathVariable ProductCategory productCategory){


        List<Product> products=productRepository.findAllByProductCategory( productCategory);

        //prepare a list of response dtos
        List<ProductResponseDto> productResponseDtos =new ArrayList<>();
        for(Product product:products){
            ProductResponseDto productResponseDto=ProductConvertor.productToProductResponseDto(product);
            productResponseDtos.add(productResponseDto) ;


        }
        return productResponseDtos;
    }
}
