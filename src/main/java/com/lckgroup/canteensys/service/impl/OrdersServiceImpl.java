package com.lckgroup.canteensys.service.impl;

import com.lckgroup.canteensys.entity.Dish;
import com.lckgroup.canteensys.entity.OrderItem;
import com.lckgroup.canteensys.entity.Orders;
import com.lckgroup.canteensys.repository.DishRep;
import com.lckgroup.canteensys.repository.OrderItemRep;
import com.lckgroup.canteensys.repository.OrdersRep;
import com.lckgroup.canteensys.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersRep ordersRep;

    @Autowired
    private OrderItemRep orderItemRep;

    @Autowired
    private DishRep dishRep;

    @Override
    public List<Orders> findOrdersByCusId(String cusId) {
        return ordersRep.findByCusId(cusId);
    }

    @Override
    public Orders creatOrders(Orders orders) {
        return ordersRep.save(orders);
    }

    @Override
    public boolean setMealTime(String orderId, String mealTime) {
        Orders orders = ordersRep.findByOrderId(new Long(orderId));
        if(orders==null||"".equals(orders)){
            return false;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            orders.setMealTime(sdf.parse(mealTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ordersRep.save(orders);
        return true;
    }

    @Override
    public Orders findOrdersByOrderId(Long orderId) {
        return ordersRep.findByOrderId(new Long(orderId));
    }

    @Override
    public boolean deleteByOrderId(Long orderId) {
        if(ordersRep.deleteByOrderId(orderId)==1){
            List<OrderItem> orderItems = orderItemRep.findByOrderId(orderId);
            if(orderItems.isEmpty()||orderItems==null){
                return false;
            }
            Dish dish = null;
            for(OrderItem orderItem:orderItems){
                dish = dishRep.findByDishId(orderItem.getDishId());
                dish.setRemainNum(dish.getRemainNum()+orderItem.getDishNum());
                dish.setSoldNum(dish.getSoldNum()-orderItem.getDishNum());
                orderItemRep.deleteById(orderItem.getId());
            }
            return  true;
        };
        return false;
    }

    @Override
    public void updateOrders(Orders orders) {
        ordersRep.save(orders);
    }
}
