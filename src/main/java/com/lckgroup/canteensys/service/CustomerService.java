package com.lckgroup.canteensys.service;

import com.lckgroup.canteensys.entity.Customer;
import com.lckgroup.canteensys.entity.Dish;

import java.util.List;

/**
 * 顾客服务接口
 */
public interface CustomerService {
    Customer findByCusId(String cusId);
    Customer createCustomer(Customer customer);
    List<Customer> findAllCustomer();
    List<Dish> findAllDish();
}
