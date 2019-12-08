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
    public List<Dish> findAllDish() {
        return dishRep.findAllByIsSellingTrue();
    }
}
