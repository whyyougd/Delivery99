package com.sparta.delivery99.service;

import com.sparta.delivery99.dto.RestaurantRequestDto;
import com.sparta.delivery99.model.Restaurant;
import com.sparta.delivery99.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository repository;

    @Transactional
    public Restaurant registerRestaurant(RestaurantRequestDto requestDto){
        Restaurant restaurant = new Restaurant(requestDto);
        repository.save(restaurant);
        return restaurant;
    }

    @Transactional
    public List<Restaurant> getRestaurantList(){
        return repository.findAll();
    }
}
