package com.lckgroup.canteensys.service.impl;

import com.lckgroup.canteensys.entity.Dish;
import com.lckgroup.canteensys.repository.DishRep;
import com.lckgroup.canteensys.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
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

    @Override
    public List<Dish> findAllSellingDishByDate() {
        String[] weekDays = { "7", "1", "2", "3", "4", "5", "6" };
        Calendar calendar = Calendar.getInstance();
        String week = weekDays[calendar.get(Calendar.DAY_OF_WEEK) - 1];
        return dishRep.findBySellWeekDayAndIsSelling(Integer.parseInt(week),true);
    }
}
