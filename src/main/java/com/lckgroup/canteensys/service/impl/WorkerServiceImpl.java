package com.lckgroup.canteensys.service.impl;

import com.lckgroup.canteensys.entity.Dish;
import com.lckgroup.canteensys.entity.Orders;
import com.lckgroup.canteensys.repository.DishRep;
import com.lckgroup.canteensys.repository.OrdersRep;
import com.lckgroup.canteensys.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {
    @Autowired
    private DishRep dishRep;

    @Autowired
    private OrdersRep ordersRep;





    @Override
    public void deleteByDishId(Long dishid) {

    }




    @Override
    public List<Dish> findAllDish() {
        return dishRep.findAllByIsSellingTrue();
    }


    @Override
    public Dish findByDishId(Long dishId) {
        return  dishRep.findByDishId(dishId);
    }

    @Override
    public List<Orders> findByIsDoneTrue() {
        return ordersRep.findByIsDoneTrue();
    }

    @Override
    public Dish reviseDish(Dish dish) {
        return dishRep.save(dish);
    }

    @Override
    public Dish CreateDish(Dish dish) {
        return dishRep.save(dish);
    }

    @Override
    public Orders reviseOrders(Orders orders) {
        return ordersRep.save(orders);
    }


}

