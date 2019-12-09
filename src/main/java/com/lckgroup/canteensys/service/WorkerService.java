package com.lckgroup.canteensys.service;

import com.lckgroup.canteensys.entity.Dish;
import com.lckgroup.canteensys.entity.Orders;
import com.lckgroup.canteensys.service.impl.DishServiceImpl;

import java.util.List;

/**
 * 工作人员查看接口
 */
public interface WorkerService {
    void deleteByDishId(Long dishid) ;



    //查找所有菜
    List<Dish> findAllDish();

    //通过id查找某个菜
    Dish findByDishId(Long dishId);
    //查找所有被投诉订单
    List<Orders> findByIsDoneTrue();

    //修改菜后更新
    Dish reviseDish(Dish dish);
    //创建新菜
    Dish CreateDish(Dish dish);
    //修改订单状态
    Orders reviseOrders(Orders orders);

}
