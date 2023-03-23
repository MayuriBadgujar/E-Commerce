package com.ChinaMarket.Ecommerce.Controller;

import com.ChinaMarket.Ecommerce.Exception.SellerNotFoundException;
import com.ChinaMarket.Ecommerce.RequestDTO.ProductRequestDto;
import com.ChinaMarket.Ecommerce.ResponseDTO.ProductResponseDto;
import com.ChinaMarket.Ecommerce.Service.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody ProductRequestDto productRequestDto){

      ProductResponseDto productResponseDto;

        try {
            productResponseDto = productService.addProduct(productRequestDto);
        }
         catch (Exception e) {
           return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(productResponseDto,HttpStatus.ACCEPTED);
    }
}
