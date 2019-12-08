package com.lckgroup.canteensys.repository;

import com.lckgroup.canteensys.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRep extends JpaRepository<OrderItem,Long> {
    List<OrderItem> findByOrderId(Long OrderId);
}
