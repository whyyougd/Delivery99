package com.sparta.delivery99.validator;

import com.sparta.delivery99.dto.FoodDto;

public class FoodValidator {

    public static void validateFood(FoodDto foodDto){
        if(foodDto.getPrice() < 100 || foodDto.getPrice()> 1000000){
            throw new IllegalArgumentException("가격 범위 벗어남");
        }
        if(foodDto.getPrice()%100 !=0){
            throw new IllegalArgumentException("100원 단위가 아닙니다");
        }
    }
}
