package com.lckgroup.canteensys.repository;

import com.lckgroup.canteensys.entity.Customer;
import com.lckgroup.canteensys.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CustomerRep extends JpaRepository<Customer, Integer> {
    Customer findByCusId(String id);
}
