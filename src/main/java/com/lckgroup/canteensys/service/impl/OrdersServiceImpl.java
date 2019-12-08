package com.lckgroup.canteensys.service.impl;

import com.lckgroup.canteensys.entity.Orders;
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
}
