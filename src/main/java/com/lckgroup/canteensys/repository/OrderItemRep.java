package com.lckgroup.canteensys.repository;

import com.lckgroup.canteensys.entity.OrderItem;
import com.lckgroup.canteensys.util.itemInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface OrderItemRep extends JpaRepository<OrderItem,Long> {
    List<OrderItem> findByOrderId(Long OrderId);

    @Query(value = "select new com.lckgroup.canteensys.util.itemInfo(d.dishId,o.orderId,d.dishName,o.dishNum,o.dishPrice,o.dishStar) from Dish d , OrderItem o where d.dishId=o.dishId and o.orderId=?1 ")
    List<itemInfo>  selectItemInfos(Long orderId);

    List<OrderItem> findByDishId(Long dish);
}
