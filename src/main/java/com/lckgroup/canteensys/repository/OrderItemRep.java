package com.lckgroup.canteensys.repository;

import com.lckgroup.canteensys.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRep extends JpaRepository<OrderItem,Long> {
}
