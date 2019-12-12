package com.lckgroup.canteensys.service;

import com.lckgroup.canteensys.entity.Dish;

import java.util.List;

public interface DishService {
    //查找当天所有在售菜品
    List<Dish> findTodayDish(Integer sellingWeekDay);

    //通过dishId查找菜品
    Dish findByDishId(Long dishId);
    //查找所有菜
    List<Dish> findDish();

    void creatDish(Dish dish);
}
