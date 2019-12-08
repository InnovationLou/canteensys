package com.lckgroup.canteensys.service;

import com.lckgroup.canteensys.entity.Orders;

import java.util.List;


public interface OrdersService {
    //通过顾客号查找此人所有订单信息
    List<Orders> findOrdersByCusId(String cusId);
}
