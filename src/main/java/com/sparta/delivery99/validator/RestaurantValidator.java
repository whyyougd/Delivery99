package com.sparta.delivery99.validator;

import com.sparta.delivery99.dto.RestaurantRequestDto;

public class RestaurantValidator {

    public static void validateRestaurant(RestaurantRequestDto restaurantDto){
        if(restaurantDto.getMinOrderPrice() < 1_000 || restaurantDto.getMinOrderPrice() > 100_000){
            throw new IllegalArgumentException("최소주문 가격의 허용값을 벗어났습니다.");
        }
        if(restaurantDto.getMinOrderPrice() % 100 != 0){
            throw new IllegalArgumentException("최소주문 가격이 100원 단위가 아닙니다.");
        }
        if(restaurantDto.getDeliveryFee() < 0 || restaurantDto.getDeliveryFee() > 10_000){
            throw new IllegalArgumentException("기본 배달비의 허용값을 벗어났습니다.");
        }
        if(restaurantDto.getDeliveryFee() % 500 !=0){
            throw new IllegalArgumentException("기본 배달비 가격이 100원 단위가 아닙니다.");
        }
    }
}
