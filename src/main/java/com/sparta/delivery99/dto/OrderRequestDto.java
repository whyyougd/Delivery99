package com.sparta.delivery99.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class OrderRequestDto {
    private Long restaurantId;
    private List<FoodOrderRequestDto> foods;
}
