package com.lckgroup.canteensys.service.impl;

import com.lckgroup.canteensys.entity.Dish;
import com.lckgroup.canteensys.repository.DishRep;
import com.lckgroup.canteensys.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {
    @Autowired
    private DishRep dishRep;

    @Override
    public List<Dish> findTodayDish(Integer sellingWeekDay) {
        return dishRep.findAllBySellWeekDay(sellingWeekDay);
    }

    @Override
    public Dish findByDishId(Long dishId) {
        return dishRep.findByDishId(dishId);
    }

    @Override
    public List<Dish> findDish() {
        return dishRep.findAllByDishIdTrue();
    }

    @Override
    public void creatDish(Dish dish) {
        dishRep.save(dish);
    }
}
