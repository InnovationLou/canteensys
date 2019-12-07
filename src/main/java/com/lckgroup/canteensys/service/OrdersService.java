package com.lckgroup.canteensys.service;

import com.lckgroup.canteensys.entity.Orders;

import java.util.List;


public interface OrdersService {
    List<Orders> findOrdersByCusId(String cusId);
}
