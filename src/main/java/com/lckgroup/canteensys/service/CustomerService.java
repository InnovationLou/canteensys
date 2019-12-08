package com.lckgroup.canteensys.service;

import com.lckgroup.canteensys.entity.Customer;
import com.lckgroup.canteensys.entity.Dish;

import java.util.List;

/**
 * 顾客服务接口
 */
public interface CustomerService {
    //通过顾客号查找顾客
    Customer findByCusId(String cusId);
    //创建新顾客
    Customer createCustomer(Customer customer);
    //查找所有顾客
    List<Customer> findAllCustomer();
}
