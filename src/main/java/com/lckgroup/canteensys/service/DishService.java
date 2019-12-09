package com.lckgroup.canteensys.service;

import com.lckgroup.canteensys.entity.Dish;

import java.util.List;

public interface DishService {
    //查找当前所有在售菜品
    List<Dish> findAllDish();
    //通过dishId查找菜品
    Dish findByDishId(Long dishId);

    void creatDish(Dish dish);
}
