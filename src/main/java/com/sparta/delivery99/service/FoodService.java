package com.sparta.delivery99.service;

import com.sparta.delivery99.dto.FoodDto;
import com.sparta.delivery99.model.Food;
import com.sparta.delivery99.model.Restaurant;
import com.sparta.delivery99.repository.FoodRepository;
import com.sparta.delivery99.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;

    public void serviceRegisterFood(Long restaurantId, List<FoodDto> foodDtoList){
        List<Food> foodList = new ArrayList<>();
        List<String> foodNameList = new ArrayList<>();

        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);
        if(restaurant==null){
            throw new IllegalArgumentException("해당 음식점이 없음");
        }
        for(FoodDto foodDto:foodDtoList){
            Food food = new Food(restaurant, foodDto);

            Optional<Food> checkFood = foodRepository.findByNameAndRestaurant(food.getName(),restaurant);
            if(checkFood.isPresent()){ // isPresent 비어있으면 false
                throw new IllegalArgumentException("기존 저장된 음식명과 중복입니다만");
            }
            else if(foodNameList.contains(food.getName())){
//            else if(food.equals(food.getName())){
                throw new IllegalArgumentException("중복된 이름 음식 존재");
            }
            foodNameList.add(food.getName());
            foodList.add(food);
//            foodRepository.save(food);
        }
        for(Food food : foodList){
            foodRepository.save(food);
        }
    }

    public List<Food> serviceGetRestaurantFoods(Long restaurantId){
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);
//        List<Food> foodList = foodRepository.findAllByRestaurant(restaurant);
//        return foodList;
        return foodRepository.findAllByRestaurant(restaurant);
    }
}
