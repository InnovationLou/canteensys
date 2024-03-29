package com.lckgroup.canteensys.service;

import com.lckgroup.canteensys.entity.Orders;

import java.util.List;


public interface OrdersService {
    //通过顾客号查找此人所有订单信息
    List<Orders> findOrdersByCusId(String cusId);
    //创建新订单
    Orders creatOrders(Orders orders);
    //通过orderId设置预计取餐时间
    boolean setMealTime(String orderId, String mealTime);
    //通过orderId查找Orders对象
    Orders findOrdersByOrderId(Long orderId);
    //通过orderId删除未完成订单
    boolean deleteByOrderId(Long orderId);
    //更新orders
    void updateOrders(Orders orders);
}
