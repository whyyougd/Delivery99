package com.sparta.delivery99.controller;


import com.sparta.delivery99.dto.RestaurantRequestDto;
import com.sparta.delivery99.model.Restaurant;
import com.sparta.delivery99.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    @PostMapping("/restaurant/register")
    public Restaurant saveRestaurant (@RequestBody RestaurantRequestDto restaurantRequestDto){
        return restaurantService.registerRestaurant(restaurantRequestDto);
    }

    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurant (){

        return restaurantService.getRestaurantList();
    }
}
