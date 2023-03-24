package com.ChinaMarket.Ecommerce.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomerRequestDto {

    private String name;

    private int age;

    private String email;

    private int mobNo;

}
