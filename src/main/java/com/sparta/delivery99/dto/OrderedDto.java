package com.sparta.delivery99.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class OrderedDto {
    private String name;
    private Long quantity;
    private Long price;

    public OrderedDto (String name, Long quantity, Long price){
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
