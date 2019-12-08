package com.lckgroup.canteensys.repository;

import com.lckgroup.canteensys.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishRep extends JpaRepository<Dish,Integer> {
    List<Dish> findAllByIsSellingTrue();
    Dish findByDishId(Long dishId);
}
