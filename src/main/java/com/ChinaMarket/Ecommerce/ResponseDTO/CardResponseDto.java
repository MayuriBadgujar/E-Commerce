package com.ChinaMarket.Ecommerce.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardResponseDto {
     private String name;

     List<CardDto> cardDtos;

}
