package com.lckgroup.canteensys.service;


import com.lckgroup.canteensys.entity.OrderItem;
import com.lckgroup.canteensys.util.itemInfo;

import java.util.List;

public interface OrderItemService {
    //创建新条目并对菜品数量做修改
    void creatOrderItem(OrderItem orderItem);

    List<itemInfo> findByOrderId(String orderId);
    //根据dishId查找orderItem
    List<OrderItem> findByDishId(Long dishId);

    void updateOrderItem(OrderItem orderItem);
}
