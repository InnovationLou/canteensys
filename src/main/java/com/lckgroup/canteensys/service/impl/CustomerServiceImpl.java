package com.lckgroup.canteensys.service.impl;

import com.lckgroup.canteensys.entity.Customer;
import com.lckgroup.canteensys.entity.Dish;
import com.lckgroup.canteensys.repository.CustomerRep;
import com.lckgroup.canteensys.repository.DishRep;
import com.lckgroup.canteensys.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRep customerRep;

    @Autowired
    private DishRep dishRep;


    @Override
    public Customer findByCusId(String cusId) {
        return customerRep.findByCusId(cusId);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRep.save(customer);
    }

    @Override
    public List<Customer> findAllCustomer() {
        return customerRep.findAll();
    }

    @Override
    public List<Dish> findAllDish() {
        return dishRep.findAllByIsSellingTrue();
    }


}
