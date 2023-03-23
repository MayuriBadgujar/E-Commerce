package com.ChinaMarket.Ecommerce.Repository;

import com.ChinaMarket.Ecommerce.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository <Product,Integer>{
}
