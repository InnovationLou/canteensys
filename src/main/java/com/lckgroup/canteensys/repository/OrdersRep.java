package com.lckgroup.canteensys.repository;

import com.lckgroup.canteensys.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRep extends JpaRepository<Orders,Integer> {
    List<Orders> findByCusId(String cusId);

    List<Orders> findByIsDoneTrue();

    Orders findByOrderId(Long aLong);

    int deleteByOrderId(Long orderId);
}
