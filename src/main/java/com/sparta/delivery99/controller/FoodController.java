package com.sparta.delivery99.controller;

import com.sparta.delivery99.dto.FoodDto;
import com.sparta.delivery99.model.Food;
import com.sparta.delivery99.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;

    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void registerFood(@PathVariable Long restaurantId, @RequestBody List<FoodDto> foodDtoList){
        foodService.serviceRegisterFood(restaurantId, foodDtoList);
    }

    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<Food> getRestaurantFoods(@PathVariable Long restaurantId){
        return foodService.serviceGetRestaurantFoods(restaurantId);
    }
}
