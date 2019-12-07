package com.lckgroup.canteensys.service.impl;

import com.lckgroup.canteensys.entity.Orders;
import com.lckgroup.canteensys.repository.OrdersRep;
import com.lckgroup.canteensys.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersRep ordersRep;

    @Override
    public List<Orders> findOrdersByCusId(String cusId) {
        return ordersRep.findByCusId(cusId);
    }
}
