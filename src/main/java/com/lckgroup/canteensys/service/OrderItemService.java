package com.lckgroup.canteensys.service;


import com.lckgroup.canteensys.entity.OrderItem;

public interface OrderItemService {
    //创建新条目并对菜品数量做修改
    void creatOrderItem(OrderItem orderItem);
}
