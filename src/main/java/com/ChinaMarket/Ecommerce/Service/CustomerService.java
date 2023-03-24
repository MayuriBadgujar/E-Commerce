package com.ChinaMarket.Ecommerce.Service;

import com.ChinaMarket.Ecommerce.Model.Cart;
import com.ChinaMarket.Ecommerce.Model.Customer;
import com.ChinaMarket.Ecommerce.Repository.CustomerRepository;
import com.ChinaMarket.Ecommerce.RequestDTO.CustomerRequestDto;
import com.ChinaMarket.Ecommerce.convertor.CustomerConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    public String addCustomer(CustomerRequestDto customerRequestDto){
        Customer customer= CustomerConvertor.CustomerRequestDtoToCustomer(customerRequestDto);

        //allocate a cart to customer
        Cart cart=new Cart();
        cart.setCartTotal(0);
        cart.setCustomer(customer);

        //set cart in customer

        customer.setCart(cart);
        customerRepository.save(customer);

        return "Congrats!! Welcome to China Market.";
    }
}
