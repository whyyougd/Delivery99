package com.sparta.delivery99.repository;

import com.sparta.delivery99.model.Food;
import com.sparta.delivery99.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food, Long> {
    List<Food> findAllByRestaurant(Restaurant restaurant);

    Optional<Food> findByNameAndRestaurant(String name, Restaurant restaurant);

}
