package com.sparta.delivery99.repository;

import com.sparta.delivery99.model.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedRepository extends JpaRepository<FoodOrder, Long> {
}
