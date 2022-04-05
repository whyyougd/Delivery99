package com.sparta.delivery99.repository;

import com.sparta.delivery99.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository <Restaurant, Long> {
//    List<Restaurant> findAllByOrderById();
}
