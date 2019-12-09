package com.lckgroup.canteensys.service.impl;

import com.lckgroup.canteensys.entity.Dish;
import com.lckgroup.canteensys.entity.OrderItem;
import com.lckgroup.canteensys.repository.DishRep;
import com.lckgroup.canteensys.repository.OrderItemRep;
import com.lckgroup.canteensys.repository.OrdersRep;
import com.lckgroup.canteensys.service.OrderItemService;
import com.lckgroup.canteensys.util.itemInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    private OrderItemRep orderItemRep;

    @Autowired
    private DishRep dishRep;

    @Override
    public void creatOrderItem(OrderItem orderItem) {
        orderItemRep.save(orderItem);
        Dish dish = dishRep.findByDishId(orderItem.getDishId());
        dish.setRemainNum(dish.getRemainNum()-orderItem.getDishNum());
        dish.setSoldNum(dish.getSoldNum()+orderItem.getDishNum());
        dishRep.save(dish);
    }

    @Override
    public List<itemInfo> findByOrderId(String orderId) {
        return orderItemRep.selectItemInfos(new Long(orderId));
    }

    @Override
    public List<OrderItem> findByDishId(Long dishId) {
        return orderItemRep.findByDishId(dishId);
    }

    @Override
    public void updateOrderItem(OrderItem orderItem) {
        orderItemRep.save(orderItem);
    }
}
